package part3;
import java.lang.Cloneable;
import java.io.*;
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
		edu = new Education();
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
	 * Method for setting faculty rank
	 */
	public void setStringLevel(String l)
	{
		switch(l)
		{
		case "AS":
			setLevel(levels.AS);
			break;
		case "AO":
			setLevel(levels.AO);
			break;
		case "FU":
			setLevel(levels.FU);
			break;
		default:
			break;
		}
	}
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
		if(rank == null)
		{
			return 0;
		}
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
	public String getRank()
	{
		
		switch(rank)
		{
		case AS:
			return "Assistant";
		case AO:
			return "Associate";	
		case FU:
			return "Full-Time";
		default:
			return "default";
		}
	}
	public void setDegree(String d)
	{
		edu.setDegree(d);
	}
	public void setMajor(String m)
	{
		edu.setMajor(m);
	}
	public void setResearches(int r)
	{
		edu.setResearches(r);	
	}
	public Education getEducation()
	{
		return edu;
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
	
	public void inputEmployeeInfo(String directory) throws IOException
	{
		
		FileInputStream fs = new FileInputStream(directory);
		BufferedReader br = new BufferedReader(new InputStreamReader(fs));
		//System.out.println("Input Last Name:");
		setLastName(br.readLine());
		//System.out.println("Input First Name:");
		setFirstName(br.readLine());
		//System.out.println("Input ID:");
		setID_Number(br.readLine());
		//System.out.println("Input Sex:");
		setSex(br.readLine());
		//System.out.println("Input Birth Month:");
		setBirthMonth(Integer.parseInt(br.readLine()));
		//System.out.println("Input Birth Day:");
		setBirthDay(Integer.parseInt(br.readLine()));
		//System.out.println("Input Birth Year:");
		setBirthYear(Integer.parseInt(br.readLine()));
		//System.out.println("Input Degree");
		setDegree(br.readLine());
		//System.out.println("Input Major");
		setMajor(br.readLine());
		//System.out.println("Input Number of Researches Conducted");
		setResearches(Integer.parseInt(br.readLine()));
		//System.out.println("Input Position");
		setStringLevel(br.readLine());
		br.close();
		
	}
	
}
