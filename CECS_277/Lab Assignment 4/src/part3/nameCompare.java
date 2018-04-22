package part3;
/**
 * 
 * @author Breeland Abrams
 * Comparator class for sorting Employees by last name
 */
import java.util.Comparator;
public class nameCompare implements Comparator<Employee> {
	/**
	 * Comparator sorting Logic
	 */
	@Override
	public int compare(Employee o1, Employee o2) {
	
		return o1.getLastName().compareTo(o2.getLastName());
	}
	
	

}
