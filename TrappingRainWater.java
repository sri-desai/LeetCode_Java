
public class TrappingRainWater 
{
	public int trap(int[] height) 
	{
		if(height == null) return 0;
		
		int maxTrapWater = 0;
		
		int[] leftMax  = new int[height.length];
		int[] rightMax = new int[height.length];
		
		int curMax = Integer.MIN_VALUE;
		
		for(int heightIdx = 0; heightIdx < height.length; ++heightIdx)
		{
			curMax = Math.max(curMax, height[heightIdx]);
			
			leftMax[heightIdx] = curMax; 
		}
		
		curMax = Integer.MIN_VALUE;
		
		for(int heightIdx = height.length - 1; heightIdx >= 0; --heightIdx)
		{
			curMax = Math.max(curMax, height[heightIdx]);
			
			rightMax[heightIdx] = curMax; 
		}
		
		for(int heightIdx = 0; heightIdx < height.length; ++heightIdx)
		{
			maxTrapWater += Math.min(leftMax[heightIdx], rightMax[heightIdx]) - 
					       height[heightIdx];
		}
		
		return maxTrapWater;
    }

	public static void main(String[] args)
	{
		int[] array = {2, 0, 2};
				
		
		System.out.println(new TrappingRainWater().trap(array));
	}
}
