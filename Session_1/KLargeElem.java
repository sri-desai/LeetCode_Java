import java.util.Collections;
import java.util.PriorityQueue;

public class KLargeElem 
{
	public int findKthLargest(int[] nums, int k) 
	{
		PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());
		
		if(nums == null)
			return -1;
		
		int finalElem = 0;
		
		for(int i = 0; i < nums.length; ++i)
		{
			pQueue.add(nums[i]);
		}
		
		for(int i = 0; i < k; ++i)
		{
			finalElem = pQueue.poll();
		}
		
		return finalElem;
    }
}
