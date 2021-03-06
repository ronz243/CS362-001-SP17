/*
 * This file was automatically generated by EvoSuite
 * Sun Apr 16 20:52:25 GMT 2017
 */


import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true) 
public class ArrayIntList_ESTest extends ArrayIntList_ESTest_scaffolding {

  @Test
  public void test0()  throws Throwable  {
      ArrayIntList arrayIntList0 = new ArrayIntList(2329);
      // Undeclared exception!
      try { 
        arrayIntList0.remove(100);
        fail("Expecting exception: ArrayIndexOutOfBoundsException");
      
      } catch(ArrayIndexOutOfBoundsException e) {
         //
         // 2328
         //
         assertThrownBy("ArrayIntList", e);
      }
  }

  @Test
  public void test1()  throws Throwable  {
      ArrayIntList arrayIntList0 = new ArrayIntList(499);
      arrayIntList0.remove(0);
      arrayIntList0.add(0);
      assertEquals(100, arrayIntList0.size());
  }

  @Test
  public void test2()  throws Throwable  {
      ArrayIntList arrayIntList0 = new ArrayIntList();
      arrayIntList0.remove(0);
      int int0 = arrayIntList0.size();
      assertEquals(101, int0);
  }

  @Test
  public void test3()  throws Throwable  {
      ArrayIntList arrayIntList0 = new ArrayIntList();
      // Undeclared exception!
      try { 
        arrayIntList0.get(0);
        fail("Expecting exception: ArrayIndexOutOfBoundsException");
      
      } catch(ArrayIndexOutOfBoundsException e) {
         //
         // -1
         //
         assertThrownBy("ArrayIntList", e);
      }
  }

  @Test
  public void test4()  throws Throwable  {
      ArrayIntList arrayIntList0 = null;
      try {
        arrayIntList0 = new ArrayIntList(0);
        fail("Expecting exception: NegativeArraySizeException");
      
      } catch(NegativeArraySizeException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         assertThrownBy("ArrayIntList", e);
      }
  }

  @Test
  public void test5()  throws Throwable  {
      ArrayIntList arrayIntList0 = new ArrayIntList();
      arrayIntList0.remove(22);
      arrayIntList0.remove(100);
      assertEquals(102, arrayIntList0.size());
  }

  @Test
  public void test6()  throws Throwable  {
      ArrayIntList arrayIntList0 = new ArrayIntList();
      arrayIntList0.get(1);
      assertEquals(100, arrayIntList0.size());
  }

  @Test
  public void test7()  throws Throwable  {
      ArrayIntList arrayIntList0 = new ArrayIntList();
      // Undeclared exception!
      try { 
        arrayIntList0.add(1);
        fail("Expecting exception: ArrayIndexOutOfBoundsException");
      
      } catch(ArrayIndexOutOfBoundsException e) {
         //
         // 100
         //
         assertThrownBy("ArrayIntList", e);
      }
  }
}
