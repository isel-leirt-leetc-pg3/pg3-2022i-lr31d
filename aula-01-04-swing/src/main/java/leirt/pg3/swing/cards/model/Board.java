package leirt.pg3.swing.cards.model;

import java.util.Random;

public class Board {
    private int lines, cols;            // board size
    private int moves;                  // count the moves needed to remove all pairs

    private CardChangedListener listener;       // who is informed about board changes

    private Card[][] cards;             // the game board

    private Card first, second;         // played cards
    private int removedCards;           // number of removed cards


    Random rand = new Random();         // random generator to produce random boards

    public Board(int lines, int cols, int nValues) {

        if (( (lines*cols) % 2 != 0))
            throw new GameException("Board must have an even cards number");
        this.lines = lines;
        this.cols = cols;

        first = null;

        moves = removedCards = 0;

        // definição da semente do gerador pseudo-aleatório
        rand.setSeed(System.currentTimeMillis());
        buildBoard(lines, cols, nValues);
    }


    private Card buildCard(int val, int line, int col) {
        return new Card(val, line, col);
    }

    /**
     * builds a random game board
     */
    private void buildBoard(int lines, int cols, int nValues) {
        int nCards = lines*cols;
        // array auxiliar para obter valores aleatórios
        int[] values = new int[nCards];
        int index = 0;
        for(int i = 0; i < nCards/2; ++i) {
            int val = rand.nextInt(nValues);
            values[index++] = val;
            values[index++] = val;
        }

        // create the board
        cards = new Card[lines][cols];

        // randomly populated the board
        for (int l=0; l < lines; ++l)  {
            for (int c=0; c < cols; ++c) {
                // para cada nova carta obter o seu valor aleatoriamente
                int idx = rand.nextInt(nCards);
                cards[l][c] = buildCard(values[idx], l, c);
                values[idx] = values[--nCards];
            }
        }
    }


    /**
     * auxiliary method to remove a card and signal listener
     * @param c
     */
    private void removeCard(Card c) {
        c.setState(Card.State.REMOVED);
        if (listener != null) listener.removed(c);
        removedCards++;
    }

    /**
     * auxiliary method to show a card and signal listener
     * @param c
     */
    private void showCard(Card c) {
        c.setState(Card.State.TURNED_UP);
        if (listener != null) listener.showed(c);
    }

    /**
     * auxiliary method to turn down  a card and signal listener
     * @param c
     */
    private void hideCard(Card c) {
        c.setState(Card.State.TURNED_DOWN);
        if (listener != null) listener.hidden(c);
    }


    /**
     * Execução da jogada
     * @param card
     * @return
     */
    public boolean play(Card card) {
        if (card.getState() == Card.State.REMOVED)
            // the card has already been removed
            return false;


        moves++;

        if (first == null)  {
            first = card;
            showCard(card);
        }
        else {
            if (card != first) {
                showCard(card);
                if (card.getValue() == first.getValue()) {
                    // a pair was found
                    removeCard(first);
                    removeCard(card);
                    first = null;
                }
                else {
                    second = card;
                    return true;
                }
            }

        }
        return false;
    }

    /**
     * turned down visible cards
     */
    public void hidePair() {
        if (first != null) {
            hideCard(first);
            hideCard(second);
            first = second = null;
        }
    }


    // setters/getters (acessores)

    public int getLines() { return lines; }
    public int getCols() { return cols; }

    public int getMoves() {
        return moves;
    }

    public void setCardListener(CardChangedListener cardListener) {
        this.listener = cardListener;
    }

    public Card getCardAt(int line, int col) {
        return cards[line][col];
    }

    public boolean isEmpty() {
        return removedCards == lines*cols;
    }
}
