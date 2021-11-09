package leirt.pg3.shapes;

public class BadShape extends Exception {
    public BadShape() {

    }

    public BadShape(String msg) {
        super(msg);
    }
}
