public class ConvertBSTtoGreaterTree
{
	int increase = 0;
	
	public TreeNode convertBST(TreeNode root) 
	{		
		convertToGreaterTree(root);
		
		return root;
    }

	private void convertToGreaterTree(TreeNode root) 
	{
		if(root == null) return;
		
		convertToGreaterTree(root.right);
		
		root.val += increase;
		
		increase = root.val;
		
		convertToGreaterTree(root.left);		
	}
}
