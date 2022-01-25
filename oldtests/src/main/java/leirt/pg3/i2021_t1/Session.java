package leirt.pg3.i2021_t1;

import leirt.pg3.i1920_t2.Date;

public abstract class Session extends Meeting{
    private final String agenda;
    private final Date date;

    public Session( String name, Date d, String agd ) {
        super("Session \"" + name +'"');
        agenda = agd;
        date = d;
    }

    public String getAgenda()   { return '(' + agenda + ')'; }
    public final Date getDate() { return date;               }
    public String toString()    { return  "[" + getType() + "] " + super.toString(); }

    protected abstract char getType();
}
