
/**
* class RationalTest to test the class Rational
* <p>
* @author Breeland Abrams	
* @version 1.0
* @Fall 2017
*/
public class rationalTest {

/**
* main method used to test all the methods of class Rational 
* @param args - unused
*/
public static void main(String[] args) {
Rational R1 = new Rational();
Rational R2 = new Rational();
System.out.println("Input values for R1");
R1.inputRational();
System.out.println("Input values for R2");
R2.inputRational();

Rational R3 = new Rational();
R3.add(R1, R2);
System.out.println(R1 + " + " + R2 + " = " + R3);

R3 = R1.sub(R2);
System.out.println(R1 + " - " + R2 + " = " + R3);

R3.mul(R1, R2);
System.out.println(R1 + " * " + R2 + " = " + R3);

R3 = R1.div(R2);
System.out.println(R1 + " / " + R2 + " = " + R3);

System.out.println(Rational.divToDouble(R1, R2));

R1.setNumerator(2);
R2.setDenominator(5);
System.out.println("R1 Numerator: " + R1.getNumerator());
System.out.println("R2 Denominator: " + R2.getDenominator());
}
}
