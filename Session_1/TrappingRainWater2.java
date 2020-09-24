
public class TrappingRainWater2
{
	/* Need to correct it */
	public int trapRainWater(int[][] heightMap) 
	{		
		if(heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) return 0;
		
		int maxWaterCount    = 0;
		int[][] maxHeightMap = new int[heightMap.length][heightMap[0].length];		
		
		/* Find the max height from left */
		for(int row = 0; row < heightMap.length; ++row)
		{
			int maxHeight = Integer.MIN_VALUE;
			
			for(int col = 0; col < heightMap[0].length; ++col)
			{
				maxHeight = Math.max(maxHeight, heightMap[row][col]);
				
				maxHeightMap[row][col] = maxHeight;
			}
		}
		
		/* Find the max height from right and store the min value*/
		for(int row = 0; row < heightMap.length; ++row)
		{
			int maxHeight = Integer.MIN_VALUE;
			
			for(int col = heightMap[0].length - 1; col >= 0 ; --col)
			{
				maxHeight = Math.max(maxHeight, heightMap[row][col]);
				
				maxHeightMap[row][col] = Math.min(maxHeight, maxHeightMap[row][col]);
			}
		}
		
		
		/* Find the max height from top and store the min value*/
		for(int col = 0; col < heightMap[0].length; ++col)
		{
			int maxHeight = Integer.MIN_VALUE;
			
			for(int row = 0; row < heightMap.length; ++row)
			{
				maxHeight = Math.max(maxHeight, heightMap[row][col]);
				
				maxHeightMap[row][col] = Math.min(maxHeight, maxHeightMap[row][col]);
			}
		}
		
		/* Find the max height from bottom and store the min value*/
		for(int col = heightMap[0].length - 1; col >= 0 ; --col)
		{
			int maxHeight = Integer.MIN_VALUE;
			
			for(int row = heightMap.length - 1; row >= 0; --row)
			{
				maxHeight = Math.max(maxHeight, heightMap[row][col]);
				
				maxHeightMap[row][col] = Math.min(maxHeight, maxHeightMap[row][col]);
			}
		}
		
		/* Find the max water by subtracting current height and maxheight at the cell */
		for(int row = 0; row < heightMap.length; ++row)
		{
			for(int col = 0; col < heightMap[0].length; ++col)
			{
				maxWaterCount += maxHeightMap[row][col] - heightMap[row][col];
			}
		}
		
		return maxWaterCount;
    }
	
	
	public static void main(String[] args)
	{
		int[][] matrix = {{1, 4}, {3, 2}};
		
		System.out.println(new TrappingRainWater2().trapRainWater(matrix));
	}
}
