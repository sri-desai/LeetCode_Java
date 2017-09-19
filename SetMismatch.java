import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetMismatch 
{
	public int[] findErrorNums(int[] nums) 
	{		
		Set<Integer> set = new HashSet<>();
		
		int[] retArray = new int[2];
		
		if(nums == null) return retArray;
		
		for(int num : nums)
		{
			if(!set.add(num)) retArray[0] = num;
		}
		
		for(int i = 1; i <= nums.length; ++i)
		{
			if(!set.contains(i))
			{
				retArray[1] = i;
				
				break;
			}
		}
		
		return retArray;
    }
	
	public static void main(String[] args)
	{
		int[] nums = {1,2,2,4};
		
		System.out.println(Arrays.toString(new SetMismatch().findErrorNums(nums)));
	}
}
