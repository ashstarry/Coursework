package part2;

public class cakeFactory implements Factory
{
	public Cake createCake(String name)
	{
		Cake c = null;
		if(name.equals("CakeA"))
			c = new CakeA();
		else if(name.equals("CakeB"))
			c = new CakeB();
		
		else if(name.equals("CakeC"))
			c = new CakeC();
		return c;
	}

}
