package edu.osu.cs362;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;


import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {

	 @Test
	  public void test01()  throws Throwable  {


		 CalDay calDay = new CalDay();
		 assertFalse(calDay.isValid());

		 GregorianCalendar gregorianOne = new GregorianCalendar();
		 CalDay calDay1 = new CalDay(gregorianOne);

		 assertEquals(calDay1.getDay(),gregorianOne.get(gregorianOne.DAY_OF_MONTH));
		 assertEquals(calDay1.getMonth(),gregorianOne.get(gregorianOne.MONTH));
		 assertEquals(calDay1.getYear(),gregorianOne.get(gregorianOne.YEAR));

	 }

	 @Test
	   public void test02() throws Throwable{
	 	Appt appt = new Appt(10,12,22,03,2017,
		"merry","Need to merry");

		 GregorianCalendar gregorianOne = new GregorianCalendar();
		 CalDay calDay1 = new CalDay(gregorianOne);
		 calDay1.addAppt(appt);
		 calDay1.iterator();

	 }


    @Test
    public void test09() throws Throwable{
        GregorianCalendar gregorianOne = new GregorianCalendar();
        CalDay calDay1 = new CalDay(gregorianOne);
        Appt appt1 = new Appt(12,12,22,03,2017,
                "merry","Need to merry");
        Appt appt2 = new Appt(11,12,22,03,2017,
                "merry","Need to merry");

        calDay1.addAppt(appt2);
        calDay1.addAppt(appt1);
        assertEquals(11,calDay1.getAppts().getFirst().getStartHour());

    }


    @Test
    public void test10() throws Throwable{
        GregorianCalendar gregorianOne = new GregorianCalendar();
        CalDay calDay1 = new CalDay(gregorianOne);
        Appt appt1 = new Appt(12,12,22,03,2017,
                "merry","Need to merry");
        Appt appt2 = new Appt(12,12,24,04,2017,
                "buru","Need to merry");

        calDay1.addAppt(appt1);
        calDay1.addAppt(appt2);
        assertEquals(03,calDay1.getAppts().get(0).getStartMonth());


    }

	@Test
	public void test03() throws Throwable{
		GregorianCalendar gregorianOne = new GregorianCalendar();
		CalDay calDay1 = new CalDay(gregorianOne);
		Appt appt1 = new Appt(12,12,22,03,2017,
				"merry","Need to merry");
		Appt appt2 = new Appt(10,12,22,03,2017,
				"merry","Need to merry");

		calDay1.addAppt(appt1);
		calDay1.addAppt(appt2);
        assertEquals(2,calDay1.getSizeAppts());


	}

	@Test
	public void test04() throws Throwable{
		CalDay calDay = new CalDay();
		calDay.iterator();


	}

	@Test
	public void test05() throws Throwable{
		GregorianCalendar gregorianOne = new GregorianCalendar();
		CalDay calDay1 = new CalDay(gregorianOne);
		Appt appt = new Appt(-1,12,22,03,2017,
				"merry","Need to merry");

		assertEquals(false,appt.getValid());

		calDay1.addAppt(appt);


	}

	@Test
	public void test06() throws Throwable{
		GregorianCalendar gregorianOne = new GregorianCalendar();
		CalDay calDay1 = new CalDay(gregorianOne);
		Appt appt1 = new Appt(10,12,22,03,2017,
				"merry","Need to merry");
		Appt appt2 = new Appt(12,12,22,03,2017,
				"merry","Need to merry");

		calDay1.addAppt(appt1);
		calDay1.addAppt(appt2);
		calDay1.iterator();
		calDay1.toString();
		//assertEquals(" ",calDay1.toString());


	}

	@Test
	public void test07() throws Throwable{
		CalDay calDay = new CalDay();
		assertNotNull(calDay.toString());

	}

    @Test
    public void test11() throws Throwable{
        Appt appt = new Appt(10,12,22,03,2017,
                "merry","Need to merry");

        GregorianCalendar gregorianOne = new GregorianCalendar();
        CalDay calDay1 = new CalDay(gregorianOne);
        calDay1.addAppt(appt);
        assertNotNull(calDay1.iterator());

    }





}
