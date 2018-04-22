package part2;

import java.util.Scanner;
/**
 * Test Class for Decorator Patter Java Program
 * 
 *
 */
public class main {

	public static void main(String[] args)
	{
		
		pizzaInterface piza = new Pizza();
		pizzaInterface pepper = new Pepporoni(new Pizza());
		pizzaInterface saus = new Sausage(new Pizza());
		pizzaInterface xtra = new XtraCheese(new Pizza());
		Scanner scan = new Scanner (System.in);
		for (int count = 0; count < 3; count = count)
		{
			
			System.out.println("-----MENU----");
			System.out.println("1) BASIC PIZZA");
			System.out.println("2) PEPPORONI PIZZA");
			System.out.println("3) SAUSAGE PIZZA");
			System.out.println("4) EXTRA CHEESE PIZZA");
			
			if (count == 0)
			{
				System.out.println("You can select 3 Pizzas to eat.");
				System.out.println("which type of pizza would you like first?");
			}
			String input= scan.nextLine();
			if (input.equals("1"))
			{
				System.out.println(piza.makePizza());
				count = count+1;
			}
			else if (input.equals("2"))
			{
				System.out.println(pepper.makePizza());
				count = count +1;
			}
			else if (input.equals("3"))
			{
				System.out.println(saus.makePizza());
				count = count +1;
			}
			else if (input.equals("4"))
			{
				System.out.println(xtra.makePizza());
				count = count +1;
			}
			else 
			{
				System.out.println("Please select numbers 1-4 as a selection");
			}

		}

	}
}
