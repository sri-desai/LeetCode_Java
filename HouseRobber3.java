import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HouseRobber3
{
	HashMap<TreeNode, List<Integer>> memoization;
	
	public int rob(TreeNode root) 
	{
		if(root == null)
		{
			return 0;
		}
		
		memoization = new HashMap<>();
		
		getAmount(root);
		
		return Math.max(memoization.get(root).get(0), memoization.get(root).get(1));
    }

	private void getAmount(TreeNode root) 
	{		
		int withCurrentNode    = root.val;
		int withoutCurrentNode = 0;
		List<Integer> list     = new ArrayList<>();
		
		if(root.left == null && root.right == null)
		{
			list.add(withCurrentNode);
			list.add(withoutCurrentNode);
			memoization.put(root, list);
			
			return;
		}
		
		if(root.left != null && !memoization.containsKey(root.left))
		{
			getAmount(root.left);					
		}
		
		if(root.left != null)
		{
			List<Integer> subTree = memoization.get(root.left);
			
			withCurrentNode    += subTree.get(1);
			withoutCurrentNode += Math.max(subTree.get(0), subTree.get(1));
		}
		
		if(root.right != null && !memoization.containsKey(root.right))
		{
			getAmount(root.right);					
		}
		
		if(root.right != null)
		{
			List<Integer> subTree = memoization.get(root.right);
			
			withCurrentNode    += subTree.get(1);
			withoutCurrentNode += Math.max(subTree.get(0), subTree.get(1));
		}
				
		list.add(withCurrentNode);
		list.add(withoutCurrentNode);
		
		memoization.put(root, list);
	}
	
	public static void main(String[] args)
	{
		TreeNode root = new TreeNode(3);
		root.left     = new TreeNode(4);
		root.right    = new TreeNode(5);
		
		
		root.left.left   = new TreeNode(1);
		root.left.right  = new TreeNode(3);
		root.right.right = new TreeNode(1);
		
		System.out.println(new HouseRobber3().rob(root));
	}
}
