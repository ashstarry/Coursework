/**
 	Factory method for formatting invoice 
 */
public class InvoiceFormatter {
	private Invoice invoice;
	private Address address;
	/**
	 * Constructs an invoice formatter
	 * @param i an invoice that needs formatting
	 */
	public InvoiceFormatter(Invoice i)
	{
		invoice = i;
		address = i.getAddress();
	}
	
	/**
	 * Formats the elements of the invoice in a neat and readable fashion
	 * @return formatted invoice i
	 */
	public String format()
	{
		String f = "                     I N V O I C E\n\n" 
				+ address.getName() + "\n" + address.getStreet() + "\n"
	            + address.getCity() + ", " + address.getState() + " " + address.getZip()
	            + String.format("\n\n%-30s%8s%5s%8s\n",
	                    "Description", "Price", "Qty", "Total");
		for (LineItem item : invoice.getLineItem())
	      {  
	         f = f + String.format("%-30s%8.2f%5d%8.2f", 
	                 item.getDescription(), item.getPrice(), 
	                 item.getQuantity(), item.getTotalPrice()) + "\n";
	      }
		
		f = f + String.format("\nAMOUNT DUE: $%8.2f", invoice.getAmountDue());
		return f;
	}

}
