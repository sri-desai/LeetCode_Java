
public class MinInRotatedArray 
{
	public int findMin(int[] nums) 
	{
        if(nums == null || nums.length == 0)
        	return 0;
        
        int low  = 0;
        int high = nums.length - 1;
        
        while(low < high)
        {
        	if(nums[low] < nums[high])
        		return nums[low];
        	
        	int mid = (low + high)/2;
        	
        	if(nums[mid] >= nums[low])
        	{
        		low = mid + 1;
        	}
        	else
        	{
        		high = mid;
        	}
        }
        
        return -1;
    }
	
	public static void main(String[] args)
	{
		int[] array = {1, 2, 3, 4, 5, 6, 7};
		
		System.out.println(new MinInRotatedArray().findMin(array));
	}
}
