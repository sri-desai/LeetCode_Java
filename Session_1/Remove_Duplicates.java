
public class Remove_Duplicates 
{
	@Deprecated
	public int removeDuplicates(int[] nums) 
	{
		if(nums.length < 2) return 1;
		
		int lastNonDuplicateIdx = 1;
		
		for(int i = 1; i < nums.length; ++i)
		{
			if(nums[i - 1] != nums[i]) nums[lastNonDuplicateIdx++] = nums[i];
		}
		
		return lastNonDuplicateIdx;
    }
	
	public int other_removeDuplicates(int[] nums) 
	{
		int insertIdx = 0;
		
		for(int n : nums)
		{
			if(insertIdx == 0 || nums[insertIdx - 1] < n)
			{
				nums[insertIdx++] = n;
			}
		}
		
		return insertIdx;
    }
	
	
}
