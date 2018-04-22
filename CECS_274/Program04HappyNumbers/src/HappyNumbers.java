import java.util.Scanner;
import java.util.ArrayList;
public class HappyNumbers {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		System.out.println("Welcome to the Happy Numbers program. What would you like to do?");
		System.out.println("1. Show Happy Sequence for a Number.");
		System.out.println("2. Show All Happy Numbers in a Range.");
		System.out.println("3. Exit");
		Scanner input = new Scanner(System.in);
		int choice;
		do
		{
			while(!input.hasNextInt())
			{
				System.out.println("Please enter a valid number.");
				input.next();
			}
			choice = input.nextInt();
			if(choice < 1 || choice > 3)
			{
				System.out.println("Please enter a number between 1 and 3");
			}
		}while(choice < 1 || choice > 3);
	
		switch(choice)
		{
		case 1: sequence();
		case 2: range();
		default: return;
		}
	}
	
	public static void sequence()

	{
		int test;
		System.out.println("Enter a number");
		Scanner input = new Scanner(System.in);
		do
		{
			while(!input.hasNextInt())
			{
				System.out.println("Please enter a valid number.");
				input.next();
			}
			test = input.nextInt();
			if(test< 0)
			{
				System.out.println("Please enter a number between 1 and 3");
			}
		}while(test < 0);
	
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		numbers.add(test);
		boolean x = false;
		for(int i = 0; i < numbers.size(); i++)
		{
			test = SoSoD(test);
			numbers.add(test);
			
			for(int j = 1; j < numbers.size(); j++)
			{
				if(numbers.get(j) == 1)
				{
					x = true;
					break;
				}
				for(int k = 0; k < j; k++)
				{
					if(numbers.get(j) == numbers.get(k))
					{
						x = true;
						break;
					}
				}
				
			}
			
			if(x)
			{
				break;
			}
		}
		
		for(int k = 0; k < numbers.size(); k++)
		{
			if(k < numbers.size()-1)
			{
			System.out.print(numbers.get(k) + ", ");
			}
			else
			{
				System.out.print(numbers.get(k));
			}
		}
		if(numbers.get(numbers.size()-1) == 1)
		{
			System.out.print(" - The number " + numbers.get(0) + " is Happy.");
		}
		else
		{
			System.out.print(" - The number " + numbers.get(0) + " is not Happy.");
		}
		System.out.println(" ");
		System.out.println("Would you like to return to the main menu? [Y/N]");
		String choice = input.next();
		if(choice.charAt(0) == 'n' || choice.charAt(0) == 'N')
		{
			System.exit(0);;
			
		}
		else if(choice.charAt(0) == 'y' || choice.charAt(0) == 'Y')
		{
			main(null);
			
		}
		else
		{
			while(choice.charAt(0) != 'y' && choice.charAt(0) != 'Y' && choice.charAt(0) != 'n' && choice.charAt(0) != 'N')
			{
			System.out.println("Please enter Y for yes or N for no.");
			choice = input.next();
			}
		}
	}
	public static void range()
	{
		int test, test2, max, min;
		int counter = 0;
		System.out.println("Enter your first number");
		Scanner input = new Scanner(System.in);
		do
		{
			while(!input.hasNextInt())
			{
				System.out.println("Please enter a valid number.");
				input.next();
			}
			test = input.nextInt();
			if(test < 0)
			{
				System.out.println("Please enter a number between 1 and 3");
			}
		}while(test < 0);
		System.out.println("Enter your second number");
		do
		{
			while(!input.hasNextInt())
			{
				System.out.println("Please enter a valid number.");
				input.next();
			}
			test2 = input.nextInt();
			if(test2 < 0)
			{
				System.out.println("Please enter a number between 1 and 3");
			}
		}while(test2 < 0);
		max = Math.max(test, test2);
		min = Math.min(test, test2);
		ArrayList<String> numbers = new ArrayList<String>();
		for(int i = min; i < max + 1; i++)
		{
			int value = isHappy(i);
			if(value == 1)
			{
				String k = "" +i;
				numbers.add(k);
			}
			else
			{
				numbers.add(".");
			}
		}
			
		for(int k = 0; k < numbers.size(); k++)
		{
			int length = numbers.get(k).length();
			counter += length;
			System.out.print(numbers.get(k));
			if(counter >= 60)
			{
				System.out.println();
				counter = 0;
			}
		
		}
		
		
		System.out.println(" ");
		System.out.println("Would you like to return to the main menu? [Y/N]");
		String choice = input.next();
		if(choice.charAt(0) == 'n' || choice.charAt(0) == 'N')
		{
			System.exit(0);;
			
		}
		else if(choice.charAt(0) == 'y' || choice.charAt(0) == 'Y')
		{
			main(null);
			
		}
		else
		{
			while(choice.charAt(0) != 'y' && choice.charAt(0) != 'Y' && choice.charAt(0) != 'n' && choice.charAt(0) != 'N')
			{
			System.out.println("Please enter Y for yes or N for no.");
			choice = input.next();
			}
		}
	}
	public static int SoSoD(int n)
	{
		if(n < 10)
		{
			return(n * n);
		}
		else
		{
		int digit = n % 10;
		int remainder = (int) Math.floor(n / 10);
		return (digit * digit) + SoSoD(remainder);
		}
	}
	public static int isHappy(int test)
	{
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		numbers.add(test);
		boolean x = false;
		for(int i = 0; i < numbers.size(); i++)
		{
			test = SoSoD(test);
			numbers.add(test);
			
			for(int j = 1; j < numbers.size(); j++)
			{
				if(numbers.get(j) == 1)
				{
					x = true;
					break;
				}
				for(int k = 0; k < j; k++)
				{
					if(numbers.get(j) == numbers.get(k))
					{
						x = true;
						break;
					}
				}
				
			}
			
			if(x)
			{
				break;
			}
		}
		
		return numbers.get(numbers.size()-1);
	}
	
}
