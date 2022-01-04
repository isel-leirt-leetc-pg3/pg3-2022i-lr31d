package leirt.pg3.swing.cards.model;

public interface CardChangedListener {
    /**
     * Indica a carta que passou a estar escondidda
     * @param c Carta escondida
     */
    void hidden(Card c);

    /**
     * Indica a carta que passou a estar visível
     * @param c Carta que passou a estar visível
     */
    void showed(Card  c);

    /**
     * Indica a carta que foi removida do tabuleiro de jogo
     * @param c A carta removida
     */
    void removed(Card  c);
}
