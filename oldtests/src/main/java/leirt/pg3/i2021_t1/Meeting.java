package leirt.pg3.i2021_t1;

import leirt.pg3.i1920_t2.Date;

public abstract class Meeting {
    private final String description;
    protected Meeting(String description) { this.description = description; }
    public abstract Date getDate();
    public abstract String getAgenda();
    public String toString() {
        return  description + " (" + getDate() + ')';
    }
}
