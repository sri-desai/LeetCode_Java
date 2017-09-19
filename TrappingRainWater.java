
public class TrappingRainWater 
{
	public int trap(int[] height) 
	{
		if(height == null || height.length <= 1) return 0;
		
		int  maxWater = 0;
		int[] leftMax = new int[height.length];
		int[] rightMax = new int[height.length];
		
		int maxHeight = height[0];		
		for(int i = 0; i < height.length; ++i)
		{
			if(maxHeight < height[i]) maxHeight = height[i];
			leftMax[i] = maxHeight;
		}
		
		maxHeight = height[height.length - 1];
		for(int i = height.length - 1; i >= 0; --i)
		{
			if(maxHeight < height[i]) maxHeight = height[i];
			rightMax[i] = maxHeight;
		}
		
		for(int i = 0; i < height.length; ++i)
		{
			height[i] = Math.min(leftMax[i], rightMax[i]) - height[i];
			
			maxWater += height[i];
		}
		
		return maxWater;
    }

	public static void main(String[] args)
	{
		int[] array = {0,1,0,2,1,0,1,3,2,1,2,1};
				
		
		System.out.println(new TrappingRainWater().trap(array));
	}
}
