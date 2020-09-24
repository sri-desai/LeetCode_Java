
public class FindPeakElement 
{
	public int findPeakElement(int[] nums)
	{
		return getPeakElement(nums, 0, nums.length - 1);
	}
	
	private int getPeakElement(int[] nums, int start, int end) 
	{
		if(start == end) return end;
		if(start + 1 == end)
		{
			if(nums[start] > nums[end]) return start;
			else						return end;
		}
		
		int mid = (start + end) / 2;
		
		if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) return mid;
		if(nums[mid] > nums[mid - 1] && nums[mid] < nums[mid + 1]) return getPeakElement(nums, mid + 1,   end);
		if(nums[mid] < nums[mid - 1] && nums[mid] > nums[mid + 1]) return getPeakElement(nums, start, mid - 1);
		else													   return getPeakElement(nums, start, mid - 1); 
	}

	public int findPeakElementN(int[] nums) 
	{
		if(nums == null || nums.length == 0) return -1;
		if(nums.length == 1)                 return 0;
		
		for(int i = 0; i < nums.length; ++i)
		{
			if(i == 0)
			{
				if(nums[i] > nums[i + 1]) return 0;
			}
			else if(i == nums.length - 1)
			{
				if(nums[i] > nums[i - 1]) return i;
			}
			else if(nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) return i;			
		}
		
		return -1;
    }
}
