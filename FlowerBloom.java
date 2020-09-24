import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class FlowerBloom 
{
	/* O(nlgn) solution */
	public int kEmptySlots(int[] flowers, int k) 
	{
		TreeSet<Integer> flowerSet = new TreeSet<>();
		
		for(int curDay = 0; curDay < flowers.length; ++curDay)
		{
			int curDayFlower = flowers[curDay];
			
			Integer nextFlower = flowerSet.higher(curDayFlower);
			
			if(nextFlower != null && nextFlower - curDayFlower == k + 1)
			{
				return curDay + 1;
			}
			
			Integer prevFlower = flowerSet.lower(curDayFlower);
			
			if(prevFlower != null && curDayFlower - prevFlower == k + 1)
			{
				return curDay + 1;
			}
			
			flowerSet.add(curDayFlower);
		}
		
		return -1;
    }

	/* O(n) solution */
	public int kEmptySlots_opt(int[] flowers, int k) 
	{
		if(flowers.length <= k) return 0;
		
		int[] flowerToBloomingDayMap = new int[flowers.length];
		
		for(int curDay = 0; curDay < flowers.length; ++curDay)
		{
			flowerToBloomingDayMap[flowers[curDay] - 1] = curDay + 1;
		}
		
		int perfectBloomingDay = Integer.MAX_VALUE;
		int leftFlowerIdx  = 0;
		int rightFlowerIdx = leftFlowerIdx + k + 1;
		
		/* for perfect blooming, blooming day of all the flowers between 
		 * left flower and right flower should be more than max of 
		 * blooming day of left and right flower */
		for(int curFlower = 0; curFlower < flowers.length; ++curFlower)
		{
			if(flowerToBloomingDayMap[curFlower] <  flowerToBloomingDayMap[leftFlowerIdx] ||
			   flowerToBloomingDayMap[curFlower] <= flowerToBloomingDayMap[rightFlowerIdx]	
			  )
			{
				if(curFlower == rightFlowerIdx)
				{
					perfectBloomingDay = Math.min(perfectBloomingDay, 
							                      Math.max(flowerToBloomingDayMap[leftFlowerIdx],
							                    		   flowerToBloomingDayMap[rightFlowerIdx]
							                    	      )
							                     );  
				}
				
				leftFlowerIdx = curFlower;
				rightFlowerIdx = leftFlowerIdx + k + 1;
			}
			
			if(rightFlowerIdx >= flowers.length) break;
		}
		
		return perfectBloomingDay == Integer.MAX_VALUE ? -1 : perfectBloomingDay;
	}
	
	
	public static void main(String[] args)
	{
		int[] flowers = {1,2,3};
		
		System.out.println(new FlowerBloom().kEmptySlots_opt(flowers, 1));
	}
}
