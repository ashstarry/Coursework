package part2;
import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		HashMap<Student, Integer> studentMap = new HashMap<Student, Integer>();
		HashMap<Student, String> gradeMap = new HashMap<Student, String>();
		menu(studentMap, gradeMap);
	}
/**
 * User Menu Method
 * @param studentMap
 * @param gradeMap
 * @throws IOException
 * @throws ClassNotFoundException
 */
	public static void menu(HashMap<Student, Integer> studentMap, HashMap<Student, String> gradeMap)throws IOException, ClassNotFoundException
	{
		System.out.println("What would you like to do?");
		System.out.println("1: Add Student Manually");
		System.out.println("2: Load Students From File");
		System.out.println("3: Remove Student");
		System.out.println("4: Modify Grades");
		System.out.println("5: Print Grades");
		System.out.println("6: Save Grades");
		System.out.println("7: Exit");
		
		Scanner input = new Scanner(System.in);
		int c = input.nextInt();
		switch(c)
		{
			case 1: add(studentMap, gradeMap); break;
			case 2: load(studentMap, gradeMap); break;
			case 3: remove(studentMap, gradeMap); break;
			case 4: modify(studentMap, gradeMap); break;
			case 5: print(studentMap, gradeMap); break;
			case 6: save(studentMap, gradeMap); break;
			case 7: System.exit(0);
			default: System.out.println("Error"); menu(studentMap, gradeMap); break;
		}
		
	}
	/**
	 * Method to add student(s) from user input
	 * @param studentMap
	 * @param gradeMap
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public static void add(HashMap<Student, Integer> studentMap, HashMap<Student, String> gradeMap) throws ClassNotFoundException, IOException
	{
		Student s = new Student();
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Student Last Name");
		String l = input.next();
		s.setLastName(l);
		System.out.println("Enter Student First Name");
		String f = input.next();
		s.setFirstName(f);
		System.out.println("Enter Student ID");
		int id = input.nextInt();
		s.setID(id);
		for(Map.Entry<Student, Integer> stu : studentMap.entrySet())
		{
			if(s.hashCode() == stu.getKey().hashCode())
			{
				System.out.println("Error: Student already present");
				System.out.println("Would you like to add a different student? Enter y or n");
				String choice = input.next();
				if(choice.charAt(0) == 'y' || choice.charAt(0) == 'Y' )
				{
					add(studentMap, gradeMap);
				}
				else if(choice.charAt(0) == 'n' || choice.charAt(0) == 'N')
				{
					menu(studentMap, gradeMap);
				}
				else
				{
					System.out.println("Choice could not be read. Returning to menu.");
					menu(studentMap, gradeMap);
				}
			}
		}
		studentMap.put(s, s.getID());
		gradeMap.put(s, " ");
		System.out.println("Student - " + s.getFirstName() + " " + s.getLastName() + " - added to class");
		System.out.println("Would you like to add another student? Enter y or n");
		String choice = input.next();
		if(choice.charAt(0) == 'y' || choice.charAt(0) == 'Y' )
		{
			add(studentMap, gradeMap);
		}
		else if(choice.charAt(0) == 'n' || choice.charAt(0) == 'N')
		{
			menu(studentMap, gradeMap);
		}
		else
		{
			System.out.println("Choice could not be read. Returning to menu.");
			menu(studentMap, gradeMap);
		}
	}
	/**
	 * Method to load student(s) from an object file
	 * @param studentMap
	 * @param gradeMap
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public static void load(HashMap<Student, Integer> studentMap, HashMap<Student, String> gradeMap) throws ClassNotFoundException, IOException
	{
		ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream("/Users/breeland/Documents/CECS 277 Lab Docs/Lab 6/studentMap.txt"));
		studentMap = (HashMap<Student, Integer>) ois1.readObject();
		ois1.close();
		
		ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream("/Users/breeland/Documents/CECS 277 Lab Docs/Lab 6/gradeMap.txt"));
		gradeMap = (HashMap<Student, String>) ois2.readObject();
		ois2.close();
		
		System.out.println("Data Loaded."); 
		menu(studentMap, gradeMap);
	}
	/**
	 * Method to remove student(s) from the map
	 * @param studentMap
	 * @param gradeMap
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static void remove(HashMap<Student, Integer> studentMap, HashMap<Student, String> gradeMap)throws IOException, ClassNotFoundException
	{
		Set<Map.Entry<Student, Integer>> sMap = studentMap.entrySet();
		Student s = new Student();
		System.out.println("Enter the ID of the Student you want to remove");
		Scanner input = new Scanner(System.in);
		int id = input.nextInt();
		boolean isPresent = false;
		for(Map.Entry<Student, Integer> stu: sMap)
		{
			if(id == stu.getKey().getID())
			{
				s = stu.getKey();
				studentMap.remove(s);
				gradeMap.remove(s);
				isPresent = true;
			}
			if(isPresent)
				break;
		}
		
		if(isPresent)
		{
			System.out.println("Student " + s.getFirstName() + " " + s.getLastName() + " removed from class");
			menu(studentMap, gradeMap);
		}
		else
		{
			System.out.println("Student not found in class");
			menu(studentMap, gradeMap);
		}
		
		System.out.println("Would you like to remove another student? Enter y or n");
		String choice = input.next();
		if(choice.charAt(0) == 'y' || choice.charAt(0) == 'Y' )
		{
			remove(studentMap, gradeMap);
		}
		else if(choice.charAt(0) == 'n' || choice.charAt(0) == 'N')
		{
			menu(studentMap, gradeMap);
		}
		else
		{
			System.out.println("Choice could not be read. Returning to menu.");
			menu(studentMap, gradeMap);
		}
	}
	/**
	 * Method to modify student grades
	 * @param studentMap
	 * @param gradeMap
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static void modify(HashMap<Student, Integer> studentMap, HashMap<Student, String> gradeMap)throws IOException, ClassNotFoundException
	{
		Set<Map.Entry<Student, String>> gMap = gradeMap.entrySet();
		Student s = new Student();
		String grade = " ";
		System.out.println("Enter the ID of the Student you want to modify");
		Scanner input = new Scanner(System.in);
		int id = input.nextInt();
		boolean isPresent = false;
		for(Map.Entry<Student, String> stu: gMap)
		{
			if(id == stu.getKey().getID())
			{
				s = stu.getKey();
				System.out.println("Enter the student's grade");
				grade = input.next();
				switch(grade)
				{
					case "A" : stu.setValue("A"); break;
					case "B" : stu.setValue("B"); break;
					case "C" : stu.setValue("C"); break;
					case "D" : stu.setValue("D"); break;
					case "F" : stu.setValue("F"); break;
					default: System.out.println("Invalid grade. Returning to menu"); menu(studentMap, gradeMap);
				}
				
				isPresent = true;
			}
			if(isPresent)
				break;
		}
		if(isPresent)
		{
			System.out.println("Student " + s.getFirstName() + " " + s.getLastName() + " grade changed to: " + grade );
			System.out.println("Would you like to modify another student? Enter y or n");
			String choice = input.next();
			if(choice.charAt(0) == 'y' || choice.charAt(0) == 'Y' )
			{
				modify(studentMap, gradeMap);
			}
			else if(choice.charAt(0) == 'n' || choice.charAt(0) == 'N')
			{
				menu(studentMap, gradeMap);
			}
			else
			{
				System.out.println("Input could not be read. Returning to menu.");
				menu(studentMap, gradeMap);
			}
		}
		else
		{
			System.out.println("Student not found in class");
			System.out.println("Would you like to modify different student? Enter y or n");
			String choice = input.next();
			if(choice.charAt(0) == 'y' || choice.charAt(0) == 'Y' )
			{
				modify(studentMap, gradeMap);
			}
			else if(choice.charAt(0) == 'n' || choice.charAt(0) == 'N')
			{
				menu(studentMap, gradeMap);
			}
			else
			{
				System.out.println("Input could not be read. Returning to menu.");
				menu(studentMap, gradeMap);
			}
		}
	}
	/**
	 * Method to print students and grades
	 * @param studentMap
	 * @param gradeMap
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static void print(HashMap<Student, Integer> studentMap, HashMap<Student, String> gradeMap)throws IOException, ClassNotFoundException
	{
		LinkedList tempList = new LinkedList(gradeMap.entrySet());
		Collections.sort(tempList, new compare());
		LinkedHashMap<Student, String> sortedMap = new LinkedHashMap<Student, String>();
		for(Iterator it = tempList.iterator(); it.hasNext();)
		{
			Map.Entry<Student, String> entry = (Map.Entry<Student, String>) it.next();
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		Set<Map.Entry<Student, String>> m = sortedMap.entrySet();
		for(Map.Entry<Student, String> e : m)
		{
			System.out.println(e.getKey().toString() + "\t" + e.getValue());
		}
		
		menu(studentMap, gradeMap);
	}
	/**
	 * Method to save students and grades to object file
	 * @param studentMap
	 * @param gradeMap
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static void save(HashMap<Student, Integer> studentMap, HashMap<Student, String> gradeMap) throws IOException, ClassNotFoundException
	{
		LinkedList sList = new LinkedList(studentMap.entrySet());
		Collections.sort(sList, new compare());
		LinkedList gList = new LinkedList(gradeMap.entrySet());
		Collections.sort(gList, new compare());
		LinkedHashMap<Student, Integer> sortedSMap = new LinkedHashMap<Student, Integer>();
		LinkedHashMap<Student, String> sortedGMap = new LinkedHashMap<Student, String>();
		for(Iterator it = sList.iterator(); it.hasNext();)
		{
			Map.Entry<Student, Integer> entry = (Map.Entry<Student, Integer>) it.next();
			sortedSMap.put(entry.getKey(), entry.getValue());
		}
		for(Iterator it = gList.iterator(); it.hasNext();)
		{
			Map.Entry<Student, String> entry = (Map.Entry<Student, String>) it.next();
			sortedGMap.put(entry.getKey(), entry.getValue());
		}
		
		ObjectOutputStream oos1 = new ObjectOutputStream(new FileOutputStream("/Users/breeland/Documents/CECS 277 Lab Docs/Lab 6/studentMap.txt"));
		oos1.writeObject(sortedSMap);
		oos1.flush();
		oos1.close();
		 
		
		ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream("/Users/breeland/Documents/CECS 277 Lab Docs/Lab 6/gradeMap.txt"));
		oos2.writeObject(sortedGMap);
		oos2.flush();
		oos2.close();
		
		
		System.out.println("Data Saved."); 
		menu(studentMap, gradeMap);
		
		
	}
}
