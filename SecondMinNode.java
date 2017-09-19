
public class SecondMinNode 
{
	public int findSecondMinimumValue(TreeNode root) 
	{			
		return getMoreValThanRoot(root, root);
    }

	private int getMoreValThanRoot(TreeNode root, TreeNode mainNode) 
	{		
		if(root == null) return -1;
		
		if(root.val > mainNode.val) return root.val;
		
		int left  = getMoreValThanRoot(root.left, mainNode);
		int right = getMoreValThanRoot(root.right, mainNode);
		
		return left > 0 && right > 0 ? Math.min(left, right) : Math.max(left, right);		
	}
}
