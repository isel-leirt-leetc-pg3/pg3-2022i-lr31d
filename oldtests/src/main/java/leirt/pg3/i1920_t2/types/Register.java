package leirt.pg3.i1920_t2.types;


import leirt.pg3.i1920_t2.Date;

public interface Register {
    Date getNextVaccinate();
    boolean isVaccinateInDay();
    int getRegisterNumber();
}
