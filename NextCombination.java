import java.util.Arrays;

public class NextCombination
{
	public void nextPermutation(int[] nums) 
	{
		if(nums == null || nums.length == 0)
		{
			return;
		}
		
		int kVal = -1;
		int lVal = -1;
		
		for(int i = nums.length - 2; i >= 0; --i)
		{
			if(nums[i] < nums[i + 1])
			{
				kVal = i;
				
				break;
			}
		}
		
		if(kVal == -1)
		{
			Arrays.sort(nums);
			
			return;
		}
		
		for(int i = nums.length - 1; i > kVal; --i)
		{
			if(nums[kVal] < nums[i])
			{
				lVal = i;
				
				break;
			}
		}
		
		int temp = nums[kVal];
		nums[kVal] = nums[lVal];
		nums[lVal] = temp;
		
		int lastIdx = nums.length - 1;
		
		for(int i = kVal + 1; i < lastIdx; ++i)
		{
			temp       = nums[i];
			nums[i] = nums[lastIdx];
			nums[lastIdx--] = temp;
		}
		
		return;
		
    }
	
	public static void main(String[] args)
	{
		NextCombination obj = new NextCombination();
		
		int[] arr = {1, 3, 2};
		
		obj.nextPermutation(arr);
		
		System.out.println(arr);
	}
}
