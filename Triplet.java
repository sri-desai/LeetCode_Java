import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triplet 
{
	public List<List<Integer>> threeSum(int[] nums) 
	{
        if(nums == null || nums.length == 0)
        {
        	return null;
        }
        
        Arrays.sort(nums);
        
        List<List<Integer>> mainList = new ArrayList<>();
                       
        for(int i = 0; i < nums.length - 2; ++i)
        {
        	List<List<Integer>> indList = new ArrayList<>();     	
        	
        	long curItem = nums[i];
        	
        	if(findSum(0 - curItem, nums, i + 1, indList))
        	{
        		int size = 0;
        		
        		while(size < indList.size())
        		{
        			List<Integer> curList = indList.get(size++);
        			
        			curList.add(0, nums[i]);
        			
        			mainList.add(curList);
        		}        		        	
        	}        	
        }
        
        return mainList;
        
    }

	private boolean findSum(long sumToCheck, int[] nums, int BeginIdx, List<List<Integer>> indList) 
	{
		int startIdx = BeginIdx;
		int endIdx   = nums.length - 1;
		boolean isFound = false;
		
		while(startIdx < endIdx)
		{
			long firstElem = nums[startIdx];
			long secElem   = nums[endIdx];
			
			if( (firstElem + secElem) == sumToCheck)
			{
				List<Integer> smallList = new ArrayList<>();
				
				smallList.add(nums[startIdx]);
				smallList.add(nums[endIdx]);
				indList.add(smallList);
				
				isFound = true;
				
				++startIdx;
				--endIdx;
			}
			else
			if( (firstElem + secElem) < sumToCheck)
			{
				++startIdx;
			}
			else
			{
				--secElem;
			}
		}
		
		return isFound;
	}

	public static void main(String[] args)
	{
		Triplet tripletObj = new Triplet();
		int[] array = {-1, 0, 1, -4};
		
		System.out.println(tripletObj.threeSum(array));
		
	}
}
