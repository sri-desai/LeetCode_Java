
public class RemoveDuplicates 
{
	public int removeDuplicates(int[] nums) 
	{
		if(nums == null || nums.length == 0) return 0;
		
		int insertIdx = 0;
		
		for(int num : nums)
		{
			if(insertIdx < 2 || nums[insertIdx - 2] < num)
			{
				nums[insertIdx++] = num;
			}
		}
		
		return insertIdx;
    }
	
	public static void main(String[] args)
	{
		int[] array = {1};
		
		System.out.println(new RemoveDuplicates().removeDuplicates(array));
	}
}
