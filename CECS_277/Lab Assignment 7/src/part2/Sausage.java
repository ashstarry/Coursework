package part2;
/**
 * 
 * Topping CLass: Sausage
 *
 */
public class Sausage extends PizzaDecorator 
{
	Sausage(Pizza piza) 
	{
		super(piza);
	}
	
	public String makePizza()
	{
		return (super.makePizza() + " with Sausage ");
	}
}
