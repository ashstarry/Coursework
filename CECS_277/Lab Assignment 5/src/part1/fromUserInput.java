package part1;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.io.IOException;
/**
 * 
 * @author Breeland Abrams
 * Program to sort HashMaps of character frequency from User Input
 *
 */
public class fromUserInput {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/**
		 * User Input
		 */
		System.out.print("Enter a String: \n");
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		in.close();
		/**
		 * Converting string to character array
		 */
		input = input.toLowerCase();
		char[] cArray = input.toCharArray();
		/**
		 * Creating HashMap
		 */
		HashMap<Character, Integer> map = createMap(cArray);
		System.out.print("\nMap Contains:\n");
		/**
		 * Sorting map by Key
		 */
		Map<Character, Integer> kSort = sortByKey(map);
		Set<Map.Entry<Character, Integer>> mapSet = kSort.entrySet();
		System.out.print("\nSort by Key: \nKey\tValue");
		for(Map.Entry<Character, Integer> m: mapSet)
		{
			System.out.print("\n" + m.getKey() + "\t" + m.getValue());
		}
		/**
		 * Sorting map by Value
		 */
		HashMap<Character, Integer> vSort = sortByValue(map);
		mapSet = vSort.entrySet();
		System.out.print("\n\nSort by Value: \nKey\tValue");
		for(Map.Entry<Character, Integer> m: mapSet)
		{
			System.out.print("\n" + m.getKey() + "\t" + m.getValue());
		}
	}
	
	
	/**
	 * Method for creating HashMap of character frequency from character array
	 * @param char[] cArray
	 * @return HashMap<Character, Integer> map
	 */
	private static HashMap<Character, Integer> createMap(char[] cArray)
	{
		char[] keys  = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
				'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y','z'};
		int[] values = {0, 0 ,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
							0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		for(char c: cArray)
		{
			switch(c)
			{
				case 'a': values[0] +=1; break;
				case 'b': values[1] +=1; break;
				case 'c': values[2] +=1; break;
				case 'd': values[3] +=1; break;
				case 'e': values[4] +=1; break;
				case 'f': values[5] +=1; break;
				case 'g': values[6] +=1; break;
				case 'h': values[7] +=1; break;
				case 'i': values[8] +=1; break;
				case 'j': values[9] +=1; break;
				case 'k': values[10] +=1; break;
				case 'l': values[11] +=1; break;
				case 'm': values[12] +=1; break;
				case 'n': values[13] +=1; break;
				case 'o': values[14] +=1; break;
				case 'p': values[15] +=1; break;
				case 'q': values[16] +=1; break;
				case 'r': values[17] +=1; break;
				case 's': values[18] +=1; break;
				case 't': values[19] +=1; break;
				case 'u': values[20] +=1; break;
				case 'v': values[21] +=1; break;
				case 'w': values[22] +=1; break;
				case 'x': values[23] +=1; break;
				case 'y': values[24] +=1; break;
				case 'z': values[25] +=1; break;
			}
		}
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i = 0; i < values.length; i++)
		{
			if(values[i] > 0)
			{
				map.put(keys[i], values[i]);
			}
		}
		return map;
	}
	
	/**
	 * Method for creating and returning a sorted hash map using list and Comparator
	 * @param HashMap<Character, Integer> map
	 * @return HashMap<Character, Integer> sortedMap
	 */
	private static HashMap<Character, Integer> sortByKey(HashMap<Character, Integer> map)
	{
		List list = new LinkedList(map.entrySet());
		Collections.sort(list, new nameComparator());
		HashMap<Character, Integer> sortedMap = new LinkedHashMap<Character, Integer>();
		for(Iterator it = list.iterator(); it.hasNext();)
		{
			Map.Entry<Character, Integer> entry = (Map.Entry<Character, Integer>) it.next();
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		return sortedMap;
	}
	
	/**
	 * Method for creating and returning a sorted hash map using list and Comparator
	 * @param HashMap<Character, Integer> map
	 * @return HashMap<Character, Integer> sortedMap
	 */
	private static HashMap<Character, Integer> sortByValue(HashMap<Character, Integer> map)
	{
		List list = new LinkedList(map.entrySet());
		Collections.sort(list, new numComparator());
		HashMap<Character, Integer> sortedMap = new LinkedHashMap<Character, Integer>();
		for(Iterator it = list.iterator(); it.hasNext();)
		{
			Map.Entry<Character, Integer> entry = (Map.Entry<Character, Integer>) it.next();
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		return sortedMap;
	}

	
}
