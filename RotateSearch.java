
public class RotateSearch 
{
	public boolean search(int[] nums, int target) 
	{
		if(nums == null)
			return false;
		
		return binSearch(nums, target, 0, nums.length - 1);
	}

	private boolean binSearch(int[] nums, int target, int lowerBound, int higherBound) 
	{
		if(lowerBound > higherBound)
			return false;
		
		int mid = (lowerBound + higherBound) / 2;
		
		if(nums[mid] == target)
			return true;
		
		if(nums[lowerBound] <= nums[mid])
		{
			if(target < nums[mid])
				return binSearch(nums, target, lowerBound, mid - 1);
			else
				return binSearch(nums, target, mid + 1, higherBound);
		}
		else
		{
			if(target < nums[mid])
				return binSearch(nums, target, lowerBound, mid - 1);
			else
				return binSearch(nums, target, mid + 1, higherBound);
		}
		
	}
	
	public static void main(String[] args)
	{
		int[] array = {3, 1};
		System.out.println(new RotateSearch().search(array, 1));		
	}
}
