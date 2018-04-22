/**
 * 
 * Adapter Pattern: Convert serial number to state
 *
 */
public class serialToState {

	public serialToState() {
		// TODO Auto-generated constructor stub
		
	}
	
	public State adaptState(Robot r)
	{
		if(r.getSerial() == 1)
		{
			 return new Fighting();
		}
		else
		{
			return new Housekeeping();
		}
	}

}
