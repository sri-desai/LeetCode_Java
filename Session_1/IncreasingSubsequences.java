import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class IncreasingSubsequences 
{
	public List<List<Integer>> findSubsequences(int[] nums) 
	{
		List<List<Integer>> retList = new ArrayList<>();
		HashSet<List<Integer>> mainList = new HashSet<>();
		
		List<Integer> subList = new ArrayList<>();
		
		if(nums == null || nums.length <= 1)
			return null;
						
		for(int length = 2; length <= nums.length; ++length)
		{
			populateList(nums, length, 0, mainList, subList);
		}
		
		Iterator<List<Integer>> iterator = mainList.iterator();
		
		while(iterator.hasNext())
		{
			retList.add(iterator.next());
		}
		
		return retList;
    }

	private void populateList(int[] nums, int length, int startPos, HashSet<List<Integer>> mainList, 
			                  List<Integer> subList) 
	{
		if(length == 0)
		{
			if(!mainList.contains(subList))
			{
				mainList.add(new ArrayList<>(subList));
			}					
			
			return;
		}
		
		for(int i = startPos; i < nums.length; ++i)
		{
			if(subList.size() == 0 || subList.get(subList.size() - 1) <= nums[i])
			{
				subList.add(nums[i]);
				
				populateList(nums, length - 1, i + 1, mainList, subList);
				
				subList.remove(subList.size() - 1);
			}
		}
		
	}
	

	public static void main(String[] args)
	{
		int[] array = {4, 6, 7, 7};
		
		System.out.println(new IncreasingSubsequences().findSubsequences(array));
	}
}
