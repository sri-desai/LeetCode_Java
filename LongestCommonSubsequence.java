
public class LongestCommonSubsequence 
{
	public int lengthOfLIS(int[] nums) 
	{
		if(nums == null || nums.length == 0)
			return 0;
		
		int[] countArray = new int[nums.length];
		int maxVal = 1;
		
		countArray[0] = 1;
		
		for(int i = 1; i < nums.length; ++i)
		{
			int count = checkMaxCount(nums, countArray, i - 1);
			countArray[i] = count == 0 ? 1 : count + 1;
			
			maxVal = maxVal < countArray[i] ? countArray[i] : maxVal;
		}
		
		return maxVal;
    }

	private int checkMaxCount(int[] nums, int[] countArray, int startPos) 
	{
		int count = 0;
		int curPos = startPos + 1;
		
		while (startPos >= 0)
		{
			if(nums[curPos] > nums[startPos] && countArray[startPos] >= count)
			{
				count = countArray[startPos];
			}
			
			--startPos;
		}
		
		return count;
	}
	
	public static void main(String[] args)
	{
		int[] array = {10,9,2,5,3,7,101,18};
		
		System.out.println(new LongestCommonSubsequence().lengthOfLIS(array));
	}
}
