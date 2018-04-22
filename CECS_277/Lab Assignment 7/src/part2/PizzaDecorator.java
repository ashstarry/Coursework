package part2;
/**
 * 
 * Decorator for Pizza Class
 *
 */
public class PizzaDecorator implements pizzaInterface 
{
	protected Pizza specialPizza;
	
	PizzaDecorator (Pizza P)
	{
		specialPizza = P;
	}
	public String makePizza()
	{
		return specialPizza.makePizza();
		
	}
}
