import java.util.Scanner;
/**
 * 
 * Class to test application of Singleton, State, Adapter, and Factory Pattern Java Program
 *
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n, t;
		String c, m = "";
		System.out.println("Welcome to the Robot Factory. What type of robot would you like to create?");
		System.out.println("1. Fighting Robot");
		System.out.println("2. Housekeeping Robot");
		System.out.println("3. Exit");
		Scanner in = new Scanner(System.in);
		t = in.nextInt();
		switch(t)
		{
			case 1: m = "Fighting"; break;
			case 2: m = "Housekeeping"; break;
			case 3: System.out.println("Thank you for using the factory. Please come again.");System.exit(0);
			default: System.out.println("Your selection could not be read. Returning to menu."); main(args);	
		}
		System.out.println("How many Robots would you like to create?");
		n = in.nextInt();
		System.out.println("Creating " + n + " " + m +" robots...");
		RobotFactory rf = new RobotFactory(n, t);
		for(int i = 0; i < n; i++)
		{
			Robot r = Robot.createNewRobot();
			rf.add(r);
		}
		rf.executeAll();
		System.out.println("Would you like to create a new set of robots? (Y/N)");
		c = in.next();
		while(c.charAt(0) != 'Y' && c.charAt(0) != 'y' && c.charAt(0) != 'N' && c.charAt(0) != 'n')
		{
			System.out.println("Please Choose Y for yes or N for no.");
			c = in.next();
		}
		
		if(c.charAt(0) == 'Y' || c.charAt(0) == 'y')
		{
			System.out.println("Restarting...");
			main(args);
		}
		else
		{
			System.out.println("Thank you for using the factory. Please come again.");
			System.exit(0);
		}
		in.close();
	}

}
