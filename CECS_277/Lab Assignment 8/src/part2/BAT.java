package part2;
import static org.junit.Assert.*;
import org.junit.Test;

public class BAT {
private BankAccount Account1 = new BankAccount("Mr. Breeland Abrams", 100);
	
	@Test
	public void DebitTest() throws Exception
	{
		//setDebit
		Account1.setDebit(60);
		assertEquals("Error in SetDebit() logic", 40, Account1.getBalance(), 0.05);
		
	}

}
