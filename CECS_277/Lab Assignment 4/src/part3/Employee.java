package part3;

import java.util.Calendar;
import java.io.*;
/**
 * 
 * @author Breeland Abrams
 *Abstract Employee Class implementing EmployeeInfo, Comparable, and Cloneable interfaces
 */
public abstract class Employee implements EmployeeInfo, Comparable<Employee>, Cloneable
{
	private String lastName;
	private String firstName;
	private String ID_Number;
	private String sex;
	private Calendar birthDate;
	
	/**
	 * Default Employee Constructor
	 */
	public Employee()
	{
		lastName = "";
		firstName = "";
		ID_Number = "";
		sex = "";
		birthDate = Calendar.getInstance();
	}
	
	/**
	 * @param ln
	 * @param fn
	 * @param id
	 * @param s
	 * @param month
	 * @param date
	 * @param year
	 * Overloaded Employee Constructor
	 */
	public Employee(String ln, String fn, String id, String s, int month, int date, int year)
	{
		lastName = ln;
		firstName = fn;
		ID_Number = id;
		sex = s;
		birthDate = Calendar.getInstance();
		birthDate.set(year, month, date);
	}
	/**
	 * @param name
	 * Method for setting Employee last name
	 */
	public void setLastName(String name)
	{
		lastName = name;
	}
	/**
	 * @return
	 * Method for Returning Employee last name
	 */
	public String getLastName()
	{
		return lastName;
	}
	/**
	 * @param name
	 * Method for setting Employee first name
	 */
	public void setFirstName(String name)
	{
		firstName = name;
	}
	/**
	 * @return
	 * Method for Returning Employee first name
	 */
	public String getFirstName()
	{
		return firstName;
	}
	/**
	 * 
	 * @param number
	 * Method for setting Employee ID number
	 */
	public void setID_Number(String number)
	{
		ID_Number = number;
	}
	/**
	 * 
	 * @return
	 * Method for returning Employee ID number
	 */
	public String getID_Number()
	{
		return ID_Number;
	}
	/**
	 * 
	 * @param s
	 * Method for setting sex of Employee
	 */
	public void setSex(String s)
	{
		sex = s;
	}
	/**
	 * 
	 * @return
	 * Method for returning sex of Employee
	 */
	public String getSex()
	{
		return sex;
	}
	/**
	 * 
	 * @param month
	 * @param date
	 * @param year
	 * Methods for setting the Date of Birth of an Employee
	 */
	public void setBirthDate(int month, int date, int year)
	{
		birthDate.set(Calendar.MONTH, month);
		birthDate.set(Calendar.DATE, date);
		birthDate.set(Calendar.YEAR, year);
	}
	public void setBirthMonth(int month)
	{
		birthDate.set(Calendar.MONTH, month);	
	}
	public void setBirthDay(int day)
	{
		birthDate.set(Calendar.DATE, day);	
	}
	public void setBirthYear(int year)
	{
		birthDate.set(Calendar.YEAR, year);
	}
	/**
	 * 
	 * @return
	 * Method for returning day of the month of an Employee's birth
	 */
	public int getBirthDay()
	{
		return birthDate.get(Calendar.DATE);
	}
	/**
	 * 
	 * @return
	 * Method for returning an Employee's birth month
	 */
	public int getBirthMonth()
	{
		return birthDate.get(Calendar.MONTH);
	}
	/**
	 * 
	 * @return
	 * Method for returning an Employee's birth year
	 */
	public int getBirthYear()
	{
		return birthDate.get(Calendar.YEAR);
	}
	
	/**
	 * 
	 * @return
	 * Abstract method to return Employee salaries
	 */
	public abstract double monthlyEarning();
	/**
	 * Abstract method for inputting employee info
	 * @throws IOException 
	 */
	public abstract void inputEmployeeInfo(String directory) throws IOException;
	
	/**
	 * Comparator method
	 */
	public int compareTo(Employee c)
	{
		int a = Integer.parseInt(ID_Number);
		int b = Integer.parseInt(c.ID_Number);
		if(a > b)
		{
			return 1;
		}
		if(a < b)
		{
			return -1;
		}
		return 0;
	}
	
	public Object clone() throws CloneNotSupportedException
	{
		return super.clone();
	}
}
