package part3;
import java.io.*;
/**
 * 
 * @author Breeland Abrams
 * Staff Class extending from Employee class 
 */
public class Staff extends Employee
{
	private double hourlyRate;
	
	/**
	 * Default Staff Constructor
	 */
	public Staff()
	{
		super();
		hourlyRate = 0;
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
	 * Overloaded Staff Constructor
	 */
	public Staff(String ln, String fn, String id, String sex, int month, int date, int year, int rate)
	{
		super(ln, fn, id, sex, month, date, year);
		hourlyRate = rate;
	}
	/**
	 * 
	 * @param rate
	 * Method for setting hourly rate
	 */
	public void setHourlyRate(double rate)
	{
		hourlyRate = rate;
	}
	/**
	 * 
	 * @return
	 * Method to return hourly rate
	 */
	public double getHourlyRate()
	{
		return hourlyRate;
	}
	/**
	 * Method to return Monthly Earning
	 */
	public double monthlyEarning()
	{
		return hourlyRate * 160;
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
		
	}
	

}
