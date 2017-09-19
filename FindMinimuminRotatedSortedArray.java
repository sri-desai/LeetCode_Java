
public class FindMinimuminRotatedSortedArray 
{
	
	/* Wrong solution */
	public int findMin(int[] nums) 
	{		
		return findElem(nums, 0, nums.length - 1);	
    }

	private int findElem(int[] nums, int startPos, int endPos) 
	{
		if(startPos > endPos) return -1;
		
		int mid = (startPos + endPos) / 2;
		
		if(nums[mid] > getNextElem(nums, mid))
		{
			return getNextElem(nums, mid);
		}
		else
		if(isLocalMinima(nums, mid))
		{
			return nums[mid];
		}
		else
		if(nums[startPos] > nums[mid] && nums[endPos] > nums[mid])
		{
			if(nums[startPos] > nums[endPos])
			{
				return findElem(nums, startPos, mid - 1);
			}
			else
			{
				return findElem(nums, mid + 1, endPos);
			}
		}
		else
		if(nums[startPos] < nums[mid] && nums[endPos] < nums[mid])
		{
			if(nums[startPos] < nums[endPos])
			{
				return findElem(nums, startPos, mid - 1);
			}
			else
			{
				return findElem(nums, mid + 1, endPos);
			}
		}
		else
		{
			System.out.println("confused");
			
			return -1;
		}

	}

	private boolean isLocalMinima(int[] nums, int mid) 
	{
		int prevIdx = mid == 0 ? nums.length - 1 : mid - 1;
		int nextIdx = mid == nums.length - 1 ? 0 : mid + 1;
		
		return nums[mid] < nums[prevIdx] && nums[mid] < nums[nextIdx];
	}

	private int getNextElem(int[] nums, int mid) 
	{
		return nums[(mid + 1) % nums.length];
	}
	
	
	public static void main(String[] args)
	{
		int[] array = {1, 2, 3, 4, 0};
		
		System.out.println(new FindMinimuminRotatedSortedArray().findMin(array));		
	}
}
