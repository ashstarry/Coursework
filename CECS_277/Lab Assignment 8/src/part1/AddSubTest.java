package part1;
import static org.junit.Assert.*;
import org.junit.Test;
 
public class AddSubTest {
   @Test
   public void testAddPass() {
      // assertEquals(String message, long expected, long actual)
      assertEquals("error in add()",  3, Calculator.add(1, 2));
      assertEquals("error in add()", -3, Calculator.add(-1, -2));
      assertEquals("error in add()",  9, Calculator.add(9, 0));
   }
 
   @Test
   public void testAddFail() {
      // assertNotEquals(String message, long expected, long actual)
      assertNotEquals("error in add()", 0, Calculator.add(1, 2));
   }
 
   @Test
   public void testSubPass() {
      assertEquals("error in sub()",  1, Calculator.sub(2, 1));
      assertEquals("error in sub()", -1, Calculator.sub(-2, -1));
      assertEquals("error in sub()",  0, Calculator.sub(2, 2));
   }
 
   @Test
   public void testSubFail() {
      assertNotEquals("error in sub()", 0, Calculator.sub(2, 1));
   }
}