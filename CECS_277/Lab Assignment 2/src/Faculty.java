import java.lang.Cloneable;
/**
 * 
 * @author Breeland Abrams
 * Faculty class extending from Employee class and implementing EmployeeInfo interface
 */
public class Faculty extends Employee implements EmployeeInfo, Cloneable
{
	private Education edu;
	/**
	 * Enumeration for Faculty Ranks
	 */
	public enum levels
	{
		AS, AO, FU
	}
	private levels rank;
	/**
	 * Default Faculty Constructor
	 */
	public Faculty()
	{
		super();
		rank = null;
	}
	/**
	 * 
	 * @param ln
	 * @param fn
	 * @param id
	 * @param sex
	 * @param month
	 * @param date
	 * @param year
	 * @param d
	 * @param m
	 * @param re
	 * @param ra
	 * Overloaded Faculty Constructor
	 */
	public Faculty(String ln, String fn, String id, String sex, int month, int date, int year, String d, String m, int re, levels ra)
	{
		super(ln, fn, id, sex, month, date, year);
		edu = new Education(d, m, re);
		rank = ra;
	}
	/**
	 * 
	 * @param level
	 * Method for settign faculty rank
	 */
	public void setLevel(levels level)
	{
		rank = level;
	}
	/**
	 * 
	 * @return
	 * Method for returning faculty rank
	 */
	public levels getLevel()
	{
		return rank;
	}
	/**
	 * Method for returning monthly earning for Faculty based on rank
	 */
	public double monthlyEarning()
	{
		switch(rank)
		{
		case AS:
			return FACULTY_MONTHLY_SALARY;
		case AO:
			return FACULTY_MONTHLY_SALARY * 1.5;	
		case FU:
			return FACULTY_MONTHLY_SALARY * 2.0;
		default:
			return 0;
		}
	}
	/**
	 * String representation of Faculty object
	 */
	public String toString()
	{
		
		return super.toString() +  "\nMonthly Salary: $ " + monthlyEarning();
	}

	private void setEducation(Education obj)
	{
		obj.setDegree(edu.getDegree());
		obj.setMajor(edu.getMajor());
		obj.setResearches(edu.getResearches());
	}
	/**
	 * Clone method
	 */
	public Object Clone() throws CloneNotSupportedException
	{
		
		return super.clone();
		
	}
	
}
