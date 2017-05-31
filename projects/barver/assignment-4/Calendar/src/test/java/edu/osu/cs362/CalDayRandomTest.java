package edu.osu.cs362;


import org.junit.Test;


import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.Random;

import static org.junit.Assert.*;



/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {

    private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
    private static final int NUM_TESTS=100;

    /**
     * Generate Random Tests that tests Appt Class.
     */
    @Test
    public void radnomtest()  throws Throwable  {

        long startTime = Calendar.getInstance().getTimeInMillis();
        long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;


        System.out.println("Start testing...");


        for (int iteration = 0; elapsed < TestTimeout; iteration++) {
            long randomseed =iteration;//System.currentTimeMillis();
            //			System.out.println(" Seed:"+randomseed );
            Random random = new Random(randomseed);

            int startHour= ValuesGenerator.RandInt(random);
            int startMinute= 10;
            int startDay= 2;
            int startMonth= 1;
            int startYear= 2016;
            String title="Birthday Party";
            String description="This is my birthday party.";
            //Construct a new Appointment object with the initial data
            Appt appt = new Appt(startHour,
                    startMinute ,
                    startDay ,
                    startMonth ,
                    startYear ,
                    title,
                    description);


            startHour = ValuesGenerator.RandInt(random);

            Appt appt2 = new Appt(startHour,startMinute,startDay,startMonth,startYear,title,description);
            CalDay calDay = new CalDay(new GregorianCalendar(2016,5,20));

            calDay.addAppt(appt);
            calDay.addAppt(appt2);

            /*for (int i = 0; i < NUM_TESTS; i++) {


            }*/

            elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
            if((iteration%10000)==0 && iteration!=0 )
                System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);

        }


        System.out.println("Done testing...");
    }


}






