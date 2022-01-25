package leirt.pg3.i2021_t1;

import leirt.pg3.i1920_t2.Date;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ComposeMeeting extends Meeting implements Composite {
    private final List<Meeting> list= new ArrayList<>();
    protected ComposeMeeting()         { super("Conference");  }
    public ComposeMeeting(String name) { super(name);                }
    public Date getDate() {
        if ( list.isEmpty() ) return null;
        return list.get( 0 ).getDate();
    }
    public String getAgenda() {
        StringBuilder sb = new StringBuilder("{");
        for (Meeting m: list )
            sb.append( m.getAgenda() ).append(", ");
        if ( !list.isEmpty() ) sb.setLength( sb.length() -2 );
        return sb.append('}').toString();
    }

    public Meeting getMeeting(Predicate<Meeting> filter) {
        Meeting r= null;
        for (Meeting m: list )
            if ( filter.test( m ) ) r = m;
        return r;
    }

    public List<Meeting> getMeetings() {
        List<Meeting> r = new ArrayList<>( list );
        r.sort( (m1, m2) -> m1.getDate().compareTo( m2.getDate()));
        return r;
    }

    @Override
    public Composite append(Meeting m) throws MeetingException {
        if ( m instanceof OrdinarySession )
            throw new MeetingException();
        list.add( m );
        return this;
    }

    public static void main(String[] args) {
        try{
            ExtraordinarySession d1 =
                    new ExtraordinarySession("1º day", new Date(2021,6,10), "topic1", "topic2");
            ComposeMeeting d2 = new ComposeMeeting ("2º day");
            d2.append(new ExtraordinarySession("First",new Date(2021,6,11), "topic3"))
              .append(new ExtraordinarySession("Last",new Date(2021,6,11), "topic4"));
            ComposeMeeting c = new ComposeMeeting (); c.append(d1).append(d2);
            System.out.println( c+ " -> agenda: " + c.getAgenda() );

            System.out.println(d2.getMeeting( m -> m.getDate().equals(new Date(2021,6,11))));
            System.out.println(c.getMeeting( m -> m.toString().contains("day")));

       } catch( Exception ex ) { System.out.println( ex.getMessage()); }
    }

}
