package part4;
import java.util.List;
import java.util.ArrayList;
/**
 * 
 * Class to keep track of buys and sells
 *
 */
public class Trading {

	private List<Order> orders;
	public Trading() {
		// TODO Auto-generated constructor stub
		orders = new ArrayList<Order>();
		}
	public void takeOrders(Order order)
	{
		orders.add(order);
	}
	
	public void acceptOrders()
	{
		for(Order o : orders)
		{
			o.execute();
		}
		orders.clear();
	}
	
	
}
