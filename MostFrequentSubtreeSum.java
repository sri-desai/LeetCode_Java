import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class MostFrequentSubtreeSum 
{	
	public int[] findFrequentTreeSum(TreeNode root) 
	{
		List<Integer> retList = new ArrayList<>();
		HashMap<Integer, Integer> hmap = new HashMap<>();
		List<Entry<Integer, Integer>> list;
		int maxCount = 0;
		
		populateMap(root, hmap);
		
		list = SortHashMapByValues.sortByReverseValues(hmap);
		
		maxCount = list.get(0).getValue();
		
		for(int i = 0; i < list.size(); ++i)
		{
			if(list.get(i).getValue() < maxCount)
			{
				break;
			}
			else
			{
				retList.add(list.get(i).getKey());
			}
		}
		
		int[] array = new int[retList.size()];
		
		for(int i = 0; i < retList.size(); ++i)
		{
			array[i] = retList.get(i);
		}
		
		return array;
    }

	private int populateMap(TreeNode root, HashMap<Integer, Integer> hmap) 
	{
		if(root == null)
		{
			return 0;
		}
		
		int sum = root.val + populateMap(root.left, hmap) + populateMap(root.right, hmap);
		
		hmap.put(sum, hmap.getOrDefault(sum, 0) + 1);
		
		return sum;
	}
	
	public static void main(String[] args)
	{
		TreeNode root = new TreeNode(5);
		root.left     = new TreeNode(2);
		root.right    = new TreeNode(-5);
		
		System.out.println(Arrays.toString(new MostFrequentSubtreeSum().findFrequentTreeSum(root)));
	}
}
