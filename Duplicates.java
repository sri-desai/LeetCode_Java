import java.util.TreeSet;

public class Duplicates 
{
	public boolean notEfficientContainsNearbyAlmostDuplicate(int[] nums, int k, int t) 
	{
		boolean isElementFound = false;
						
		for(int i = 0; i < nums.length & !isElementFound; ++i)
		{
			for(int j = i + 1; j <= (i + k) && j < nums.length && !isElementFound; ++j)
			{
				long firstNum = nums[i];
				long secNum   = nums[j];
				long diff = firstNum - secNum;
				
				if(Math.abs(diff) <= t)
				{
					isElementFound = true;
				}
			}
		}
		
		return isElementFound;        
    }
	
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) 
	{
		boolean isElementFound = false;
		
		if(nums == null || nums.length == 0 || k == 0)
		{
			return false;
		}
		
		TreeSet<Long> treeSet = new TreeSet<>();		
		
		for(int i = 0; i < nums.length & !isElementFound; ++i)
		{
			long curItem  = nums[i];
			Long nextElem = treeSet.floor(curItem + t);
			Long prevElem = treeSet.ceiling(curItem - t);
			
			if( (nextElem == null && Math.abs(nextElem - curItem) <= t) ||
			    (prevElem == null && Math.abs(prevElem - curItem) <= t)
			  )
			{
				isElementFound = true;
			}
			
			if(i > k)
			{
				treeSet.remove(nums[i - k]);
			}
			
			treeSet.add((long) nums[i]);
		}
		
		return isElementFound;        
    }
	
	public static void main(String[] args)
	{
		Duplicates dup = new Duplicates();
		int[] array = {1,2};
		
		System.out.println(dup.containsNearbyAlmostDuplicate(array, 1, 2147483647));
		
	}
		
}
