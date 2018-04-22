package part6;
/**
 * 
 * Main method testing memento calculator program
 *
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n1 = 2;
		int n2 = 3;
		Calculator cal = new Calculator(n1, n2);
		System.out.println("First Calculation: " + n1 + " + " + n2);
		System.out.println(cal.add());
		MementoCalculator m = cal.backupLastCalculation();
		n1 = 6;
		n2 = 7;
		cal = new Calculator(n1, n2);
		System.out.println("Second Calculation: " + n1 + " + " + n2);
		System.out.println(cal.add());
		System.out.println("Restoring First Calculation...");
		cal.restorePrevious(m);
		System.out.println("Restored Calculation: " + m.getNum1() + " + " + m.getNum2());
		System.out.println(cal.add());
	}

}
