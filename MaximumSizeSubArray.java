import java.util.HashMap;
import java.util.Map;

public class MaximumSizeSubArray 
{
	public int maxSubArrayLen(int[] nums, int k) 
    {
        Map<Integer, Integer> sumToPositionMap = new HashMap<>();
        
        int curSum         = 0;
        int maxSubArrayLen = 0;        
        
        for(int curNumIdx = 0; curNumIdx < nums.length; ++curNumIdx)
        {
        	curSum += nums[curNumIdx];
        	
        	if(curSum == k)
        	{
        		maxSubArrayLen = curNumIdx + 1;
        	}
        	else
        	if(sumToPositionMap.containsKey(curSum - k))
        	{
        		maxSubArrayLen = Math.max(maxSubArrayLen, curNumIdx - sumToPositionMap.get(curSum - k));
        	}
        	
        	if(!sumToPositionMap.containsKey(curSum))
        	{
        		sumToPositionMap.put(curSum, curNumIdx);
        	}
        }
        
        return maxSubArrayLen;
    }
}
