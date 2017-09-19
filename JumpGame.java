
public class JumpGame 
{
	public boolean canJump(int[] nums)
	{
		if(nums == null || nums.length == 0 || nums.length == 1)
		{
			return true;
		}
		else
		if(nums[0] == 0)
		{
			return false;
		}
		
		int lastIdx = nums.length - 1;
				
		for(int i = nums.length - 2; i >= 0; ++i)
		{
			if(i + nums[i] >= lastIdx)
			{
				lastIdx = i;
			}
		}
		
		return lastIdx == 0;
    }
	
}
