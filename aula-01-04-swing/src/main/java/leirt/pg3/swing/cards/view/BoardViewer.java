package leirt.pg3.swing.cards.view;

import leirt.pg3.swing.cards.model.Board;
import leirt.pg3.swing.cards.model.Card;
import leirt.pg3.swing.cards.model.CardChangedListener;

import javax.swing.*;
import javax.swing.tree.ExpandVetoException;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * The board viewer
 */
public class BoardViewer extends JPanel implements CardChangedListener {

    // the model associated to this viewer
    private Board model;

    private GridLayout layout;

    private CardView[][] board;
    private CardSelectedListener listener;

    public void setCardSelectedListener(CardSelectedListener listener) {
        this.listener = listener;
    }

    private void fireCardSelected(CardView cv) {
        if (listener != null) listener.onSelected(cv);
    }

    public BoardViewer(Board model) {
        this.model = model;
        layout = new GridLayout();
        setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        setLayout(layout);

        model.setCardListener(this);
        build(model.getLines(), model.getCols());
    }

    private void cardSelected(ActionEvent evt) {
        fireCardSelected((CardView) evt.getSource());
    }

    private void build(int lines, int cols) {
        removeAll();
        layout.setRows(lines);
        layout.setHgap(50);
        layout.setVgap(10);

        layout.setColumns(cols);

        board = new CardView[lines][cols];
        for (int i=0; i < lines; ++i) {
            for (int j=0; j < cols; ++j) {
                CardView card = new CardView(model.getCardAt(i, j));
                board[i][j] = card;
                card.turnDown();
                card.addActionListener(this::cardSelected);
                add(card);

            }
        }

    }

    @Override
    public void hidden(Card c) {
        CardView cv = board[c.getLine()][c.getCol()];
        cv.turnDown();
    }

    @Override
    public void showed(Card c) {
        CardView cv = board[c.getLine()][c.getCol()];
        cv.turnUp();
    }

    @Override
    public void removed(Card c) {
        CardView cv = board[c.getLine()][c.getCol()];
        cv.setVisible(false);
    }
}
