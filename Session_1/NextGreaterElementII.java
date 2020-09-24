import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII 
{
	public int[] nextGreaterElements(int[] nums) 
	{
		int[] newNum = new int[nums.length * 2];
		
		for(int i = 0; i < nums.length * 2; ++i)
		{
			newNum[i] = nums[i % nums.length];
		}
		
		Stack<Integer> numsNeedToFindMax = new Stack<>();
		
		for(int i = 0; i < nums.length * 2; ++i)
		{
			while(!numsNeedToFindMax.isEmpty() && newNum[numsNeedToFindMax.peek()] < newNum[i])
			{
				newNum[numsNeedToFindMax.pop()] = newNum[i];
			}
			
			numsNeedToFindMax.push(i);
		}
		
		while(!numsNeedToFindMax.isEmpty())
		{
			newNum[numsNeedToFindMax.pop()] = -1;
		}
		
		for(int i = 0; i < nums.length; ++i)
		{
			 nums[i] = newNum[i];
		}
		
		return nums;
    }

	public static void main(String[] args)
	{
		int[] array = {1,2,1};
		
		System.out.println(Arrays.toString(new NextGreaterElementII().nextGreaterElements(array)));
	}
}
