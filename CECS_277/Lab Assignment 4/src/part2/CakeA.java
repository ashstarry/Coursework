package part2;

public class CakeA extends Cake{
	
	public CakeA()
	{
		setName("Cake A");
		setType("Red Velvet");
		setPrice(10.50);
			
	}

	public void recipe()
	{
		System.out.println("Red Velvet Cake Recipe: \nEggs\nMilk\nSugar\nChocolate\nStuff");
	}
		
	public void myFans()
	{
		System.out.println("Comments: Many people like this cake");
	}

}
