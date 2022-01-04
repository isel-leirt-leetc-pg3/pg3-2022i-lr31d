package leirt.pg3.swing.cards.model;

public class Card {


    public enum State {
        TURNED_UP, TURNED_DOWN, REMOVED;
    }


    private  int value;
    private  int line, col;
    private State state;

    public Card(int val, int line, int col ) {
        this.value=val;
        this.line = line;
        this.col = col;
        state = State.TURNED_DOWN;
    }

    private Card(int val, int line, int col, State state) {
        this(val,line,col);
        this.state = state;
    }

    public int getLine() { return line; }
    public int getCol() { return col; }
    public int getValue() { return value; }

    public State getState() { return state; }
    void setState(State state) { this.state = state; }


}
