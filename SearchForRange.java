
public class SearchForRange 
{
	public int[] searchRange(int[] nums, int target) 
	{
		return getOptRange(nums, target, 0, nums.length - 1);
    }

	private int[] getOptRange(int[] nums, int target, int startIdx, int endIdx) 
	{
		int[] retValue = {-1, -1};	
		
		if(startIdx <= endIdx)
		{
			int mid = startIdx + ((endIdx - startIdx) / 2);
			
			if(nums[mid] == target)
			{
				retValue[0] = mid;
				retValue[1] = mid;
				
				int[] leftSol  = getOptRange(nums, target, startIdx, mid - 1);
				int[] rightSol = getOptRange(nums, target, mid + 1,  endIdx);
				
				retValue[0] = leftSol[0]  != -1 ? Math.min(leftSol[0],  retValue[0]) : retValue[0];
				retValue[1] = rightSol[1] != -1 ? Math.max(rightSol[1], retValue[1]) : retValue[1];
			}
			else
			if(nums[mid] < target)
			{
				retValue = getOptRange(nums, target, mid + 1,  endIdx);
			}
			else
			{
				retValue = getOptRange(nums, target, startIdx, mid - 1);
			}
		}
		
		return retValue;
	}
	
	public static void main(String[] args)
	{
		int[] retValue = new SearchForRange().
		           searchRange(new int[] {5, 7, 7, 8, 8, 10}, 9);
		
		System.out.println(retValue);
	}
}
