import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MinimumIndexSum 
{
	public String[] findRestaurant(String[] list1, String[] list2) 
	{
		HashMap<String, Integer> map = new HashMap<>();
		List<String> output = new ArrayList<>();
		
		int maxDiff = Integer.MAX_VALUE;
		
		for(int i = 0; i < list1.length; ++i)
		{
			map.put(list1[i], i);
		}
		
		for(int i = 0; i < list2.length; ++i)
		{
			if(map.containsKey(list2[i]) && map.get(list2[i]) + i <= maxDiff)
			{
				if(map.get(list2[i]) + i < maxDiff)
				{
					maxDiff = map.get(list2[i]) + i;
					
					output = new ArrayList<>();					
				}
								
				output.add(list2[i]);
			}
		}
		
		return output.toArray(new String[0]);		
    }
	
	public static void main(String[] args)
	{
		String[] first  = {"Shogun","Tapioca Express","Burger King","KFC"};
		String[] second = {"KFC","Shogun","Burger King"};
		
		System.out.println(new MinimumIndexSum().findRestaurant(first, second));
	}
}
