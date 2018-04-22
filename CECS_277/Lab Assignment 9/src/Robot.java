/**
 * 
 * Singleton Pattern Constructor: Create a robot with a serial number based on user preference
 *								  Fighting Robots = 1, Housekeeping Robots = 2.
 */
public class Robot {

	private static Robot r;
	private int serial;
	private State current;
	private Robot() {
		// TODO Auto-generated constructor stub
		setState();
	}
	
	public static Robot createNewRobot()
	{
		if(r == null)
		{
			r = new Robot();
		}
		return r;
	}
	
	public void setSerial(int s)
	{
		serial = s;
	}
	
	public int getSerial()
	{
		return serial;
	}
	
	public void setState()
	{
		serialToState s = new serialToState();
		current = s.adaptState(this);
	}
	
	public State getState()
	{
		return current;
	}
	
	

}
