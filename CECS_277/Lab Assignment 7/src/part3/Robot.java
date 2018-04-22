package part3;
/**
 * 
 * Robot Class
 *
 */

public class Robot {

	private State HappyS;
	private State BoredS;
	private State CurrentS;
	
	Robot()
	{
		HappyS = new Happy();
		BoredS = new Bored();
		CurrentS = new Bored();
	}
	
	public void setCurrentState(State s)
	{
		CurrentS = s;
	}
	
	public State getCurrentState()
	{
		return CurrentS;
	}
	
	public void setHappyState(State s)
	{
		HappyS = s;
	}
	public void setBoredState (State s)
	{
		BoredS = s;
	}
	
	public void execute(Robot r)
	{
		CurrentS.execute(this);
	}

	public State getHappyState() 
	{
		return HappyS;
	}
}
