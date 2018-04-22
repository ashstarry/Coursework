package part6;
/**
 * 
 * Calculator Class to be backed up
 *
 */
public class Calculator {

	private int num1;
	private int num2;
	Calculator(int n1, int n2)
	{
		num1 = n1;
		num2 = n2;
	}
	
	public int add()
	{
		return num1 + num2;
	}
	
	public MementoCalculator backupLastCalculation()
	{
		return new MementoCalculator(num1, num2);
	}

	public void restorePrevious(MementoCalculator m)
	{
		num1 = m.getNum1();
		num2 = m.getNum2();
	}
}
