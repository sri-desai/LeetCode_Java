import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class _4Sum 
{
	/* Need to update */
	public List<List<Integer>> fourSum(int[] nums, int target) 
	{
		HashMap<Integer, Integer>             countMap = new HashMap<>();
		HashMap<Integer, List<List<Integer>>> sumMap   = new HashMap<>();
		HashSet<List<Integer>>                retList  = new HashSet<>();
		
		for(int num : nums)
		{
			countMap.put(num, countMap.getOrDefault(num, 0) + 1);
		}
		
		for(int i = 0; i < nums.length; ++i)
		{
			for(int j = i + 1; j < nums.length; ++j)
			{
				int sum = nums[i] + nums[j];
				
				if(!sumMap.containsKey(sumMap))
				{
					sumMap.put(sum, new ArrayList<>());
				}
				
				List<List<Integer>> mainList = sumMap.get(sum);
				
				List<Integer> subList = new ArrayList<>();
				subList.add(nums[i]);
				subList.add(nums[j]);
				
				mainList.add(subList);								
			}
		}
		
		for(int i = 0; i < nums.length; ++i)
		{
			for(int j = i + 1; j < nums.length; ++j)
			{
				int sum = nums[i] + nums[j];
				
				if(!sumMap.containsKey(target - sum)) continue;
				
				List<Integer> subList = new ArrayList<>();
				
				subList.add(nums[i]);	
				subList.add(nums[j]);
			}
		}
		
		return null;
		
    }
}
