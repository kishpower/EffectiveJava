package org.example.chapter2.AvoidCreatingUnnecessaryObjects;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Person {
    private final Date birthDate;

    public Person(Date birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isBabyBoomer(){
        Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        gmtCal.set(1946, Calendar.JANUARY , 0 ,0, 0,0);
        Date BOOM_START = gmtCal.getTime();
        gmtCal.set(1965, Calendar.JANUARY , 0,0,0,0);
        Date BOOM_END= gmtCal.getTime();
        return birthDate.compareTo(BOOM_START) >= 0 && birthDate.compareTo(BOOM_END) < 0 ;
    }
}
