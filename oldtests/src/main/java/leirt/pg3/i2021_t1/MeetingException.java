package leirt.pg3.i2021_t1;

public class MeetingException extends Exception{
    public MeetingException() {
        super("Invalid Meeting");
    }

    public MeetingException(String message) {
        super("Error: " + message);
    }
}
