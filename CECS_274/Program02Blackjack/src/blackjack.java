import java.util.Scanner;
public class blackjack 
{
	 
	 static int PLAYERCASH = 10;
	 static int DEALERCASH = 10;
	
	public static void main(String[] args) 
	{// TODO Auto-generated method stub
		deck D1 = new deck();
		menu(D1);
	}
	
	public static void menu(deck D1)
	{
		System.out.println("Welcome to the Blackjack Game");
		System.out.println("1. Create New Deck");
		System.out.println("2. Shuffle Deck");
		System.out.println("3. Display All Cards Remaining in Deck");
		System.out.println("4. Play Blackjack");
		
		int choice;
		Scanner input = new Scanner(System.in);
		choice = input.nextInt();
		
		switch(choice)
		{
		case 1: newDeck(D1);
		case 2: shuffle(D1);
		case 3: displayDeck(D1);
		case 4: blackjack(D1);
		default: {System.out.println("Please enter a valid number 1-4");
					menu(D1);}	
		}
	}

	public static void newDeck(deck D1)
	{
		D1 = new deck();
		System.out.println("New Deck Created. What Would You Like to Do Next?");
		System.out.println("1. Create New Deck");
		System.out.println("2. Shuffle Deck");
		System.out.println("3. Display All Cards Remaining in Deck");
		System.out.println("4. Play Blackjack");
		
		int choice;
		Scanner input = new Scanner(System.in);
		choice = input.nextInt();
		
		switch(choice)
		{
		case 1: newDeck(D1);
		case 2: shuffle(D1);
		case 3: displayDeck(D1);
		case 4: blackjack(D1);
		default: {System.out.println("Please enter a valid number 1-4");
				menu(D1);}
		}

	}
	
	public static void shuffle(deck D1)
	{
		D1.shuffle();
		
		System.out.println("Deck Shuffled. What Would You Like to Do Next?");
		System.out.println("1. Create New Deck");
		System.out.println("2. Shuffle Deck");
		System.out.println("3. Display All Cards Remaining in Deck");
		System.out.println("4. Play Blackjack");
		
		int choice;
		Scanner input = new Scanner(System.in);
		choice = input.nextInt();
		
		switch(choice)
		{
		case 1: newDeck(D1);
		case 2: shuffle(D1);
		case 3: displayDeck(D1);
		case 4: blackjack(D1);
		default: {System.out.println("Please enter a valid number 1-4");
					menu(D1);}
		
		}
		
	}
	
	public static void displayDeck(deck D1)
	{
		D1.display();
		
		System.out.println("Deck Displayed. What Would You Like to Do Next?");
		System.out.println("1. Create New Deck");
		System.out.println("2. Shuffle Deck");
		System.out.println("3. Display All Cards Remaining in Deck");
		System.out.println("4. Play Blackjack");
		
		int choice;
		Scanner input = new Scanner(System.in);
		choice = input.nextInt();
		
		switch(choice)
		{
		case 1: newDeck(D1);
		case 2: shuffle(D1);
		case 3: displayDeck(D1);
		case 4: blackjack(D1);
		default: System.out.println("Please enter a valid number 1-4");
		}

	}
	
