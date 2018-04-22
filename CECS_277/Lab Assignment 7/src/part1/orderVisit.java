package part1;
/**
 * 
 * OrderVisit Class
 *
 */
public class orderVisit implements orderVisitor
{
	/**
	 * Method to visit Laptop
	 */
	@Override
	public double visit(Laptop laptop) {
		if (laptop.getTitle().equals("Microsoft Surface"))
		{
			laptop.setCost(899.99);
		}
		else if (laptop.getTitle().equals("Apple Macbook"))
		{
			laptop.setCost(1499.99);
		}
		else if (laptop.getTitle().equals("HP Spectre"))
		{
			laptop.setCost(799.99);
		}
		else if (laptop.getTitle().equals("Toshiba Satellite"))
		{
			laptop.setCost(499.99);
		}
		return laptop.getCost();
	}
	
	/**
	 * Method to visit Mobil
	 */

	@Override
	public double visit(MobilPhone mobilPhone)
	{
		if (mobilPhone.getTitle().equals("Apple iphone X"))
		{
			mobilPhone.setCost(899.99);
		}
		else if (mobilPhone.getTitle().equals("Apple iphone 8"))
		{
			mobilPhone.setCost(699.99);
		}
		else if (mobilPhone.getTitle().equals("Apple iphone 6"))
		{
			mobilPhone.setCost(399.99);
		}
		else if (mobilPhone.getTitle().equals("Samsung Galaxy S8"))
		{
			mobilPhone.setCost(799.99);
		}
		return mobilPhone.getCost();
	}
	/**
	 * Method to visit VideoGame
	 */
	@Override
	public double visit(VideoGame videoGame)
	{
		if (videoGame.getTitle().equals("Xbox One"))
		{
			videoGame.setCost(499.99);
		}
		else if (videoGame.getTitle().equals("PlayStation 4"))
		{
			videoGame.setCost(349.99);
		}
		return videoGame.getCost();
	}

}
