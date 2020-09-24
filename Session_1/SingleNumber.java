import java.util.HashMap;
import java.util.Iterator;

public class SingleNumber 
{
	public int singleNumber(int[] nums) 
	{
		HashMap<Integer, Integer> hmap = new HashMap<>();
		
		for(int i = 0; i < nums.length; ++i)
		{
			if(hmap.containsKey(nums[i]))
			{
				hmap.put(nums[i], hmap.get(nums[i]) + 1);
			}
			else
			{
				hmap.put(nums[i], 1);
			}
		}
		
		Iterator<Integer> keysetIterator = hmap.keySet().iterator();
		
		while(keysetIterator.hasNext())
		{
			int value = keysetIterator.next();
			
			if(hmap.get(value) == 1)
			{
				return value;
			}
		}
		
		/* this case will not occur */
		return -1;
    }
	
	public static void main(String[] args)
	{
		int[] array = {1, 1, 1, 2};
		
		System.out.println(new SingleNumber().singleNumber(array));
	}
}
