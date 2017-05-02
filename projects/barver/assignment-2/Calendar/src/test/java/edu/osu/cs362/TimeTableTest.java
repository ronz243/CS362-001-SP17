package edu.osu.cs362;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {

	 @Test
	  public void test01()  throws Throwable  {
	 	TimeTable timeTable1 = new TimeTable();
		 
	 }
	 @Test
    public void test02(){
         TimeTable timeTable1 = new TimeTable();
         LinkedList<Appt>appts = new LinkedList<Appt>();
         Appt appt1 = new Appt(10,12,22,03,2017,
                 "bob","Need to code");
         Appt appt2 = new Appt(12,12,22,03,2017,
                 "Mary","Need to do hw");
         Appt appt3 = new Appt(12,12,22,03,2017,
                 "Robo","Need to go home");
         appts.add(appt1);
         appts.add(appt2);
         appts.add(appt3);
         timeTable1.deleteAppt(appts,appt3);


     }


    @Test
    public void test03(){
        TimeTable timeTable1 = new TimeTable();
        LinkedList<Appt>appts = new LinkedList<Appt>();
        Appt appt = null;
        appts.add(appt);
        timeTable1.deleteAppt(appts,appt);

    }

    @Test
    public void test04(){
        TimeTable timeTable1 = new TimeTable();
        LinkedList<Appt>appts = new LinkedList<Appt>();
        Appt appt = new Appt(20,10,3,4,2016,"bobo","need to go");
        timeTable1.deleteAppt(appts,appt);

    }

    @Test
    public void test05(){
        TimeTable timeTable1 = new TimeTable();
        LinkedList<Appt>appts = null;
        Appt appt = new Appt(20,10,3,4,2016,"bobo","need to go");
        timeTable1.deleteAppt(appts,appt);

    }

    @Test
    public void test06(){
        TimeTable timeTable1 = new TimeTable();
        LinkedList<Appt>appts = new LinkedList<Appt>();
        Appt appt = new Appt(-1,10,3,4,2016,"bobo","need to go");
        timeTable1.deleteAppt(appts,appt);

    }

    @Test
    public void test07(){
        TimeTable timeTable1 = new TimeTable();
        LinkedList<Appt> appts = new LinkedList<Appt>();
        Appt appt1 = new Appt(10,10,3,4,2016,"bobo","need to go");
        Appt appt2 = new Appt(5,10,3,4,2016,"boeing","need to build");
        appts.add(appt1);
        appts.add(appt2);
        GregorianCalendar gregOne = new GregorianCalendar(2016,4,3);
        GregorianCalendar gregTwo = new GregorianCalendar(2016,5,4);
        timeTable1.getApptRange(appts,gregOne,gregTwo);
    }

    @Test
    public void test08(){
        TimeTable timeTable1 = new TimeTable();
        LinkedList<Appt> appts = new LinkedList<Appt>();
        Appt appt1 = new Appt(10,10,3,4,2016,"bobo","need to go");
        Appt appt2 = new Appt(-1,10,3,4,2016,"boeing","need to build");
        appts.add(appt1);
        appts.add(appt2);
        GregorianCalendar gregOne = new GregorianCalendar(2016,4,3);
        GregorianCalendar gregTwo = new GregorianCalendar(2016,5,4);
        timeTable1.getApptRange(appts,gregOne,gregTwo);
    }

    @Test
    public void test09() {
        TimeTable timeTable1 = new TimeTable();
        LinkedList<Appt> appts = new LinkedList<Appt>();
        Appt appt1 = new Appt(10, 10, 3, 4, 2016, "bobo", "need to go");
        Appt appt2 = new Appt(5, 10, 3, 4, 2016, "boeing", "need to build");
        appts.add(appt1);
        appts.add(appt2);
        GregorianCalendar gregOne = new GregorianCalendar(2016, 4, 3);
        GregorianCalendar gregTwo = new GregorianCalendar(2015, 5, 4);
        try {
            timeTable1.getApptRange(appts, gregOne, gregTwo);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }


}
