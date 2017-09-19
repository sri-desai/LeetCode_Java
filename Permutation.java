import java.util.Arrays;
import java.util.Comparator;

public class Permutation
{
	public String largestNumber(int[] nums) 
	{
		if(nums == null || nums.length == 0)
		{
			return null;
		}
		
		String[] array = new String[nums.length];
		
		for(int i = 0; i < nums.length; ++i)
		{
			array[i] = String.valueOf(nums[i]);
		}
		
		Arrays.sort(array, new Comparator<String>() {
				public int compare(String a, String b)
				{
					return (b + a).compareTo(a + b);
				}
		});
		
		StringBuffer sb = new StringBuffer();
		
		for(String num : array)
		{
			sb.append(num);
		}
		
		return sb.toString();
    }
	
	public static void main(String[] args)
	{
		Permutation pObj = new Permutation();
		
		int[] array = {3, 30, 34, 5, 9};
		
		System.out.println(pObj.largestNumber(array));
	}
}
