package part4;
/**
 * 
 * Test Class for Command Pattern Java Program
 *
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stock s1 = new Stock("IBM", 30);
		Stock s2 = new Stock("APPL", 170);
		Stock s3 = new Stock("MSFT", 85);
		
		Trading t = new Trading();
		Order o1 = new BuyStock(s1, 5);
		Order o2 = new SellStock(s2, 7);
		Order o3 = new BuyStock(s3, 4);
		
		
		t.takeOrders(o1);
		t.takeOrders(o2);
		t.takeOrders(o3);
		
		t.acceptOrders();
	}

}
