import java.util.Arrays;

public class ClosestSum 
{
	public int threeSumClosest(int[] nums, int target) 
	{
		int resSum = nums[0] + nums[1] + nums[nums.length - 1];
		
		if(nums == null || nums.length == 0) return -1;
		
		Arrays.sort(nums);
		
		for(int i = 0; i < nums.length - 2; ++i)
		{
			int low = i + 1;
			int high = nums.length - 1;
			
			while(low < high)
			{
				int curSum = nums[i] + nums[low] + nums[high];
				
				if(curSum > target)
				{
					--high;
				}
				else
				{
					++low;
				}
				
				if(Math.abs(curSum - target) < Math.abs(resSum - target)) resSum = curSum;
			}
		}
		
		return resSum;
    }
	
	public static void main(String[] args)
	{
		int[] nums = {-1, 2, 1, -4};
		
		System.out.println(new ClosestSum().threeSumClosest(nums, 1));
	}
}
