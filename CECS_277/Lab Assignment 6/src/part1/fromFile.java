package part1;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.lang.StringBuilder;
import java.io.IOException;
import java.io.PrintWriter;
/**
 * 
 * @author Breeland Abrams
 * Program to sort HashMaps of character frequency from file
 *
 */
public class fromFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/**
		 * String Input from File
		 */
		FileInputStream fs = new FileInputStream("/Users/breeland/Documents/CECS 277 Lab Docs/Lab 5/fromFile.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fs));
		String input = null;
		StringBuilder str = new StringBuilder();
		while((input = br.readLine()) != null)
		{
			str.append(input);
		}
		br.close();
		input = str.toString();
		/**
		 * Converting string to character array
		 */
		input = input.toLowerCase();
		char[] cArray = input.toCharArray();
		/**
		 * Creating HashMap
		 */
		HashMap<Character, Integer> map = createMap(cArray);
		/**
		 * Sorting map by Key
		 */
		sortByKey(map);
		
		/**
		 * Sorting map by Value
		 */
		sortByValue(map);
		
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
	private static void sortByKey(HashMap<Character, Integer> map) throws IOException
	{
		PrintWriter writer = new PrintWriter("/Users/breeland/Documents/CECS 277 Lab Docs/Lab 6/byKey.txt", "UTF-8");
		List list = new LinkedList(map.entrySet());
		Collections.sort(list, new nameComparator());
		HashMap<Character, Integer> sortedMap = new LinkedHashMap<Character, Integer>();
		for(Iterator it = list.iterator(); it.hasNext();)
		{
			Map.Entry<Character, Integer> entry = (Map.Entry<Character, Integer>) it.next();
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		Set<Map.Entry<Character, Integer>> mapSet = sortedMap.entrySet();
		for(Map.Entry<Character, Integer> m: mapSet)
		{
			writer.println( m.getKey() + "\t" + m.getValue());
		}
		writer.close();
	}
	
	/**
	 * Method for creating and returning a sorted hash map using list and Comparator
	 * @param HashMap<Character, Integer> map
	 * @return HashMap<Character, Integer> sortedMap
	 */
	private static void sortByValue(HashMap<Character, Integer> map) throws IOException
	{
		PrintWriter writer = new PrintWriter("/Users/breeland/Documents/CECS 277 Lab Docs/Lab 6/byValue.txt", "UTF-8");
		List list = new LinkedList(map.entrySet());
		Collections.sort(list, new numComparator());
		HashMap<Character, Integer> sortedMap = new LinkedHashMap<Character, Integer>();
		for(Iterator it = list.iterator(); it.hasNext();)
		{
			Map.Entry<Character, Integer> entry = (Map.Entry<Character, Integer>) it.next();
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		Set<Map.Entry<Character, Integer>> mapSet = sortedMap.entrySet();
		for(Map.Entry<Character, Integer> m: mapSet)
		{
			writer.println(m.getKey() + "\t" + m.getValue());
		}
		writer.close();
		
	}

	
}
