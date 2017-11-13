import java.util.Arrays;

public class ThreeSumSmaller 
{
	public int threeSumSmaller(int[] nums, int target) 
	{
		if(nums == null || nums.length == 0) return 0;
		
		Arrays.sort(nums);
		
		int totalTriplets = 0;
		
		for(int curIdx = 0; curIdx < nums.length - 2; ++curIdx)
		{
			int lowIdx  = curIdx + 1;
			int highIdx = nums.length - 1;
			
			while(lowIdx < highIdx)
			{
				if(nums[curIdx] + nums[lowIdx] + nums[highIdx] < target)
				{
					totalTriplets += highIdx - lowIdx;
					
					++lowIdx;
				}
				else
				{
					--highIdx;
				}
			}
		}
		
		return totalTriplets;
    }
}
