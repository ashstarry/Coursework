package part2;

public abstract class Cake {
	private String name;
	private String type;
	private double price;
	public String getName()
	{
		return name;
	}
	
	void setName(String n)
	{
		name = n;
	}
	
	public double getPrice()
	{
		return price;
	}
	
	void setPrice(double p)
	{
		price = p;
	}
	
	public String getType()
	{
		return type;
	}
	
	void setType(String t)
	{
		type = t;
	}
	
	public abstract void recipe();
	public abstract void myFans();
	public void aboutCake()
	{
		System.out.println("Type: " + getType() + "\nPrice: $" + getPrice());
		recipe();
		myFans();
	}

}
