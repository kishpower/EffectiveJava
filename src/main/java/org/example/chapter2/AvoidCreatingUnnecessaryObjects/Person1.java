package org.example.chapter2.AvoidCreatingUnnecessaryObjects;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Person1 {
    private final Date birthDate;
    private final static Date BOOM_START;
    private final static Date BOOM_END;


    public Person1(Date birthDate) {
        this.birthDate = birthDate;
    }

   static {
       Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
       gmtCal.set(1946, Calendar.JANUARY , 0 ,0, 0,0);
       BOOM_START = gmtCal.getTime();
       gmtCal.set(1965, Calendar.JANUARY , 0,0,0,0);
       BOOM_END = gmtCal.getTime();
   }
    public boolean isBabyBoomer(){
        return birthDate.compareTo(BOOM_START) >= 0 && birthDate.compareTo(BOOM_END) < 0 ;
    }
}
