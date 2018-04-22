package part1;

/**
 * Visitable Interface
 */
public interface Visitable
{
	public double accept (orderVisitor visitor);
	public  double accept (CashierVisitor visitor, double num);
}
