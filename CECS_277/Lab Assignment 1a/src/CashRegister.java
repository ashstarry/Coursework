/**
 * 
 * @author Breeland Abrams
 *CashRegister class
 */
public class CashRegister 
{
	public double purchase;
	public double payment;
	
	/**
	 * CashRegiister Constructor
	 */
	public CashRegister()
	{
		purchase = 0.00;
		payment = 0.00;
	}

	/**
	 * 
	 * @param amount
	 * Method for recording the value of the item being purchased
	 */
	public void recordPurchase(double amount)
	{
		purchase = amount;
	}
	
	/**
	 * 
	 * @param numberOfCoins
	 * @param coin
	 * Method for calculating payment given to the register
	 */
	
	void enterPayment(int numberOfCoins, MonetaryUnit coin)
	{
		payment += numberOfCoins * coin.getValue();
	}
	
	/**
	 * 
	 * @return
	 * Method for calculating and giving change 
	 */
	double giveChange()
	{
		return payment - purchase;
		
		
	}
}
