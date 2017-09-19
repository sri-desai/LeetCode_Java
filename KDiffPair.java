import java.util.HashMap;

public class KDiffPair
{
	public int findPairs(int[] nums, int k) 
	{
		if(nums == null || nums.length == 0 || k < 0) return 0;
		int count = 0;
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int i : nums)
		{
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		
		for(int key : map.keySet())
		{
			if(k == 0)
			{
				if(map.get(key) >= 2) ++count;
			}
			else
			{
				if(map.get(key) > 0 && map.containsKey(key + k))
				{
					++count;
					
					map.put(key, map.get(key) - 1);
				}
			}			
		}
		
		return count;
    }
	
	public static void main(String[] args)
	{
		int[] array = {1, 3, 1, 5, 4};
		
		System.out.println(new KDiffPair().findPairs(array, 0));
	}
}
