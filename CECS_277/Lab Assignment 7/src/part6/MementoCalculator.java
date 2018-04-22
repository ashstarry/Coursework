package part6;
/**
 * 
 * Memento class for Memento Pattern Java Program
 *
 */
public class MementoCalculator {

	private int num1;
	private int num2;

	MementoCalculator(int n1, int n2){
	num1 = n1;
	num2 = n2;
	}

	public void setNum1(int n1)
	{
		num1 = n1;
	}

	public void setNum2(int n2)
	{
		num2 = n2;
	}
	
	public int getNum1()
	{
		return num1;
	}
	public int getNum2()
	{
		return num2;
	}

}
