package part3;

/**
 * 
 * Test Class for State Pattern Java Program
 *
 */
public class main {

	public static void main(String[] args)
	{
		Robot roomba = new Robot();
		System.out.println("Roomba the robot is BORED. because he is in the BORED state, he will...");
		roomba.execute(roomba);
		
		System.out.println("We like it when Roomba cooks and talks, so we will set Roomba's current state to Happy so he can do it again");
		roomba.setCurrentState(new Happy());
		roomba.execute(roomba);
	}

}
