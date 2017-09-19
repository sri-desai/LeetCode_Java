import java.util.Arrays;
import java.util.Collections;

public class PartitionEqual 
{
	public boolean canPartition(int[] nums) 
	{
		if(nums == null || nums.length == 0)
			return false;
		
		int sum = 0;
		
		for(int i = 0; i < nums.length; ++i)
		{
			sum += nums[i];
		}
		
		return canBeDone (nums, 0, 0, sum);			
    }
	
	private boolean canBeDone(int[] nums, int startIdx, int curSum, int sum)
	{
		for(int i = startIdx; i < nums.length; ++i)
		{
			if(curSum + nums[i] == sum - curSum + nums[i])
			{
				return true;
			}
			else
			{
				boolean flag = canBeDone(nums, i + 1, curSum + nums[i], sum);
				
				if(flag)
					return flag;				
			}
		}
		
		return false;
	}

	public static void main(String[] args)
	{
		int[] array = {1, 5, 11, 5};
		
		System.out.println(new PartitionEqual().canPartition(array));
	}
}
