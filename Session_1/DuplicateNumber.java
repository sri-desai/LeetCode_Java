
public class DuplicateNumber 	
{
	public int findDuplicate(int[] nums) 
    {       
		for(int i = 0; i < nums.length; ++i)
		{
			/* case to handle when the index contains correct number */
			if(nums[i] - 1 == i) continue;
			
			while(nums[nums[i] - 1] != nums[i])
			{
				int prevIdx = nums[i] - 1;
				
				int temp = nums[prevIdx];
				nums[prevIdx] = nums[i];
				nums[i] = temp;				
			}
			
			/* case to handle when the index contains correct number */
			if(nums[i] - 1 == i) continue;
			
			/* if duplicate number is present */
			if(nums[nums[i] - 1] == nums[i]) return nums[i];
		}
	
		return -1;
    }
	
	public static void main(String[] args)
	{
		int[] nums = {3, 1, 2, 2};
		
		System.out.println(new DuplicateNumber().findDuplicate(nums));
	}
}
