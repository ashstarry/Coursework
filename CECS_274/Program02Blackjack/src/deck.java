import java.util.ArrayList;

public class deck {
	
	private ArrayList<card> pile;
	
	public deck()
	{
		pile = new ArrayList<card>();
		String[] suits = {"Diamonds", "Clubs", "Spades", "Hearts"};
		String[] names = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
		for(int s=0; s < suits.length; s++)
		{
			for(int n=0; n < names.length; n++)
			{
				card c1 = new card(names[n], suits[s], 0, false);
				pile.add(c1);
				
			}
		}
	}
	
	public int size()
	{
		return pile.size();
	}
	
	public void display()
	{
		for(card deck : pile)
		{
			System.out.println(deck);
		}
	}
	
	public void shuffle()
	{
		for(int i=0; i < pile.size(); i++)
		{
			int r = (int) (Math.random()*(pile.size()-i));
			card c2 = new card();
			c2 = pile.get(r);
			pile.add(c2);
			pile.remove(r);
		}
	}
	
	public card deal()
	{
		card c3 = pile.get(0);
		pile.remove(0);
		return c3;
		
	}

}
