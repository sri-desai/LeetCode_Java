import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;


public class SortCharactersByFrequency 
{
	public String frequencySort(String s) 
	{
		HashMap<Character, Integer> hashMap = new HashMap<>();
		
		StringBuffer sbuff = new StringBuffer();
		
		for(int i = 0; i < s.length(); ++i)
		{
			if(hashMap.containsKey(s.charAt(i)))
			{
				hashMap.put(s.charAt(i), hashMap.get(s.charAt(i)) + 1);
			}
			else
			{
				hashMap.put(s.charAt(i), 1);
			}
		}
		
		List<Entry<Character, Integer>> list = new ArrayList<>(hashMap.entrySet());
		
		Collections.sort(list, new Comparator<Entry<Character, Integer>>() {

			@Override
			public int compare(Entry<Character, Integer> o1, Entry<Character, Integer> o2) 
			{
				return o2.getValue() - o1.getValue();
			}
		});
		
		for(int i = 0; i < list.size(); ++i)
		{
			int count = list.get(i).getValue();
			
			while(count-- > 0)
			{
				sbuff.append(list.get(i).getKey());
			}
		}
		
		return sbuff.toString();
    }
	
	public static void main(String[] args)
	{
		System.out.println(new SortCharactersByFrequency().frequencySort("baa111"));
	}
}
