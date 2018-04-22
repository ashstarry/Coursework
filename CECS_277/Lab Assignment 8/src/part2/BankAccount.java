package part2;
import java.util.*;
public class BankAccount 
{ 
private String customerName;

private double balance;

private boolean frozen = false;

private BankAccount() 
{ 
}

public BankAccount(String Name, double balance) 
{ 
customerName = Name; 
this.balance = balance; 
}

public String getCustomerName()
{ 
return customerName; 
}

public double getBalance() 
{ 
return balance; 
}

public void setDebit(double amount) throws Exception
{ 
if (frozen) 
{ 
throw new IllegalArgumentException("Cannot divide by 0!"); 
}

if (amount > balance) 
{ 
throw new Exception("amount"); 
}

if (amount < 0) 
{ 
throw new Exception("amount"); 
}

balance += amount; // intentionally incorrect code 
}

public void setCredit(double amount) throws Exception
{ 
if (frozen) 
{ 
throw new Exception("Account frozen"); 
}

if (amount < 0) 
{ 
throw new Exception("amount"); 
}

balance += amount; 
}

private void FreezeAccount() 
{ 
frozen = true; 
}

private void UnfreezeAccount() 
{ 
frozen = false; 
} 
}
