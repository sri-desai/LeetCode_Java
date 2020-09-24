
public class RangeSumQuery 
{
	int[] int_array;
	
	public void NumArray(int[] nums) 
	{
		int_array = new int[nums.length];
		
		long sum = 0;
		
		for(int i = 0; i < nums.length; ++i)
		{
			int_array[i] = (int) (sum + nums[i]);
			
			sum += nums[i];
		}
    }
	
	public int sumRange(int i, int j) 
	{
		if(i == 0) return int_array[j];
		else	   return int_array[j] - int_array[i - 1];
    }
}
