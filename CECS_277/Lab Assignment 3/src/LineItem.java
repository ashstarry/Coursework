/**
   Describes a quantity of an article to purchase.
*/
public class LineItem
{  
   private int quantity;
   private Product theProduct;

   /**
      Constructs an item from the product and quantity.
      @param aProduct the product
      @param aQuantity the item quantity
   */
   public LineItem(Product aProduct, int aQuantity)
   {  
      theProduct = aProduct;
      quantity = aQuantity;
   }
   
   /**
      Computes the total cost of this line item.
      @return the total price
   */
   public double getTotalPrice()
   {  
      return theProduct.getPrice() * quantity;
   }
   
   /**
    * Provides item descriptions for invoice formatting
    * @return theProduct: description
    */
   public String getDescription()
   {
	   return theProduct.getDescription();
   }
   
   /**
    * Provides item prices for invoice formatting
    * @return theProduct: price
    */
   public double getPrice()
   {
	   return theProduct.getPrice();
   }
   
   /**
    * Provides item quantities for invoice formatting
    * @return quantity
    */
   public int getQuantity()
   {
	   return quantity;
   }
   
}
