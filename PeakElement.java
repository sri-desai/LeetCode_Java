
public class PeakElement 	
{
	public int findPeakElement(int[] nums) 
	{
		if(nums == null || nums.length == 0)
		{
			return 0;
		}
		
		return findPeak(nums, 0, nums.length - 1);
    }

	private int findPeak(int[] nums, int low, int high) 
	{
		if(low > high)
			return -1;
		
		int mid = (low + high) / 2;		
		
		if(mid == 0)
		{
			return nums[mid] > nums[mid + 1] ? mid : -1;
				
		}
		else
		if(mid == nums.length - 1)
		{
			return nums[mid] > nums[mid - 1] ? mid : -1;
		}
		else
		if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])
		{
			return mid;
		}			
		else
		if(nums[mid] < nums[mid - 1])
		{
			return findPeak(nums, low, mid);
		}
		else
		{
			return findPeak(nums, mid, high);
		}	
	}
}
