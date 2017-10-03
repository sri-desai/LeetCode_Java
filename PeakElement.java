
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

	private boolean isElemGreater(int thisIdx, int nextOrPrevIdx, int[] nums)
	{
		return nextOrPrevIdx < 0 || nextOrPrevIdx >= nums.length ? true :
			   nums[thisIdx] > nums[nextOrPrevIdx];
	}
	
	private int findPeak(int[] nums, int low, int high) 
	{
		if(low > high)
			return -1;
		
		int mid = low + ((high - low) / 2);
		
		if(isElemGreater(mid, mid + 1, nums) && isElemGreater(mid, mid - 1, nums))
		{
			return mid;
		}
		else 
		if(isElemGreater(mid, mid - 1, nums))
		{
			return findPeak(nums, mid + 1, high);
		}
		else
		{
			return findPeak(nums, low, mid - 1);
		}	
	}
	
	public static void main(String[] args)
	{
		System.out.println(new PeakElement().findPeakElement(new int[] {1,2,3,1}));
	}
}
