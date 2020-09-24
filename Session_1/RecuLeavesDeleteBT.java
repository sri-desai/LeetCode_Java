import java.util.ArrayList;
import java.util.List;

public class RecuLeavesDeleteBT 
{
	public List<List<Integer>> findLeaves(TreeNode root) 
	{
		List<List<Integer>> retList = new ArrayList<>();
		
		populateList(root, retList);
		
		return retList;
    }

	private int populateList(TreeNode root, List<List<Integer>> retList) 
	{
		if(root == null) return 0;
		
		int leftMaxLevel  = populateList(root.left, retList);
		int rightMaxLevel = populateList(root.right, retList);
		
		int curLevel = Math.max(leftMaxLevel, rightMaxLevel);
		
		if(retList.size() == curLevel)
		{
			retList.add(new ArrayList<>());
		}
		
		retList.get(curLevel).add(root.val);
		
		return curLevel + 1;
	}
	
	public static void main(String[] args)
	{
		TreeNode root = new TreeNode(1);
		root.left     = new TreeNode(2);
		root.right    = new TreeNode(3);
		
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		
		System.out.println(new RecuLeavesDeleteBT().findLeaves(root));
	}
}
