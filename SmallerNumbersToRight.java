import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class SmallerNumbersToRight
{
	/* need to improve time complexity (timeout is happening)*/
	public List<Integer> countSmaller(int[] nums) 
	{	
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2 - o1;
			}
		});
		
		Queue<Integer> queue = new LinkedList<>();
		
		List<Integer> retList = new ArrayList<>();
		
		if(nums == null) return retList;
		
		for(int i = nums.length - 1; i >= 0; --i)
		{
			while(!maxHeap.isEmpty() && maxHeap.peek() >= nums[i])
			{
				queue.add(maxHeap.remove());
			}
			
			if(maxHeap.isEmpty())
			{
				retList.add(0, 0);					
			}
			else
			{
				retList.add(0, maxHeap.size());
			}
			
			maxHeap.add(nums[i]);
			
			while(!queue.isEmpty())
			{
				maxHeap.add(queue.remove());
			}
		}
		
		return retList;
    }
}
