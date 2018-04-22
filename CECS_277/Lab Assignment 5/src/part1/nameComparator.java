package part1;
import java.util.Comparator;
import java.util.Map;
public class nameComparator implements Comparator 
{

	@Override
	public int compare(Object o1, Object o2) {
		Map.Entry<Character, Integer> m1 = (Map.Entry<Character, Integer>) o1;
		Map.Entry<Character, Integer> m2 = (Map.Entry<Character, Integer>) o2;
		return m1.getKey().compareTo(m2.getKey());
	}



}
