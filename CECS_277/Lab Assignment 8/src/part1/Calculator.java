package part1;

public class Calculator {
	public static int add(int number1, int number2) {
		return number1 + number2; }
		public static int sub(int number1, int number2) { 
			return number1 - number2;
		}
		public static int mul(int number1, int number2) { 
			return number1 * number2;
		}

		public static int divInt(int number1, int number2) {
			if (number2 == 0) {
				throw new IllegalArgumentException("Cannot divide by 0!");
			}
			return number1 / number2;
		}
		public static double divReal(int number1, int number2) {
			if (number2 == 0) {
				throw new IllegalArgumentException("Cannot divide by 0!");
			}
			return (double) number1 / number2;
		}
}
		
