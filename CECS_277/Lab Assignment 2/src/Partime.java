/**
 * 
 * @author Breeland Abrams
 * Partime Class extending Staff class
 */
public class Partime extends Staff 
{
	private int weeklyHoursWorked;
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
	/**
	 * String representation of Partime object
	 */
	public String toString()
	{
		return "\n\nEmployee ID Number: " + super.getID_Number()
				+ "\nEmployee Name: " + super.getFirstName() + " " + super.getLastName()
				+ "\nSex: " + super.getSex()
				+ "\nBirth Date: " + super.getBirthMonth() + "/" 
				+ super.getBirthDay() + "/" + super.getBirthYear()
				+ "\nHours Worked Per Week: " + weeklyHoursWorked 
				+ "\nMonthly Salary: " + monthlyEarning();
	}
}
