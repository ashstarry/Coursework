import java.util.ArrayList;
public class hand 
{
	private ArrayList<card> stack;
	
	public hand()
	{
		stack = new ArrayList<card>();
		
	}
	
	public void add(card temp)
	{
		stack.add(temp);
		
	}
	
	public void display()
	{
		for(card hand: stack)
		{
			if(hand.getFaceValue() == false)
			{
				System.out.println("The card is face down");
			}
			else
			{
				System.out.println(hand);
			}
			
		}
	}
	
	public void displayFinal()
	{
		for(card hand: stack)
		{
			hand.setFaceUp();
			System.out.println(hand);
		
		}
	}
	
	public int size()
	{
		return stack.size();
	}
	
	public int points()
	{
		int points = 0; 
		for(card hand : stack)
		{
			
				hand.setValue();
				points = points + hand.getValue();
				if(points > 21 && hand.getName() =="Ace")
					{
						hand.value = 1;
						points = points - 11 + hand.getValue();
					}
					
				
			}
		
		
		return points;
	}
	
	
}
