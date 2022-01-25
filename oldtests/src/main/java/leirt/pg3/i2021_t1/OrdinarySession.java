package leirt.pg3.i2021_t1;

import leirt.pg3.i1920_t2.Date;

public class OrdinarySession extends Session{
    public final int days;
    public OrdinarySession(String name, Date d, int days, String agd) throws MeetingException {
        super( name, d, agd );
        if ( days < 0 ) throw new MeetingException("Days have to be positive");
        this.days = days;
    }
    public OrdinarySession(String name, String agd) {
        super( name, Date.today(), agd);
        days = 1;
    }
    private String getPeriodicity() {
        return (days > 1) ? "every " + days + " days": "daily";
    }
    public String toString() {
       return super.toString() + ' ' + getPeriodicity();
    }
    protected char getType() { return 'O'; }

    public static void main(String[] args) throws MeetingException {
        String agd = "topic 1; topic 2";
        OrdinarySession os = new OrdinarySession("A", new Date(2021,1,1), 30, agd);
        System.out.println( os + " -> agenda: " + os.getAgenda() );

        os=new OrdinarySession("B", agd);
        System.out.println( os + " -> agenda: " + os.getAgenda() );

    }
}
