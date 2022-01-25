package leirt.pg3.i2021_t1;

import java.util.List;
import java.util.function.Predicate;

public interface Composite {
    Meeting getMeeting(Predicate<Meeting> filter);
    List<Meeting> getMeetings();
    Composite append( Meeting m ) throws MeetingException;
}
