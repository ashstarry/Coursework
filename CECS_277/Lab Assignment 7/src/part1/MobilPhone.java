package part1;

/**
 * 
 * Product Class: Mobil
 *
 */
public class MobilPhone implements Visitable
{
	private String title;
	private double cost;
	
	MobilPhone(String tit, double price)
	{
		title = tit;
		price = cost;
	}
	
	public MobilPhone(String tit) 
	{
		title = tit;
	}

	@Override
	public double accept(orderVisitor visitor)
	{
		return visitor.visit(this);
	}

	public double getCost()
	{
		return cost;
	}

	public String getTitle()
	{
		return title;
	}

	public void setCost(double price)
	{
		cost = price;
		System.out.println(title + ": " + cost);
	}

	@Override
	public double accept(CashierVisitor visitor, double num)
	{
		return visitor.visit(this);
	}

}
