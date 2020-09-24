
public class MaxSubArraySum
{
	public int minSubArrayLen(int s, int[] nums)
	{
		if(nums == null || s == 0)
		{
			return 0;
		}
		
		int lastIdx = 0;
		int startIdx = 0;
		long sum = 0;
		long min  = Long.MAX_VALUE;
		
		while(lastIdx  < nums.length)
        {
            sum += nums[lastIdx];
            
            while(sum >= s)
            {
                min = Math.min(min, lastIdx - startIdx);
                
                sum -= nums[startIdx];
                
                ++startIdx;
            }            
        }
        
        return min == Long.MAX_VALUE ? 0 : (int)min;
	}
}
