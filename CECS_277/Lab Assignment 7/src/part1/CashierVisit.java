package part1;

/** 
 * Class CashierVisit to visit other product classes
 */
public class CashierVisit implements CashierVisitor
{
	/**
	 * Method to visit laptop class
	 */
	@Override
	public double visit(Laptop laptop) {
		if (laptop.getTitle().equals("Microsoft Surface"))
		{
			System.out.println("Applying 20% Discount on Microsoft Surface");
			double newCost = laptop.getCost()-(laptop.getCost()*0.20);
			laptop.setCost(newCost);
			System.out.print("New Cost: " + newCost);
		}
		else 
		{
			laptop.setCost(laptop.getCost());
		}
		System.out.println("GET COST: "+ laptop.getCost());
		return laptop.getCost();
	}
	
	/**
	 * Method to visit Mobil class
	 */
	@Override
	public double visit(MobilPhone mobilPhone)
	{
		if (mobilPhone.getTitle().equals("Samsung Galaxy S8"))
		{
			System.out.println("Applying 20% Discount on Samsung Galaxy S8");
			double newCost = mobilPhone.getCost()-(mobilPhone.getCost()*0.20);
			mobilPhone.setCost(newCost);
		}
		else if (mobilPhone.getCost()>400)
		{
			System.out.println("$30 Dollars off " + mobilPhone.getTitle());
			double newCost = mobilPhone.getCost()-30;
			mobilPhone.setCost(newCost);
		}
		else 
		{
			mobilPhone.setCost(mobilPhone.getCost());
		}
		return mobilPhone.getCost();
		
	}
	/**
	 * Method to visit VideoGame class
	 */

	@Override
	public double visit(VideoGame videoGame, double num)
	{
	if (num == 1)
	{
		int count = 0;
		if (videoGame.getTitle().equals("Xbox One"))
		{
			return 1;
		}
		else 
		{return 0;}
	}
	else if (num == 2)
	{
		System.out.println("Between");
		if (videoGame.getTitle().equals("PlayStation 4"))
		{	System.out.println("Applying 20% Discount on PS4");
			double newCost = videoGame.getCost()-(videoGame.getCost()*0.20);
			videoGame.setCost(newCost);
			return videoGame.getCost();
		}
	}
	else if (num ==3) 
	{
		 if (videoGame.getTitle().equals("Xbox One"))
		{	System.out.println("Applying 30% Discount on Xbox");
			double newCost = videoGame.getCost()-(videoGame.getCost()*0.30);
			videoGame.setCost(newCost);
			return videoGame.getCost();
		}
	}
	return 0;
	}	
}

