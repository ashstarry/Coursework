package part2;
import java.util.*;
public class BankaccountTest {

public static void main(String[] args) throws Exception
{
// TODO Auto-generated method stub
BankAccount ba = new BankAccount("Mr. Bryan Walton", 3.5);

ba.setCredit(5.00); 
ba.setDebit(2.0); 
System.out.println("Current balance is " + ba.getBalance());

}

}