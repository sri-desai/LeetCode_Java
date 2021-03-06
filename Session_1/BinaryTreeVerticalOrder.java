import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class BinaryTreeVerticalOrder
{
	public List<List<Integer>> verticalOrder (TreeNode root)
	{				
		HashMap<Integer, List<Integer>> map = new HashMap<>();
		
		List<List<Integer>> retList = new ArrayList<>();
		
		if(root == null) return retList;
		
		populateList(root, map, 0);		
						
		populateRetList(retList, map);
		
		return retList;
		
	}

	private void populateRetList(List<List<Integer>> retList, HashMap<Integer, List<Integer>> map) 
	{		
		int minElem = Collections.min(map.keySet());
		
		int maxElem = Collections.max(map.keySet());
		
		for(int i = minElem; i <= maxElem; ++i)
		{
			if(map.containsKey(i)) retList.add(map.get(i));
		}		
	}

	private void populateList(TreeNode root, HashMap<Integer, List<Integer>> map, int curLevel) 
	{
		if(root == null) return;
		
		if(!map.containsKey(curLevel))
		{
			map.put(curLevel, new ArrayList<>());			
		}
		
		map.get(curLevel).add(root.val);
		
		populateList(root.left, map, curLevel - 1);
		
		populateList(root.right, map, curLevel + 1);
	}


	public static void main(String[] args)
	{
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(0);
		root.right.left = new TreeNode(1);
		root.right.right = new TreeNode(7);
		root.right.left.left = new TreeNode(5);
		root.right.left.right = new TreeNode(2);
		
		System.out.println(new BinaryTreeVerticalOrder().verticalOrder(root));
	}
}
