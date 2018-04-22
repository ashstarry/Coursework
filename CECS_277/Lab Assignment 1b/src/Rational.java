/**
  *Class for a rational object 
  *<p>
  * @author Breeland Abrams
  * @version 1.0
  * @Fall 2017
  */
import java.util.Scanner;
public class Rational {
	
	private int numerator;
	private int denominator;
	
	/**
	 * Default constructor for rational object
	 */
	public Rational()
	{
		numerator = 0;
		denominator = 0;
	}
	
	/**
	 * Method to return the numerator of a rational
	 * @return
	 */
	public int getNumerator()
	{
		return numerator;
	}
	/**
	 * Method to return the denominator of a rational
	 * @return
	 */
	public int getDenominator()
	{
		return denominator;
	}
	/**
	 * Method to set the value of a rational's numerator
	 * @return
	 */
	public void setNumerator(int value)
	{
		numerator = value;
	}
	/**
	 * Method to set the value of a rational's denominator
	 * @return
	 */
	public void setDenominator(int value)
	{
		denominator = value;
	}
	/**
	 * Method to input the numerator and denominator for a rational object
	 */
	public void inputRational()
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter the Numerator");
		setNumerator(input.nextInt());
		
		System.out.println("Enter the Denominator");
		setDenominator(input.nextInt());
		
	}
	/**
	 * Method to convert the object's data members to a string output
	 */
	public String toString()
	{
		return numerator + "/" + denominator;
	}
	/**
	 * Method for calculating the greatest common divisor of two rational objects
	 * @param m
	 * @param n
	 * @return
	 */
	private int gcd(int m, int n)
	{
		int r;
		while(n != 0)
		{
			r = m % n;
			m = n;
			n = r;
		}
		return m;
	}
	/**
	 * Method for adding two rational objects
	 * @param r1
	 * @param r2
	 */
	public void add(Rational r1, Rational r2)
	{
		int newNumerator = (r1.getNumerator()*r2.getDenominator()) + (r2.getNumerator()*r1.getDenominator());
		int newDenominator = r1.getDenominator()*r2.getDenominator();
		numerator = newNumerator/gcd(newNumerator, newDenominator);
		denominator = newDenominator/gcd(newNumerator, newDenominator);
		
	}
	/**
	 * Method for subtracting two rational objects
	 * @param R
	 * @return
	 */
	public Rational sub(Rational R)
	{
		
		int tempNumerator = (numerator*R.getDenominator()) - (R.getNumerator()*denominator);
		int tempDenominator = denominator*R.getDenominator();
		int newNumerator = tempNumerator/gcd(tempNumerator, tempDenominator);
		int newDenominator = tempDenominator/gcd(tempNumerator, tempDenominator);
		
		Rational r3 = new Rational();
		r3.setNumerator(newNumerator);
		r3.setDenominator(newDenominator);
		
		return r3;
		
	}
	/**
	 * Method for multiplying two rational objects
	 * @param r1
	 * @param r2
	 */
	public void mul(Rational r1, Rational r2)
	{
		int newNumerator = r1.getNumerator() * r2.getNumerator();
		int newDenominator = r1.getDenominator() * r2.getDenominator();
		numerator = newNumerator/gcd(newNumerator, newDenominator);
		denominator = newDenominator/gcd(newNumerator, newDenominator);
		
	}
	/**
	 * Method for dividing two rational objects
	 * @param R
	 * @return
	 */
	public Rational div(Rational R)
	{
		int tempNumerator = numerator * R.getDenominator();
		int tempDenominator = denominator * R.getNumerator();
		int newNumerator = tempNumerator/gcd(tempNumerator, tempDenominator);
		int newDenominator = tempDenominator/gcd(tempNumerator, tempDenominator);
		
		Rational r3 = new Rational();
		r3.setNumerator(newNumerator);
		r3.setDenominator(newDenominator);
		
		return r3;
	}
	/**
	 * Method for converting the quotient of two rational objects to a double value
	 * @param r1
	 * @param r2
	 * @return
	 */
	public static double divToDouble(Rational r1, Rational r2)
	{
		Rational r3 = new Rational();
		r3 = r1.div(r2);
		double numerator = r3.getNumerator();
		double denominator = r3.getDenominator();
		return numerator / denominator;
	}

}
