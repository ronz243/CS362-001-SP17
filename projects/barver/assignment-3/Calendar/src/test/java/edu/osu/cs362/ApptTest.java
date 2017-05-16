package edu.osu.cs362;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;

public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */
	 @Test
	  public void test01()  throws Throwable  {
		 int startHour=13;
		 int startMinute=30;
		 int startDay=10;
		 int startMonth=4;
		 int startYear=2017;
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
	// assertions
		 assertTrue(appt.getValid());
		 assertEquals(13, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(10, appt.getStartDay());
		 assertEquals(04, appt.getStartMonth());
		 assertEquals(2017, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription());
		 assertEquals("\t4/10/2017 at 1:30pm ,Birthday Party, This is my birthday party.\n", appt.toString());

	 }

	 @Test
	  public void test02() throws  Throwable{
		 Appt appt = new Appt(23,45,10,8,2016,"bobo","Go home");
		 appt.setStartMonth(2000);
		 assertEquals(false, appt.getValid());
		 appt.setStartMonth(-1);
		 assertEquals(false,appt.getValid());

	 }

    @Test
    public void test10() throws  Throwable{
        Appt appt = new Appt(23,45,10,8,2016,"bobo","Go home");
        appt.setStartMonth(1);
        assertEquals(true, appt.getValid());
        appt.setStartMonth(12);
        assertEquals(true,appt.getValid());

    }

	 @Test
     public void test09() throws  Throwable{
         Appt appt = new Appt(22,45,10,8,2016,"bobo","Go home");
         appt.setStartHour(23);
         assertEquals(true, appt.getValid());
         appt.setStartHour(0);
         assertEquals(true,appt.getValid());

     }

	 @Test
	public void test03() throws Throwable{
		 Appt appt = new Appt(23,45,10,8,2016,"bobo","Go home");
		 appt.setStartHour(-1);
		 assertEquals(false, appt.getValid());
		 appt.setStartHour(24);
		 assertEquals(false,appt.getValid());

	 }

	 @Test
     public void test13() throws Throwable{
         Appt appt = new Appt(27,45,10,8,2016,"bobo","Go home");
         assertEquals(null,appt.toString());
     }

    @Test
    public void test14() throws Throwable{
        Appt appt = new Appt(11,5,10,4,2017,"Birthday Party","This is my birthday party.");
        assertEquals("\t4/10/2017 at 11:5am ,Birthday Party, This is my birthday party.\n",appt.toString());
    }

	@Test
	public void test04() throws Throwable{
		Appt appt = new Appt(23,45,10,8,2016,"bobo","Go home");
		appt.setStartMinute(79);
		assertEquals(false, appt.getValid());
		appt.setStartMinute(-1);
		assertEquals(false,appt.getValid());

	}

    @Test
    public void test11() throws Throwable{
        Appt appt = new Appt(23,45,10,8,2016,"bobo","Go home");
        appt.setStartMinute(0);
        assertEquals(true, appt.getValid());
        appt.setStartMinute(59);
        assertEquals(true,appt.getValid());

    }


	@Test
	public void test05() throws Throwable{
		Appt appt = new Appt(23,45,10,8,2016,"bobo","Go home");
		appt.setStartDay(-1);
		assertEquals(false, appt.getValid());
		appt.setStartDay(32);
		assertEquals(false,appt.getValid());
	}

    @Test
    public void test12() throws Throwable{
        Appt appt = new Appt(23,45,10,8,2016,"bobo","Go home");
        appt.setStartDay(1);
        assertEquals(true, appt.getValid());
        appt.setStartDay(31);
        assertEquals(true,appt.getValid());
    }


	@Test
	public void test06() throws Throwable{
		Appt appt = new Appt(23,45,10,8,2016,"bobo","Go home");
		appt.setTitle(null);
		assertEquals("", appt.getTitle());

	}

	@Test
	public void test07() throws Throwable{
		Appt appt = new Appt(23,45,10,8,2016,"bobo","Go home");
		appt.setDescription(null);
		assertEquals("", appt.getDescription());

	}

	@Test
	public void test08() throws Throwable{
		Appt appt = new Appt(23,45,10,8,2016,"bobo","Go home");
		appt.setStartYear(2017);
		assertEquals(true,appt.getValid());
		appt.setStartYear(0);
		assertEquals(true,appt.getValid());

	}





}
