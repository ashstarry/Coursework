package part3;
/**
 * 
 * Happy State
 *
 */
public class Happy implements State
{

	@Override
	public void execute(Robot r)
	{
		System.out.println("Cook");
		System.out.println("Talk");
		
	}

}
