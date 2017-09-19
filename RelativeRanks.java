import java.util.Arrays;
import java.util.TreeMap;

public class RelativeRanks 
{
	public String[] findRelativeRanks(int[] nums) 
	{
		if(nums == null || nums.length == 0) return new String[0];
		String[] retString = new String[nums.length];
		
		TreeMap<Integer, Integer> treeMap = new TreeMap<>();
		
		for(int i = 0; i < nums.length; ++i)
		{
			treeMap.put(nums[i], i);
		}
		
		int rank = 0;
		
		while(!treeMap.isEmpty())
		{
			++rank;
			
			int index = treeMap.remove(treeMap.lastKey());
			
			if(rank == 1) retString[index] = "Gold Medal";
			else
			if(rank == 2) retString[index] = "Silver Medal";
			else
			if(rank == 3) retString[index] = "Bronze Medal";
			else		  retString[index] = Integer.toString(rank);
		}
		
		return retString;
    }
	
	public static void main(String[] args)
	{
		int[] array = {10,3,8,9,4};
		
		System.out.println(Arrays.deepToString(new RelativeRanks().findRelativeRanks(array)));
	}
}
