import java.util.Collections;
import java.util.PriorityQueue;

public class ValidateArray 
{
	public boolean increasingTriplet(int[] nums) 
    {
        if(nums == null || nums.length < 3)    
            return false;
        
       PriorityQueue<Integer> minHeap = new PriorityQueue<>();
       PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
       
       minHeap.add(nums[0]);
       maxHeap.add(nums[nums.length - 1]);
       
       for(int i = 1, j = nums.length - 2; i < j; ++i, --j)
       {
    	   if((nums[i] > minHeap.peek() && nums[i] < maxHeap.peek()) || 
    		  (nums[j] > minHeap.peek() && nums[j] < maxHeap.peek())
             )
    	   {
    		   return true;
    	   }
    	   else
    	   {
    		   minHeap.add(nums[i]);
    		   maxHeap.add(nums[j]);
    	   }
       }
       
       return false;
    }
	
	public static void main(String[] args)
	{
		int[] array = {5,1,5,5,2,5,4};
		
		System.out.println(new ValidateArray().increasingTriplet(array));
	}
}
