import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum 
{
	public int[] maxSlidingWindow(int[] nums, int k) 
	{
		if(nums == null || nums.length == 0 || k <= 0 || k > nums.length) return new int[] {};
		if(k == 0) return nums;
		
		int resArrIdx     = 0;
		int resultArray[] = new int[nums.length - k + 1];
		Deque<Integer> deQueue = new LinkedList<>();
		
		for(int startPos = 0; startPos < nums.length; ++startPos)
		{
			while(!deQueue.isEmpty() && deQueue.getFirst() <= startPos - k)
			{
				deQueue.remove();
			}
			
			while(!deQueue.isEmpty() && nums[deQueue.getLast()] < nums[startPos])
			{
				deQueue.removeLast();
			}
			
			deQueue.addLast(startPos);

			if(startPos >= k - 1)
			{
				resultArray[resArrIdx++] = nums[deQueue.getFirst()];
			}
		}
						
		return resultArray;
    }
	
	public static void main(String[] args)
	{
		int[] array = {5, 4, 3};
		
		System.out.println(new SlidingWindowMaximum().maxSlidingWindow(array, 3));
	}
}
