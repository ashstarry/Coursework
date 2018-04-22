package part2;
/**
 * 
 * Topping Class: XtraCheese
 *
 */
public class XtraCheese extends PizzaDecorator
{
	XtraCheese(Pizza P) 
	{
		super(P);
	}
	
	public String makePizza()
	{
		return (super.makePizza() + " with XTRA cheese");
	}

}
