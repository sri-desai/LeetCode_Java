

public class ContainMostWater 
{
	public int maxArea(int[] height) 
	{
		if(height == null || height.length == 0)
		{
			return 0;
		}
		
		int water = 0;
		int first = 0;
		int last  = height.length - 1;
		
		while(first < last)
		{
			int curHeight = Math.min(height[first], height[last]);
			water = Math.max(water, curHeight * (last - first));
			while(height[first] <= curHeight && first < last) first++;
			while(height[last]  <= curHeight && first < last) last--;		
		}
		
		return water;
    }
	
	public static void main(String[] args)
	{
		int[] height = {1, 5, 2};
		
		System.out.println(new ContainMostWater().maxArea(height));
	}
}
