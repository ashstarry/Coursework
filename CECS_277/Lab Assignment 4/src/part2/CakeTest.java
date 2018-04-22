package part2;
import java.util.Scanner;
public class CakeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cake c = null;
		System.out.println("Which Cake?");
		Scanner input = new Scanner(System.in);
		String choice  = input.nextLine();
		cakeFactory cf = new cakeFactory();
		c = cf.createCake(choice);
		c.aboutCake();
	}

}
