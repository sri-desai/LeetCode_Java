import java.util.HashMap;
import java.util.Set;

public class RemoveDuplicate 
{
	public int removeDuplicates(int[] nums) 
	{
		if(nums == null)
		{
			return 0;
		}
		
		HashMap<Integer, Long> hmap = new HashMap<>();
		long count = 0;
		
		for(int i = 0; i < nums.length; ++i)
		{
			if(hmap.containsKey(nums[i]))
			{
				hmap.put(nums[i], hmap.get(nums[i]) + 1);
			}
			else
			{
				hmap.put(nums[i], (long) 1);
			}
		}
		
		Set<Integer> set = hmap.keySet();
		
		for(int num : set)
		{
			if(hmap.get(num) > 2)
			{
				count += 2;
			}
			else
			{
				count += hmap.get(num);
			}
		}
		
		return (int) count;
    }
	
	public static void main(String[] args)
	{
		int[] arr = {1, 1, 1, 2};
		System.out.println(new RemoveDuplicate().removeDuplicates(arr));
	}
}
