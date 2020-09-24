
public class TappingRainWater 
{
	public int trap(int[] height) 
	{
		if(height == null || height.length == 0) return 0;
		
		int sum = 0;
		int[] leftMax  = new int[height.length];
		int[] rightMax = new int[height.length];
		
		int curMax = leftMax[0];
		for(int curWall = 0; curWall < leftMax.length; ++curWall)
		{
			curMax = Math.max(curMax, height[curWall]);
			
			leftMax[curWall] = curMax;
		}
		
		curMax = rightMax[height.length - 1];
		for(int curWall = rightMax.length - 1; curWall >= 0; --curWall)
		{
			curMax = Math.max(curMax, height[curWall]);
			
			rightMax[curWall] = curMax;
		}
		
		for(int curWall = 0; curWall < height.length; ++curWall)
		{
			sum += Math.min(leftMax[curWall], rightMax[curWall]) - height[curWall];
		}
		
		return sum;
    }
}

