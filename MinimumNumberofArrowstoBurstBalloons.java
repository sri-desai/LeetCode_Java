public class MinimumNumberofArrowstoBurstBalloons 
{	
	public int findMinArrowShots(int[][] points) 
	{
		if(points == null || points.length == 0)
		{
			return 0;
		}
		
		java.util.Arrays.sort(points, new java.util.Comparator<int[]>() 
		   {
		    	public int compare(int[] a, int[] b) 
		    	{
		    		if(a[0]==b[0]) return a[1]-b[1];
					else return a[0]-b[0];
		    	}
		   });
		
		
		int minCount = 1;
		int endLimit = points[0][1];
		
		for(int i = 1; i < points.length; ++i)
		{
			int baloon[] = points[i];
			
			if(baloon[0] <= endLimit)
			{
				endLimit = Math.min(endLimit, baloon[1]);
			}
			else
			{
				++minCount;
				
				endLimit = baloon[1];
			}
		}
		
		return minCount;
    }

	
}