	public static void blackjack(deck D1)
	{
		
		if(D1.size() <= 10)
		{
			System.out.println("The deck has 10 cards or less. please create a new deck before continuing a new game.");
			menu(D1);
		}
		int bet, pointsP, pointsD;
		
		System.out.println("The Deck has " + D1.size() + " cards.");
		System.out.println("You have $" + PLAYERCASH + " to bet." );
		
		
		Scanner input = new Scanner(System.in);
		do
		{
			System.out.println("How much will you bet? The dealer will match your bet." );
			while(!input.hasNextInt())
			{
				System.out.println("Please enter a valid number" );
				input.next();
			}
			bet = input.nextInt();
			if(bet > PLAYERCASH)
			{
				System.out.println("You only have $" + PLAYERCASH +" Please place a valid bet." );
				input.next();
				bet = input.nextInt();
			}
			if(bet <= 0)
			{
				System.out.println("Please place a valid bet." );
				input.next();
				bet = input.nextInt();
			}
			
		}while(bet <= 0 || bet > PLAYERCASH);
		
	
		hand player = new hand();
		hand dealer = new hand();
		
		for(int p = 0; p < 2; p++)
		{
			card temp = new card();
			temp = D1.deal();
			temp.flip();
			player.add(temp);
			
		}
		
		for(int d = 0; d < 2; d++ )
		{
			card temp2 = new card();
			temp2 = D1.deal();
			if(d > 0)
			{
				temp2.flip();
			}
			dealer.add(temp2);
		}
		
		System.out.println("You bet $" + bet + ".");
		System.out.println("The dealer's hand is:");
		dealer.display();
		System.out.println("");
		pointsP = 0;
		pointsD = dealer.points();
		String choice = "";
		boolean stay = false;
		do
		{
			System.out.println("Your hand is:");
			player.display();
			pointsP = player.points();
			if(pointsP >= 21)
			{
				break;
			}
			System.out.println("You have " + pointsP + " points");
			System.out.println("Would you like to hit or stand? (Enter [H/S])");	
			choice = input.next();
			if(choice.charAt(0) == 'h' || choice.charAt(0) == 'H')
			{
				card temp = new card();
				temp = D1.deal();
				temp.flip();
				player.add(temp);
			}
			else if(choice.charAt(0) == 's' || choice.charAt(0) == 'S')
			{
				stay = !stay;
			}
			else
			{
				System.out.println("Please enter H for hit or S for stand.");
				choice = input.next();	
			}
		}while(pointsP < 21 && stay == false);
		
		
		
		while(pointsD < 17)
		{
			card temp = new card();
			temp = D1.deal();
			dealer.add(temp);//THIS WAS THE PROBLEM
			pointsD = dealer.points();
		}
		
		System.out.println("The dealer's hand is:");
		dealer.displayFinal();
		System.out.println("The dealer has " + pointsD + " points");
		System.out.println("");
		System.out.println("Your hand is:");
		player.displayFinal();
		System.out.println("You have " + pointsP + " points");
		System.out.println("");
		result(bet, D1, pointsP, pointsD);
	}
	
