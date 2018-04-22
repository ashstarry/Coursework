package part1;
/**
 * Product Class: Laptop
 */
public class Laptop implements Visitable
{
	private String title;
	private double cost;
	
	Laptop(String tit)
	{
		title = tit;
	}
	
	Laptop (String tit, double price)
	{
		title = tit;
		cost = price;
	}
	
	@Override
	public double accept(orderVisitor visitor)
	{	
		return visitor.visit(this);
	}
	
	@Override
	public double accept(CashierVisitor visitor, double num)
	{
		return visitor.visit(this);
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public double getCost()
	{
		return cost;
	}

	public void setTitle(String tit)
	{
		title = tit;
	}

	public void setCost(double price) 
	{
		cost = price;
		System.out.println(title + ": " + cost);
		
	}
	

}
