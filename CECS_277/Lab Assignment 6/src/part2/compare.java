package part2;
import java.util.Comparator;
import java.util.Map;
public class compare implements Comparator {

	/**
	 * Comparator for ordering students in map
	 */
	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		Map.Entry<Student, String> s1 = (Map.Entry<Student, String>) o1;
		Map.Entry<Student, String> s2 = (Map.Entry<Student, String>) o2;
		if(s1.getKey().getLastName().compareTo(s2.getKey().getLastName()) == 0)
		{
			if(s1.getKey().getFirstName().compareTo(s2.getKey().getFirstName()) == 0)
			{

				if(s1.getKey().getID() < s2.getKey().getID())
				{
					return -1;
				}
				else
				{
					return 1;
				}
			}
			else
			{
				return s1.getKey().getFirstName().compareTo(s2.getKey().getFirstName());
			}
			
		}
		else
		{
			return s1.getKey().getLastName().compareTo(s2.getKey().getLastName());
		}
	}

}
