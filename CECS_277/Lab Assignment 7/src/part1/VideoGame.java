package part1;
/**
 * 
 * Product CLass: VideoGame
 *
 */
public class VideoGame implements Visitable
{
	private String title;
	private double cost;
	
	VideoGame(String tit)
	{
		title = tit;
	}
	
	@Override
	public double accept (orderVisitor visitor)
	{
		return visitor.visit(this);
	}
	
	@Override
	public double accept(CashierVisitor visitor, double num)
	{
		return visitor.visit(this,num);	
	}

	
	public double getCost()
	{
		return cost;
	}

	public String getTitle() {
		// TODO Auto-generated method stub
		return title;
	}

	public void setCost(double price) 
	{
		cost = price;
		System.out.println(title + ": " + cost);
	}
	
	
}