	public static void result(int bet, deck D1, int pointsP, int pointsD)
	{
		
		Scanner input = new Scanner(System.in);	
		String choice = "";
		
		//PLAYER AND DEALER ARE UNDER 21 POINTS 
		if(pointsP <= 21 && pointsD <= 21)
		{
			int max = Math.max(pointsP, pointsD);
			if(max == pointsP)
			{
				PLAYERCASH = PLAYERCASH + bet;
				DEALERCASH = DEALERCASH - bet;
				if(DEALERCASH == 0)
				{
					end();
				}
				else if(PLAYERCASH == 0)
				{
					end();
				}
				System.out.println("You win this round. Do you want to play again? (Enter [Y/N])");
				do
				{
						System.out.println("Please enter Y for yes or N for no.");
						choice = input.next();	
					
					if(choice.charAt(0) == 'y' || choice.charAt(0) == 'Y')
					{
						menu(D1);
					}
					else
					{
						end();
					}
				}while(choice.charAt(0) != 'y' && choice.charAt(0) != 'Y' && choice.charAt(0) != 'n' && choice.charAt(0) != 'N');
				
			}
			else if(max == pointsD)
			{
				PLAYERCASH = PLAYERCASH - bet;
				DEALERCASH = DEALERCASH + bet;
				if(DEALERCASH == 0)
				{
					end();
					return;
				}
				else if(PLAYERCASH == 0)
				{
					end();
					return;
				}
				System.out.println("You lose this round. Do you want to play again? (Enter [Y/N])");
				do
				{
						System.out.println("Please enter Y for yes or N for no.");
						choice = input.next();	
					
					if(choice.charAt(0) == 'y' || choice.charAt(0) == 'Y')
					{
						menu(D1);
					}
					else
					{
						end();
					}
				}while(choice.charAt(0) != 'y' && choice.charAt(0) != 'Y' && choice.charAt(0) != 'n' && choice.charAt(0) != 'N');
				
				
			}
			
			else if(pointsP == pointsD)
			{
				System.out.println("We have a draw. Do you want to play again? (Enter [Y/N])");
				choice = input.next();
					if(choice.charAt(0) == 'n' || choice.charAt(0) == 'N')
					{
						end();
						
					}
					else if(choice.charAt(0) == 'y' || choice.charAt(0) == 'Y')
					{
						menu(D1);
						
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
		}
		//PLAYER AND DEALER ARE OVER 21 POINTS
		if(pointsP > 21 && pointsD > 21)
		{
			int max = Math.max(pointsP, pointsD);
			if(max == pointsD)
			{
				PLAYERCASH = PLAYERCASH + bet;
				DEALERCASH = DEALERCASH - bet;
				if(DEALERCASH == 0)
				{
					end();
				}
				else if(PLAYERCASH == 0)
				{
					end();
				}
				System.out.println("You win this round. Do you want to play again? (Enter [Y/N])");
				do
				{
						System.out.println("Please enter Y for yes or N for no.");
						choice = input.next();	
					
					if(choice.charAt(0) == 'y' || choice.charAt(0) == 'Y')
					{
						menu(D1);
					}
					else
					{
						end();
					}
				}while(choice.charAt(0) != 'y' && choice.charAt(0) != 'Y' && choice.charAt(0) != 'n' && choice.charAt(0) != 'N');
				
			}
			else if(max == pointsP)
			{
				PLAYERCASH = PLAYERCASH - bet;
				DEALERCASH = DEALERCASH + bet;
				if(DEALERCASH == 0)
				{
					end();
					
				}
				else if(PLAYERCASH == 0)
				{
					end();
					
				}
				System.out.println("You lose this round. Do you want to play again? (Enter [Y/N])");
				do
				{
						System.out.println("Please enter Y for yes or N for no.");
						choice = input.next();	
					
					if(choice.charAt(0) == 'y' || choice.charAt(0) == 'Y')
					{
						menu(D1);
					}
					else
					{
						end();
					}
				}while(choice.charAt(0) != 'y' && choice.charAt(0) != 'Y' && choice.charAt(0) != 'n' && choice.charAt(0) != 'N');
				
				
			}
		}
		//PLAYER BUSTS
		if(pointsP > 21 && pointsD <= 21)
		{
			PLAYERCASH = PLAYERCASH - bet;
			DEALERCASH = DEALERCASH + bet;
			if(DEALERCASH == 0)
			{
				end();
			}
			else if(PLAYERCASH == 0)
			{
				end();
				
			}
			System.out.println("You lose this round. Do you want to play again?");
			do
			{
					System.out.println("Please enter Y for yes or N for no.");
					choice = input.next();	
				
				if(choice.charAt(0) == 'y' || choice.charAt(0) == 'Y')
				{
					menu(D1);
				}
				else
				{
					end();
				}
			}while(choice.charAt(0) != 'y' && choice.charAt(0) != 'Y' && choice.charAt(0) != 'n' && choice.charAt(0) != 'N');
			
			
		}
		//DEALER BUSTS
		if(pointsP <= 21 && pointsD > 21)
		{
			PLAYERCASH = PLAYERCASH + bet;
			DEALERCASH = DEALERCASH - bet;
			if(DEALERCASH == 0)
			{
				end();
			
			}
			else if(PLAYERCASH == 0)
			{
				end();
			
			}
			System.out.println("You win this round. Do you want to play again?");
			do
			{
					System.out.println("Please enter Y for yes or N for no.");
					choice = input.next();	
				
				if(choice.charAt(0) == 'y' || choice.charAt(0) == 'Y')
				{
					menu(D1);
				}
				else
				{
					end();
				}
			}while(choice.charAt(0) != 'y' && choice.charAt(0) != 'Y' && choice.charAt(0) != 'n' && choice.charAt(0) != 'N');
			
		}
		
	}
	public static void end()
{
	if(PLAYERCASH == 0)
	{
		System.out.println("You Lose. You have no more money.");
		System.exit(0);
	}
	else if(DEALERCASH == 0)
	{
		System.out.println("You Win. The dealer has no more money.");
		System.exit(0);
	}
	
	System.out.println("Thanks for playing. Come again soon.");
	System.exit(0);
}
}
