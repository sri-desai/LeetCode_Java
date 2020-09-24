import java.util.HashSet;

public class ArrayLoop 
{
    public boolean circularArrayLoop(int[] nums) 
    {
    	if(nums == null || nums.length == 0)
    	{
    		return false;
    	}
    	
    	HashSet<Integer> visitedIdx = new HashSet<>();
    	int curPos = 0;
    	int endPos = nums.length - 1;
    	boolean isLoop = false;
    	
    	while(!isLoop && curPos != endPos)
    	{
    		if(visitedIdx.contains(curPos))
    		{
    			isLoop = true;
    		}    		
    		else
    		{
    			visitedIdx.add(curPos);  
    			
    			if(isInternalLoop(curPos, nums))
    			{
    				break;
    			}
    			
    			if(nums[curPos] > 0) 
    			{
    				curPos = (curPos + nums[curPos]) % nums.length;
    			}
    			else
    			{
    				curPos = (curPos + nums[curPos]) < 0 ?  (curPos + nums[curPos] + nums.length) %  nums.length
    						                             :  (curPos + nums[curPos]) 			  %  nums.length;
    			}
    			    		
    		}
    	}
    	    	    	
		return isLoop;        
    }
    
    private boolean isInternalLoop(int startPos, int[] nums) 
    {
    	int curPos             = startPos;
    	boolean isOutOfBounds  = false;
    	boolean isInternalLoop = false;
    	int sum = 0;
    	
    	while(!isInternalLoop && !isOutOfBounds)
    	{
    		sum += nums[curPos];
    		
    		if(sum == 0)
    		{
    			isInternalLoop = true;
    			
    			break;
    		}
    		
    		if(curPos + nums[curPos] >= nums.length || curPos + nums[curPos] < 0)
    		{
    			isOutOfBounds = true;
    			
    			break;
    		}
    		
    		curPos += nums[curPos];    		
    	}
    	
    	
		return isInternalLoop;
	}

	public static void main (String[] args)
    {
    	ArrayLoop loopObj = new ArrayLoop();
    	int[] array = {-2, 1, -1, -2, -2};
    	
    	System.out.println(loopObj.circularArrayLoop(array));
    }
}