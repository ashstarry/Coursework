package part1;
import java.util.Comparator;
import java.util.Map;
public class numComparator implements Comparator 
{

	@Override
	public int compare(Object o1, Object o2) {
		Map.Entry<Character, Integer> m1 = (Map.Entry<Character, Integer>) o1;
		Map.Entry<Character, Integer> m2 = (Map.Entry<Character, Integer>) o2;
		if(m1.getValue() > m2.getValue())
		{
			return -1;
		}
		else if(m1.getValue() > m2.getValue())
		{
			return 1;
		}
		else
		{
			return m1.getKey().compareTo(m2.getKey());
		}
	}
	
}
