import java.util.Scanner;

public class Program {

	public static void main(String[] args) 
	{
		
		initialList();
	}
	
	public static void initialList()
	{
		int wordCount;
		System.out.println("How many words would you like in the list? (Please enter a number 15-240)");
		Scanner input = new Scanner(System.in);
			
		while(!input.hasNextInt())
		{
			System.out.println("Please enter a valid number.");
			input.next();
		}
		wordCount = input.nextInt();
		
		while(wordCount < 15 || wordCount > 240)
		{
			System.out.println("Please enter a valid number between 15 and 240.");
				while(!input.hasNextInt())
				{
					System.out.println("Please enter a valid number.");
					input.next();
				}
				wordCount = input.nextInt();
		}
		
		LinkedList randomWords = new LinkedList();
		
		randomWords.addStart(wordCount);
		
		System.out.println("List of " + wordCount + " words:");
		randomWords.display();
		System.out.println("");
		menu(randomWords, wordCount);
	}

	
	public static void menu(LinkedList randomWords, int wordCount)
	{
		
		System.out.println("What would you like to do?");
		System.out.println("1. Add a word");
		System.out.println("2. Delete a word");
		System.out.println("3. Quit");
		
		int choice;
		Scanner input = new Scanner(System.in);
		while(!input.hasNextInt())
		{
			System.out.println("Please enter a valid number 1-3");
			input.next();
		}
		choice = input.nextInt();
		switch(choice)
		{
		case 1: add(randomWords, wordCount);
		case 2: delete(randomWords, wordCount);
		case 3: return;
		default: {System.out.println("Please enter a valid number 1-3");
				menu(randomWords, wordCount);}
		}
	}
	
	public static void add(LinkedList randomWords, int wordCount)
	{
		randomWords.add();
		randomWords.display();
		System.out.println("");
		menu(randomWords, wordCount);
		
	}
	
	public static void delete(LinkedList randomWords, int wordCount)
	{
		System.out.println("What word would you like to delete?");
		Scanner input = new Scanner(System.in);
		String tempW = input.next();
		randomWords.delete(tempW);
		randomWords.display();
		System.out.println("");
		
		menu(randomWords, wordCount);
	}

}
