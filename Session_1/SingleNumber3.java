
public class SingleNumber3 
{
	public int[] singleNumber(int[] nums) 
	{
		int result   = 0;
		int[] num   = new int[2];
		
		for(int i = 0; i < nums.length; ++i)
		{
			result ^= nums[i];
		}
		
		result &= -result;
		
		for(int i = 0; i < nums.length; ++i)
		{
			if((nums[i] & result) == 0)
			{
				num[0] ^= nums[i];
			}
			else
			{
				num[1] ^= nums[i];
			}
		}
		
		return num;
    }
}
