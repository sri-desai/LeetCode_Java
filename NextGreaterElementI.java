import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElementI 
{
	public int[] nextGreaterElement(int[] findNums, int[] nums) 
	{
		HashMap<Integer, Integer> map = new HashMap<>();
		Stack<Integer> stack = new Stack<>();		
		
		for(int num : nums)
		{
			while(!stack.isEmpty() && stack.peek() < num)
			{
				map.put(stack.pop(), num);
			}
			
			stack.push(num);
		}
		
		
		int[] array = new int[findNums.length];
		
		int i = 0;
		
		for(int num : findNums)
		{
			array[i++] = map.getOrDefault(num, -1);
		}		
		
		return array;
    }
	
	public static void main(String[] args)
	{
		int[] nums1 = {2,4};
		int[] nums2 = {1,2,3,4};
		
		System.out.println(Arrays.toString(new NextGreaterElementI().nextGreaterElement(nums1, nums2)));
	}
}
