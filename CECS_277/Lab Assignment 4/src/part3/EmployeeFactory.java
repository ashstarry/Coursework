package part3;

import java.io.IOException;
public class EmployeeFactory {
	
	private Employee employee;
	
	EmployeeFactory()
	{
		employee = null;
	}
	EmployeeFactory(Employee e)
	{
		employee = e;
	}
	public Employee createEmployee(String t)
	{
		Employee e = null;
		switch(t)
		{
		case "P":
			e = new Partime();
			break;
		case "F":
			e = new Faculty();
			break;
		case "S":
			e = new Staff();
			break;
		}
		return e;
	}
	
	public void fillEmployees(Employee[] e) throws IOException
	{
		/**
		 * Paths to text files for employee input
		 */
		e[0].inputEmployeeInfo("/Users/breeland/Documents/CECS 277 Lab Docs/Lab 4/Employees/Staff 1.txt");
		e[1].inputEmployeeInfo("/Users/breeland/Documents/CECS 277 Lab Docs/Lab 4/Employees/Staff 2.txt");
		e[2].inputEmployeeInfo("/Users/breeland/Documents/CECS 277 Lab Docs/Lab 4/Employees/Staff 3.txt");
		e[3].inputEmployeeInfo("/Users/breeland/Documents/CECS 277 Lab Docs/Lab 4/Employees/Faculty 1.txt");
		e[4].inputEmployeeInfo("/Users/breeland/Documents/CECS 277 Lab Docs/Lab 4/Employees/Faculty 2.txt");
		e[5].inputEmployeeInfo("/Users/breeland/Documents/CECS 277 Lab Docs/Lab 4/Employees/Faculty 3.txt");
		e[6].inputEmployeeInfo("/Users/breeland/Documents/CECS 277 Lab Docs/Lab 4/Employees/PartTime 1.txt");
		e[7].inputEmployeeInfo("/Users/breeland/Documents/CECS 277 Lab Docs/Lab 4/Employees/PartTime 2.txt");
		e[8].inputEmployeeInfo("/Users/breeland/Documents/CECS 277 Lab Docs/Lab 4/Employees/PartTime 3.txt");
	}
	public void print()
	{
		if(employee instanceof Partime)
		{
			Partime p = (Partime) employee;
			System.out.print("\n\nEmployee ID Number: " + p.getID_Number()
					+ "\nEmployee Name: " + p.getFirstName() + " " + p.getLastName()
					+ "\nSex: " + p.getSex()
					+ "\nBirth Date: " + p.getBirthMonth() + "/" 
					+ p.getBirthDay() + "/" + p.getBirthYear()
					+ "\nHours Worked Per Week: " + p.getWeeklyHoursWorked() 
					+ "\nMonthly Salary: $" + p.monthlyEarning());
		}
		else if(employee instanceof Faculty)
		{
			Faculty e = (Faculty) employee;
			System.out.print("\n\nEmployee ID Number: " + e.getID_Number()
					+ "\nEmployee Name: " + e.getFirstName() + " " + e.getLastName()
					+ "\nSex: " + e.getSex()
					+ "\nBirth Date: " + e.getBirthMonth() + "/" 
					+ employee.getBirthDay() + "/" + e.getBirthYear()
					+ "\nDegree: " + e.getEducation().getDegree() 
					+ "\nMajor: " + e.getEducation().getMajor() 
					+ "\nResearched Conducted: " + e.getEducation().getResearches()
					+ "\nPosition: " + e.getRank() + " Professor");
			
		}
		else if(employee instanceof Staff)
		{
			System.out.print("\n\nEmployee ID Number: " + employee.getID_Number()
					+ "\nEmployee Name: " + employee.getFirstName() + " " + employee.getLastName()
					+ "\nSex: " + employee.getSex()
					+ "\nBirth Date: " + employee.getBirthMonth() + "/" 
					+ employee.getBirthDay() + "/" + employee.getBirthYear() 
					+ "\nFull Time \nMontly Salary: $" + employee.monthlyEarning());
			
		}
	}
}
