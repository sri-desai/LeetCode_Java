import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams 
{
	public List<List<String>> groupAnagrams(String[] strs) 
	{
		List<List<String>> mainList = new ArrayList<>();
		
		if(strs == null)
		{
			return mainList;
		}
		
		HashMap<String, ArrayList<String>> hmap = new HashMap<>();
		
		for(String str : strs)
		{
			char[] array = str.toCharArray();
			
			Arrays.sort(array);
			
			String sortedStr = new String(array);
			
			if(hmap.containsKey(sortedStr))
			{
				hmap.get(sortedStr).add(str);
			}
			else
			{
				ArrayList<String> list = new ArrayList<>();
				
				list.add(str);
				
				hmap.put(sortedStr, list);
			}
		}
		
		mainList.addAll(hmap.values());
		
		return mainList;
    }

	public static void main(String[] args)
	{
		String[] strArray = {"eat", "tea", "tan", "ate", "nat", "bat"};
		
		System.out.println(new GroupAnagrams().groupAnagrams(strArray));
	}
}
