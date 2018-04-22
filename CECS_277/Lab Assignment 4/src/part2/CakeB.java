package part2;

public class CakeB extends Cake{
	public CakeB()
	{
		setName("Cake A");
		setType("Strawberry Shortcake");
		setPrice(9.50);
			
	}

	public void recipe()
	{
		System.out.println("Strawberry Shortcake Recipe: \nEggs\nMilk\nSugar\nStrawberries\nStuff");
	}
		
	public void myFans()
	{
		System.out.println("Comments: A few people like this cake");
	}

}
