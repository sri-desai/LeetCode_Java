import java.util.Stack;

public class CheckPattern 
{
	public boolean find132pattern(int[] nums) 
	{
		if(nums == null || nums.length <= 2)
		{
			return false;
		}
		
		boolean isPatternFound = false;
		Stack<Integer> stack = new Stack<>();
		
		long kValue = Integer.MIN_VALUE;
		
		for(int i = nums.length - 1; i >= 0 && !isPatternFound; --i)
		{
			if(nums[i] < kValue)
			{
				isPatternFound = true;
			}
			else
			{
				while(!stack.empty() && nums[i] > stack.peek())
				{
					kValue = stack.pop();
				}
			}
			
			stack.push(nums[i]);
		}
		
		return isPatternFound;
    }
	
	public static void main(String[] args)
	{
		CheckPattern pattern = new CheckPattern();
		int[] array = {1, 2, 3, 4};
		
		System.out.println(pattern.find132pattern(array));
		
	}
}
