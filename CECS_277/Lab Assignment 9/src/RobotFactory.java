/**
 * 
 * Factory for Displaying robot information and state execution.
 *
 */
public class RobotFactory {

	Robot[] rr;
	int iterator;
	int serial;
	public RobotFactory(int n, int t) {
		// TODO Auto-generated constructor stub
		rr = new Robot[n];
		iterator = 0;
		serial = t;
	}
	
	public void add(Robot r)
	{
		rr[iterator] = r;
		iterator++;
	}
	
	public void executeAll()
	{
		
		for(Robot r : rr)
		{
			r.setSerial(serial);
			r.setState();
			System.out.println(r.getState().execute());
		}
	}

}
