import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence 
{
	public int longestConsecutive(int[] nums) 
    {
        Set<Integer>  elems = new HashSet<>();
        
        for(int num : nums)
        {
        	elems.add(num);
        }
        
        int maxCount = 0;
        int curCount = 0;
        
        for(int i = 0; i < nums.length; ++i)
        {
        	curCount = 0;
        	
        	if(!elems.contains(nums[i] - 1))
        	{        		        		
        		while(elems.contains(nums[i] + curCount)) ++curCount;        			
        	}
        	
        	maxCount = Math.max(maxCount, curCount);
        }
        
        return maxCount;
    }
}
