import java.util.HashMap;
import java.util.Map;

public class DegreeOfArray 
{
	public int findShortestSubArray(int[] nums) 
	{
		if(nums == null || nums.length == 0) return 0;
		
		Map<Integer, Integer[]> map    = new HashMap<>();
		
		int curMax = Integer.MIN_VALUE;
		int minLen = Integer.MAX_VALUE;
		
		for(int curNumIdx = 0; curNumIdx < nums.length; ++curNumIdx)
		{
			if(!map.containsKey(nums[curNumIdx]))
			{
				Integer[] posCountOccurence = {curNumIdx, 0};
				
				map.put(nums[curNumIdx], posCountOccurence);								
			}
			
			map.get(nums[curNumIdx])[1] += 1;
			
			
			if(map.get(nums[curNumIdx])[1] > curMax)
			{
				curMax = map.get(nums[curNumIdx])[1];
				minLen = curNumIdx - map.get(nums[curNumIdx])[0] + 1;
			}
			else
			if(map.get(nums[curNumIdx])[1] == curMax)
			{
				minLen = Math.min(minLen, curNumIdx - map.get(nums[curNumIdx])[0] + 1);
			}					
		}
		
		return minLen;
		
    }
	
	public static void main(String[] args)
	{
		int[] array = {2,1,1,2,1,3,3,3,1,3,1,3,2};
		
		System.out.println(new DegreeOfArray().findShortestSubArray(array));
	}
}
