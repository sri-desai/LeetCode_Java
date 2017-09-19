
public class RotateArray
{
	public void rotate(int[] nums, int k) 
	{
		if(nums == null || nums.length == 0)
		{
			return;
		}
		else
		if(k == 0 || k % nums.length == 0)
		{
			return;
		}
		
		if(k > nums.length)
		{
			k -= nums.length;
		}
		
		int[] rotatedList = new int[nums.length];
		int startIdx = 0;
		
		for(int i = nums.length - k; ; i = (i + 1) % nums.length)
		{
			rotatedList[startIdx++] = nums[i];
			
			if(i == nums.length - k - 1)
			{
				break;
			}
		}
		
		
		for(int i = 0; i < nums.length; ++i)
		{
			nums[i] = rotatedList[i];
		}
		
		
    }
}
