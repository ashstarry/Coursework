package part1;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
 
public class MyNumberTest {
   private MyNumber number1, number2; // Test fixtures
 
   @Before
   public void setUp() throws Exception {
      System.out.println("Run @Before"); // for illustration
      number1 = new MyNumber(11);
      number2 = new MyNumber(22);
   }
 
   @After
   public void tearDown() throws Exception {
      System.out.println("Run @After"); // for illustration
   }
 
   @Test
   public void testGetterSetter() {
      System.out.println("Run @Test testGetterSetter"); // for illustration
      int value = 33;
      number1.setNumber(value);
      assertEquals("error in getter/setter", value, number1.getNumber());
   }
 
   @Test
   public void testAdd() {
      System.out.println("Run @Test testAdd"); // for illustration
      assertEquals("error in add()", 33, number1.add(number2).getNumber());
      assertEquals("error in add()", 55, number1.add(number2).getNumber());
   }
 
   @Test
   public void testDiv() {
      System.out.println("Run @Test testDiv"); // for illustration
      assertEquals("error in div()", 2, number2.div(number1).getNumber());
      assertEquals("error in div()", 0, number2.div(number1).getNumber());
   }
 
   @Test(expected = IllegalArgumentException.class)
   public void testDivByZero() {
      System.out.println("Run @Test testDivByZero"); // for illustration
      number2.setNumber(0);
      number1.div(number2);
   }
}
