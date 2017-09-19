import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class MajorityElement
{
	public List<Integer> majorityElement(int[] nums) 
	{
		if(nums == null || nums.length == 0)
		{
			return new ArrayList<Integer>();
		}
		
		int minCount = (int) Math.floor(nums.length / 3.0);
		HashMap<Integer, Long> hmap = new HashMap<>();
		
		for(int i = 0; i < nums.length; ++i)
		{
			if(hmap.containsKey(nums[i]))
			{
				hmap.put(nums[i], hmap.get(nums[i]) + 1);
			}
			else
			{
				hmap.put(nums[i], (long)1);
			}
		}
		
		HashSet<Integer> set = new HashSet<>();
		List<Integer> list = new ArrayList<>();
		
		for(int i = 0; i < nums.length; ++i)
		{
			if(hmap.get(nums[i]) >= minCount)
			{
				set.add(nums[i]);
			}
		}
		
		list.addAll(set);
		
		return list;
    }
	
	public static void main(String[] args)
	{
		MajorityElement elementObj = new MajorityElement();
		
		int[] array = {1,2,3, 4, 5, 6, 7, 8, 9};
		
		System.out.println(elementObj.majorityElement(array));
	}
}
