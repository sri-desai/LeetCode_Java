
public class ContinuousSubarraySum
{
	public boolean checkSubarraySum(int[] nums, int k) 
	{
		if(nums == null || nums.length < 2) return false;
		
		int[] sumArray = nums.clone();
		
		for(int i = 1; i < nums.length; ++i)
		{
			for(int j = i; j < nums.length; ++j)
				sumArray[j] += nums[j - i];
			
			if(isPresent(sumArray, k)) return true;
		}		
		
		return false;
    }

	private boolean isPresent(int[] sumArray, int k) 
	{
		for(int i = 1; i < sumArray.length; ++i)
		{
			if(k == 0 && sumArray[i] > 0)  continue;
			if(k == 0 && sumArray[i] == 0) return true;
			if(sumArray[i] % k == 0)       return true;
			
		}		
		return false;
	}
	
	public static void main(String[] args)
	{
		int[] array = {0, 0};
		
		System.out.println(new ContinuousSubarraySum().checkSubarraySum(array, 0));
	}
}
