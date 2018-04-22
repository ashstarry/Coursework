
public class node {
	
	private String element;
	private double number;
	private boolean isNumber;
	private int rank;
	private node next;
	
	public node(String element)
	{
		this.element = element;
		this.number = 0;
		this.isNumber = false;
		this.rank = 0;
		this.next = null;
	}
	
	public String getElement()
	{
		return element;
	}
	
	public void setElement(String element)
	{
		this.element = element;
	}
	public void setNumber(double number)
	{
		this.number = number;
	}
	public double getNumber()
	{
		return number;
	}
	public node getNext()
	{
		return next;
	}
	
	public void setNext(node next)
	{
		this.next = next;
	}
	
	public void setIsNumber(boolean isNumber)
	{
		this.isNumber = isNumber;
	}
	public boolean getIsNumber()
	{
		return isNumber;
	}
	public void setRank(int rank)
	{
		this.rank = rank;
	}
	public void setSingleRank()
	{
		if(this.element.compareTo("(") == 0 || this.element.compareTo(")") == 0)
		{
			this.setRank(1);
		}
		if(this.element.compareTo("+") == 0 || this.element.compareTo("-") == 0)
		{
			this.setRank(2);
		}
		if(this.element.compareTo("*") == 0 || this.element.compareTo("/") == 0)
		{
			this.setRank(3);
		}
		if(this.element.compareTo("^") == 0 )
		{
			this.setRank(4);
		}
	}
	public int getRank()
	{
		return rank;
	}
	public void display()
	{
		System.out.print(element);
	}
	
}
