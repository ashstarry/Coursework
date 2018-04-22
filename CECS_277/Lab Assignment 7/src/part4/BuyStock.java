package part4;
/**
 * 
 * Class for Buying Stock
 *
 */
public class BuyStock implements Order {

	private Stock stock;
	private int quantity;
	public BuyStock(Stock s, int q) {
		// TODO Auto-generated constructor stub
		stock = s;
		quantity = q;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		stock.buy(quantity);
	}

}
