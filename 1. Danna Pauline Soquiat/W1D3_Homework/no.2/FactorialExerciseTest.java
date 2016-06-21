package com.mnl.app2.w1d3_1;

import junit.framework.TestCase;


public class FactorialExerciseTest extends TestCase {

   protected void setUp() throws Exception {
      super.setUp();
   }

   protected void tearDown() throws Exception {
      super.tearDown();
   }

   public void testFactorial() {
      FactorialExercise fact = new FactorialExercise();
      assertEquals(120, FactorialExercise.Factorial(5));
   }

}
