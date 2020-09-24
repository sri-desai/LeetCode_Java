import java.util.Arrays;
import java.util.HashMap;

public class CombinationSum4 
{
	HashMap<Integer, Integer> map;
	
	public int combinationSum4(int[] nums, int target) 
	{
		Arrays.sort(nums);
		
		map = new HashMap<>();
		
		for(int i = 0; i <= target; ++i)
		{
			map.put(i, getCombination(nums, i));
		}
		
		return map.get(target);
	}
	
	private int getCombination(int[] nums, int target) 
	{
		if(map.containsKey(target)) return map.get(target);
		
		int count = 0;
		
		if(target <= 0)
		{
			return target < 0 ? 0 : 1;
		}
		else
		{
			for(int i = 0; i < nums.length; ++i)
			{
				if(nums[i] > target) return count;
				
				count += getCombination(nums, target - nums[i]); 
			}
			
			return count;
		}
	}

	public static void main(String[] args)
	{
		int[] array = {1, 2, 3};
		
		System.out.println(new CombinationSum4().combinationSum4(array, 120));
	}
}
