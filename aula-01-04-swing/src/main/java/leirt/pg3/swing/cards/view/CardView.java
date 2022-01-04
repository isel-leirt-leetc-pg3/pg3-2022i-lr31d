package leirt.pg3.swing.cards.view;

import leirt.pg3.swing.cards.model.Card;

import javax.swing.*;

public class CardView extends JButton {


    public static final int CARD_WIDTH = 80;
    public static final int CARD_HEIGHT = 100;

    private static String[] cards = {
        "da", "dq", "dj", "dk",
        "ca", "cq", "cj", "ck",
        "ha", "hq", "hj", "hk",
        "sa", "sq", "sj", "sk"

    };

    public static final int NVALUES = cards.length;

    private static final String BACKGROUND_FACE = "b";
    private static final Icon back;

    static {
        back = Utils.getIconFromResource("cards/" + BACKGROUND_FACE + ".gif",
                                         CARD_WIDTH, CARD_HEIGHT);
    }

    private Card card;
    private boolean turnedUp;
    private Icon face;

    public CardView(Card card) {
        this.card = card;
        String cardName = cards[card.getValue()];
        this.face = Utils.getIconFromResource("cards/"+ cardName + ".gif", CARD_WIDTH, CARD_HEIGHT);
    }

    public CardView(Icon face) {
        this.face = face;
        setVisible(true);
        validate();
    }


    public void turnUp() {
        turnedUp = true;
        setIcon(face);
        validate();
    }


    public void turnDown() {
        turnedUp = false;
        setIcon(back);
        validate();

    }


    public boolean isShowed() {
        return turnedUp;
    }

    public Card getCard() {
        return card;
    }
}
