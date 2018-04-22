package part1;
/**
 * 
 * Cashier Visitor interface for interaction between cashier and product classes
 *
 */
public interface CashierVisitor 
{
	public abstract double visit (Laptop laptop);
	public abstract double visit (MobilPhone mobilPhone);
	public abstract double visit (VideoGame videoGame,double num);
}