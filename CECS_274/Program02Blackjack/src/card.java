
public class card {
	
	public String name;
	private String suit;
	public int value;
	public boolean faceUp;
	
	public card() 
	{
		name = "Ace";
		suit = "Spades";
		value = 0;
		faceUp = false;
	}
	
	public card(String cardName, String cardSuit, int cardValue, boolean faceValue) 
	{
		name = cardName;
		suit = cardSuit;
		value = cardValue;
		faceUp = faceValue;
		
	}
	
	public void setName(String rank)
	{
		name = rank;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setSuit(String cardSuit)
	{
		suit = cardSuit;
	}
	
	public String getSuit()
	{
		return suit;
	}
	
	public void setValue()
	{
		if(name == "Ace")
		{
			value = 11;
		}
		else if(name == "2")
		{
			value = 2;
		}
		else if(name == "3")
		{
			value = 3;
		}
		else if(name == "4")
		{
			value = 4;
		}
		else if(name == "5")
		{
			value = 5;
		}
		else if(name == "6")
		{
			value = 6;
		}
		else if(name == "7")
		{
			value = 7;
		}
		else if(name == "8")
		{
			value = 8;
		}
		else if(name == "9")
		{
			value = 9;
		}
		else
		{
			value = 10;
		}
		
		
	}
	
	public int getValue()
	{
		return value;
	}
	
	public boolean getFaceValue()
	{
		return faceUp;
	}
	
	public void flip()
	{
		faceUp = !faceUp;
	}
	
	public void setFaceUp()
	{
		faceUp = true;
	}

	public void setFaceDown()
	{
		faceUp = false;
	}
	
	public void display()
	{
		if(faceUp == false)
		{
			System.out.println("The card is face down");
		}
		
		else
		{
			System.out.println(this.name + " of " + this.suit);
		}
	}
	
	public String toString()
	{
		return this.name + " of " + this.suit;
	}
}
