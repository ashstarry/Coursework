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
	/**
	 * String representation of Staff object
	 */
	public String toString()
	{
		return super.toString() + "\nFull Time \nMontly Salary: $ " + monthlyEarning();
	}

}
