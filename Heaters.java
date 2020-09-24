import java.util.TreeMap;

public class Heaters
{
	public int findRadius(int[] houses, int[] heaters) 
	{
		if(houses == null || houses.length == 0) return 0;
		if(heaters == null || heaters.length == 0) return 0;
		
		int minRadius = Integer.MIN_VALUE;
		TreeMap<Integer, Integer> heatersMap = new TreeMap<>();
		
		for(int i : heaters)
		{
			heatersMap.put(i, i);
		}
		
		/* Need to convert for long */
		for(int i : houses)
		{
			Integer ceilKey  = heatersMap.ceilingKey(i);
			Integer floorKey = heatersMap.floorKey(i);
		
			
		    int minDiff = ceilKey != null && floorKey != null ? Math.min (Math.abs(i - ceilKey),  Math.abs(i - floorKey)) :
		    			  ceilKey != null ? Math.abs(i - ceilKey) : Math.abs(i - floorKey);
		    
		    minRadius = Math.max(minRadius, minDiff);
        		   
			/*
			minRadius = Math.max (minRadius, 
					              Math.min (Math.abs(i - (ceilKey  == null ? Integer.MIN_VALUE : ceilKey)), 
					            		  	Math.abs(i - (floorKey == null ? Integer.MIN_VALUE : floorKey))					            		   
					            		   )
					             ); 
			*/
		}
		

		
		return minRadius;		
    }
	
	
	public static void main(String[] args)
	{
		int[] houses  = {1,2,3,4};
		int[] heaters = {1,4};
		
		System.out.println(new Heaters().findRadius(houses, heaters));
	}
}
