package part3;
import java.io.IOException;
/**
 * 
 * @author Breeland Abrams
 * Test Class for Employee database
 */
import java.util.ArrayList;
import java.util.Collections;
public class tester 
{

	public static void main(String[] args) throws CloneNotSupportedException, IOException 
	{
		
		// TODO Auto-generated method stub
		
		Employee e[] = new Employee[10];
		EmployeeFactory ef = new EmployeeFactory();
		for(int i = 0; i < 3; i++)
		{
			e[i] = ef.createEmployee("S");
		}
		for(int i = 3; i < 6; i++)
		{
			e[i] = ef.createEmployee("F");
		}
		for(int i = 6; i < 9; i++)
		{
			e[i] = ef.createEmployee("P");
		}
		ef.fillEmployees(e);
		System.out.print("Staff Information: ");
		for(int i = 0; i < 3; i++)
		{
			ef = new EmployeeFactory(e[i]);
			ef.print();
		}
		System.out.print("\n\nFaculty Information: ");
		for(int i = 3; i < 6; i++)
		{
			ef = new EmployeeFactory(e[i]);
			ef.print();
		}
		System.out.print("\n\nPart Time Information: ");
		for(int i = 6; i < 9; i++)
		{
			ef = new EmployeeFactory(e[i]);
			ef.print();
		}
		double pSalary = 0;
		for(int i = 6; i < e.length-1; i++)
		{
			pSalary += e[i].monthlyEarning();
		}
		System.out.print("\n\nMonthly Salary for Part-Time Staff: $" + pSalary);
		
		double eSalary = 0;
		for(int i = 0; i < e.length-1; i++)
		{
			eSalary += e[i].monthlyEarning();
		}
		System.out.println("\n\nMonthly Salary for All Employees: $" + eSalary);
		
		ArrayList<Employee> ID = new ArrayList<Employee>();
		for(int i = 0; i< e.length-1; i++)
		{
			ID.add(e[i]);
		}
		Collections.sort(ID);
		System.out.print("\nID Sort: ");
		for(int i = 0; i < ID.size(); i++)
		{
			EmployeeFactory idSort = new EmployeeFactory(ID.get(i));
			idSort.print();
		}
		
		System.out.print("\n\nLast Name Sort: ");
		ArrayList<Employee> lastName = new ArrayList<Employee>();
		for(int i = 0; i< e.length-1; i++)
		{
			lastName.add(e[i]);
		}
		Collections.sort(lastName, new nameCompare());
		
		for(int i = 0; i < ID.size(); i++)
		{
			EmployeeFactory lastNameSort = new EmployeeFactory(lastName.get(i));
			lastNameSort.print();
		}
		
		Faculty oFaculty = (Faculty) e[3];
		Faculty nFaculty = (Faculty) oFaculty.clone();
		EmployeeFactory o = new EmployeeFactory(oFaculty);
		EmployeeFactory n = new EmployeeFactory(nFaculty);
		System.out.print("\nDuplication\n\nOriginal: ");
		o.print();
		System.out.print("\n\nClone: ");
		n.print();
		oFaculty = (Faculty) e[4];
		o = new EmployeeFactory(oFaculty);
		System.out.print("\n\nClone Check \n\nOriginal:");
		o.print();
		System.out.print("\n\nClone:");
		n.print();
		
	}
	
	

}
