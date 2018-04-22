/**
 * 
 * @author Breeland Abrams
 * Test Class for Employee database
 */
import java.util.ArrayList;
import java.util.Collections;
public class tester 
{

	public static void main(String[] args) throws CloneNotSupportedException 
	{
		// TODO Auto-generated method stub
		/**
		 * Array Deceleration and instantiation of Employees (Staff, Faculty, and Partime)
		 */
		Employee e[] = new Employee[10];
		
		e[0] = new Staff("Allen", "Patia", "123", "M", 2, 23, 1959, 50);
		e[1] = new Staff("Zapata", "Steven", "245", "F", 7, 12, 1964, 35);
		e[2] = new Staff("Rios", "Enrique","789", "M", 6, 2, 1970, 40 );
		e[3] = new Faculty("Johnson", "Anne", "243", "F", 4, 27, 1962,"PH.D", "Engineering",3, Faculty.levels.FU);
		e[4] = new Faculty("Bouris", "William", "791", "F", 3, 14, 1975,"PH.D", "English", 1, Faculty.levels.AO);
		e[5] = new Faculty("Andrade", "Christopher", "623", "F", 5, 22, 1980,"MS", "Physical Education", 0, Faculty.levels.AS);
		e[6] = new Partime("Guzman", "Agusto", "455", "F", 8, 10, 1977, 35, 30);
		e[7] = new Partime("Depirro", "Martin", "678", "F", 9, 15, 87, 30, 15);
		e[8] = new Partime("Aldaco", "Marque", "945", "M", 11, 24, 1988, 20, 35);
		
		/**
		 * Output of Staff Info
		 */
		System.out.println("\nStaff Information: ");
		System.out.println(e[0]);
		System.out.println(e[1]);
		System.out.println(e[2]);
		/**
		 * Output of Faculty Info
		 */
		System.out.println("\nFaculty Information: ");
		System.out.println(e[3]);
		System.out.println(e[4]);
		System.out.println(e[5]);
		/**
		 * Output of Partime info
		 */
		System.out.println("\nPart-Time Information: ");
		System.out.println(e[6]);
		System.out.println(e[7]);
		System.out.println(e[8]);
		/**
		 * Output of Monthly Salary for all Partime Employees
		 */
		double pSalary = 0;
		for(int i = 6; i < e.length-1; i++)
		{
			pSalary += e[i].monthlyEarning();
		}
		System.out.println("\nMonthly Salary for Part-Time Staff: $" + pSalary);
		/**
		 * Output of Monthy Salary for all Employees
		 */
		double eSalary = 0;
		for(int i = 0; i < e.length-1; i++)
		{
			eSalary += e[i].monthlyEarning();
		}
		System.out.println("\nMonthly Salary for All Employees: $" + eSalary);
		/**
		 * Sorting array in ascending order by ID number
		 */
		ArrayList<Employee> ID = new ArrayList<Employee>();
		for(int i = 0; i< e.length-1; i++)
		{
			ID.add(e[i]);
		}
		Collections.sort(ID);
		System.out.println("\nID Sort: ");
		System.out.println(ID);
		/**
		 * Sorting array in descending order by last name
		 */
		ArrayList<Employee> lastName = new ArrayList<Employee>();
		for(int i = 0; i< e.length-1; i++)
		{
			lastName.add(e[i]);
		}
		Collections.sort(lastName, new nameCompare());
		System.out.println("\nLast Name Sort: ");
		System.out.println(lastName);
		/**
		 * Cloning Faculty Employee in array
		 */
		Faculty ORIGINAL = new Faculty("Johnson", "Anne", "243", "F", 4, 27, 1962,"PH.D", "Engineering",3, Faculty.levels.FU);
		Faculty NEW = (Faculty) ORIGINAL.clone();		
		System.out.print("\nDuplication \nOriginal: " + ORIGINAL.toString() + "\n\nClone: " + NEW.toString());
		ORIGINAL = new Faculty("Flinstone", "Fred", "100", "M", 9, 30, 1960,"BS", "Construction",0, Faculty.levels.AS);
		System.out.print("\n\nClone Check \n\nOriginal:" + ORIGINAL.toString() + "\n\nClone:" + NEW.toString());
		
	}
	
	

}
