package part2;
/**
 * 
 * Topping Class: Pepperoni
 *
 */
public class Pepporoni extends PizzaDecorator
{

	Pepporoni(Pizza P) 
	{
		super(P);
	}
	
	public String makePizza()
	{
		return (super.makePizza() + " with Pepporoni");
	}

}
