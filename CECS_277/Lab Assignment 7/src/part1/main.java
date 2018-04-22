package part1;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
/**
 * 
 * Test Class for Visitor Pattern Java Program
 *
 */
public class main 
{
	/**
	 * Main Method
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner (System.in);
		List<Visitable> shoppingCart = new ArrayList<Visitable>(); 
		boolean repeat = true;
		double total=0;
		while (repeat)
		{	
			System.out.println("What would you like to buy?");
			System.out.println("1) Laptops");
			System.out.println("2) MobilPhones");
			System.out.println("3) Video Game Consoles");
			System.out.println("4) Go to Checkout "); 
			String selection = scan.nextLine();
			if (selection.equals("1"))
			{
				System.out.println("What type of Laptop?");
				System.out.println("1) Microsoft Surface");
				System.out.println("2) HP Spectre");
				System.out.println("3) Apple Macbook");
				System.out.println("4) Toshiba Satellite");
				String input = scan.nextLine();
				if (input.equals("1"))
				{
					shoppingCart.add(new Laptop("Microsoft Surface"));
				}
				else if (input.equals("2"))
				{
					shoppingCart.add(new Laptop("HP Spectre"));
				}
				else if (input.equals("3"))
				{
					shoppingCart.add(new Laptop ("Apple Macbook"));
				}
				else
				{
					shoppingCart.add(new Laptop ("Toshiba Satellite"));
				}
			
			}
			else if (selection.equals("2"))
			{
				System.out.println("What type of Mobile Phone?");
				System.out.println("1) Apple iphone X");
				System.out.println("2) Apple iphone 8");
				System.out.println("3) Apple iphone 6");
				System.out.println("4) Samsung Galaxy S8");
				String input = scan.nextLine();
				if (input.equals("1"))
				{
					shoppingCart.add(new MobilPhone("Apple iphone X"));
				}
				else if (input.equals("2"))
				{
					shoppingCart.add(new MobilPhone ("Apple iphone 8"));
				}
				else if (input.equals("3"))
				{
					shoppingCart.add(new MobilPhone ("Apple iphone 6"));
				}
				else 
				{
					shoppingCart.add(new MobilPhone ("Samsung Galaxy S8"));
				}
			
			}
			else if (selection.equals("3"))
			{
				System.out.println("What type of Video Game console?");
				System.out.println("1) Xbox One");
				System.out.println("2) PlayStation 4");
				String input = scan.nextLine();
				if (input.equals("1"))
				{
					shoppingCart.add(new VideoGame("Xbox One"));
				}
				else 
				{
					shoppingCart.add(new VideoGame ("PlayStation 4"));
				}
			}
			else if (selection.equals("4"))
			{
				repeat = false;
				checkOut(shoppingCart);
				break;
			}
			total = calculatePrice(shoppingCart);
			System.out.println("Total: " + total);
			System.out.println();
		}
	}
	/**
	 * Method to apply quantity based discounts 
	 * @param shopCart
	 */
	private static void checkOut(List<Visitable> shopCart)
	{
			CashierVisit c = new CashierVisit();
			double numOfxbox=0;
			double total=0;
			double vgtotal = 0;
			for (Visitable item: shopCart)
			{
				if (item.getClass().getName().equals("VideoGame")==false)
					{
						total = total + item.accept(c,1);
						
					}
			}
			
			for (Visitable item: shopCart)
			{
				if (item.getClass().getName().equals("VideoGame")==true)
				{
					numOfxbox = numOfxbox + item.accept(c, 1);
				}
			}
			if (numOfxbox == 1)
			{
				System.out.println("Xbox One: 499.99");
				vgtotal = vgtotal + 499.99;
			}

			for (Visitable item: shopCart)
			{
				if (item.getClass().getName().equals("VideoGame")==true)
				{
					vgtotal = vgtotal + item.accept(c,2);
					
				}
			}
			
			if (numOfxbox >= 2)
			{
				for (Visitable item: shopCart)
				{
					if (item.getClass().getName().equals("VideoGame")==true)
					{
						vgtotal = vgtotal + item.accept(c,3);
						
					}
				}
			}
			total = total + vgtotal;
			
			System.out.printf("\nSubtotal: %.2f", total );
			
	}
	/**
	 * Method to calculate price of all items in cart
	 * @param shopCart
	 * @return
	 */
	private static double calculatePrice(List<Visitable> shopCart)
	{
		orderVisit v = new orderVisit();
		double sum = 0;
		for (Visitable item: shopCart)
		{
			sum = sum + item.accept(v);
		}
		return sum;
	}

}
