import java.util.HashMap;
import java.util.Map;

public class TwoSum 
{
	public int[] twoSum(int[] nums, int target) 
	{
		if(nums == null || nums.length == 0) return null;
		
		int[] retVal = new int[2];
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i < nums.length; ++i)
		{
			if(map.containsKey(target - nums[i]))
			{
				retVal[1] = i;
				retVal[0] = map.get(target - nums[i]);
				
				break;
			}
			
			map.put(nums[i], i);
		}
		
		return retVal;
		
    }
	
	public static void main(String[] args)
	{
		int[] array = {3, 2, 4};
		
		System.out.println(new TwoSum().twoSum(array, 6));
	}
}
