import java.util.TreeMap;

public class Duplicates3
{	
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) 
	{
        if(nums == null || nums.length == 0 || k <= 0 || t < 0) return false;
        
        TreeMap<Long, Long> elemCount = new TreeMap<>();
        
        for(int curNumIdx = 0; curNumIdx < nums.length; ++curNumIdx)
        {
        	Long nextHigherElem = elemCount.ceilingKey ((long)nums[curNumIdx] - t);
        	Long nextLowerElm   = elemCount.floorKey   ((long)nums[curNumIdx] + t);
        	
        	if((nextHigherElem != null && nums[curNumIdx] >= nextHigherElem) ||
        	   (nextLowerElm   != null && nums[curNumIdx] <= nextLowerElm)
        	  )
        	{
        		return true;
        	}
        	else
        	{
        		if(curNumIdx >= k && elemCount.get((long)nums[curNumIdx - k]) != null)
        		{
        			if(elemCount.get((long)nums[curNumIdx - k]) == 1)
        			{
        				elemCount.remove((long)nums[curNumIdx - k]);
        			}
        			else
        			{
        				elemCount.put((long) nums[curNumIdx - k], elemCount.get((long)nums[curNumIdx - k]) - 1);
        			}
        		}
        		
        		elemCount.put((long) nums[curNumIdx], elemCount.getOrDefault((long)nums[curNumIdx], (long) 0) + 1);
        	}        	
        }
        
        return false;
    }
	
	public static void main(String[] args)
	{
		int[] array = {-2147483648,-2147483647};
		
		System.out.println(new Duplicates3().containsNearbyAlmostDuplicate(array, 3, 3));
	}
}
