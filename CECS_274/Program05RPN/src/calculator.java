import java.util.Scanner;
public class calculator 
{
	public static void main(String[] args)
	{
		String equation;
		System.out.println("Please enter your equation.");
		Scanner input = new Scanner(System.in);
		equation = input.next();
		LinkedList equationList = new LinkedList();
		equationList.setEmpty();
		equationList.toList(equation);
		if(!equationList.isValid())
		{
			main(null);
		}
		equationList.toDouble();
		System.out.println("");
		equationList.postFix();
		System.out.println("");
		System.out.println("Answer: ");
		System.out.println(equationList.calculate(equationList));
		
	}
	
	
}


	
	