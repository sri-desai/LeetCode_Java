import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class SortHashMapByValues 
{
	public static List<Entry<Integer, Integer>> sortByReverseValues (HashMap<Integer, Integer> hashMap)
	{
		List<Entry<Integer, Integer>> list = new ArrayList<>(hashMap.entrySet());
		
		Collections.sort(list, new Comparator<Entry<Integer, Integer>>() {

			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) 
			{
				return o2.getValue() - o1.getValue();
			}
		});
		
		return list;
	}
}
