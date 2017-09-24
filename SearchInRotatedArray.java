
public class SearchInRotatedArray 
{
	public boolean search(int[] nums, int target) 
	{
		if(nums == null)
		{
			return false;
		}
		
		return binarySearch(nums, target, 0, nums.length - 1);
    }

	private boolean binarySearch(int[] nums, int target, int startIdx, int endIdx) 
	{
		if(startIdx > endIdx)
		{
			return false;
		}
		
		int mid = (startIdx + endIdx) / 2;
		
		if(nums[mid] == target)
		{
			return true;
		}
		
		if(nums[startIdx] <= nums[mid])
		{
			if(nums[startIdx] <= target && target < nums[mid])
			{
				return binarySearch(nums, target, startIdx, mid - 1);
			}
			else
			{
				return binarySearch(nums, target, mid + 1, endIdx);
			}
		}
		else
		{
			if(nums[endIdx] >= target && target > nums[mid])
			{
				return binarySearch(nums, target, mid + 1, endIdx);
			}
			else
			{
				return binarySearch(nums, target, startIdx, mid - 1);
			}
		}
	}
	
	public static void main(String[] args)
	{
		int[] array = {1,3,1,1,1};
		
		System.out.println(new SearchInRotatedArray().search(array, 3));
	}
}
