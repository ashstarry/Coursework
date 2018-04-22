package part3;
import java.io.*;

/**
 * 
 * @author Breeland Abrams
 * Partime Class extending Staff class
 */
public class Partime extends Staff 
{
	private int weeklyHoursWorked;
	/**
	 * Default Partime Constuctor
	 */
	public Partime()
	{
		super();
		weeklyHoursWorked = 0;
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
	 * @param rate
	 * @param hWorked
	 * Overloaded Partime Constructor
	 */
	public Partime(String ln, String fn, String id, String sex, int month, int date, int year, int rate, int hWorked)
	{
		super(ln, fn, id, sex, month, date, year, rate);
		weeklyHoursWorked = hWorked;
	}
	/**
	 * 
	 * @param h
	 * Method for setting weekly hours worked
	 */
	public void setWeeklyHoursWorked(int h)
	{
		weeklyHoursWorked = h;
	}
	/**
	 * 
	 * @return
	 * Method for returning weekly hours worked
	 */
	public int getWeeklyHoursWorked()
	{
		return weeklyHoursWorked;
	}
	/**
	 * Method for returning monthly earning for Partime staff
	 */
	public double monthlyEarning()
	{
		return super.getHourlyRate() * weeklyHoursWorked * 4;
	}
	
	public void inputEmployeeInfo(String directory) throws IOException
	{
		FileInputStream fs = new FileInputStream(directory);
		BufferedReader br = new BufferedReader(new InputStreamReader(fs));
		//System.out.println("Input First Name:");
		setFirstName(br.readLine());
		//System.out.println("Input Last Name:");
		setLastName(br.readLine());
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
		//System.out.println("Input Hourly Rate:");
		setHourlyRate(Double.parseDouble(br.readLine()));
		//System.out.println("Input Weekly hours Worked");
		setWeeklyHoursWorked(Integer.parseInt(br.readLine()));
		br.close();
	}
}
