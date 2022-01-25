package leirt.pg3.i2021_t1;

import leirt.pg3.i1920_t2.Date;

public class ExtraordinarySession extends Session{
    public ExtraordinarySession(String name, Date d, String ... topics) {
        super(  name, d, String.join("; ", topics));
    }

    protected char getType() {
        return 'E';
    }

    public static void main(String[] args) {
        ExtraordinarySession es =
                new ExtraordinarySession("C", new Date(2021, 5, 10), "topic 1", "topic 2");
        System.out.println( es + " -> agenda: " + es.getAgenda());

    }
}
