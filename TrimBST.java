
public class TrimBST 
{
	public TreeNode trimBST(TreeNode root, int L, int R) 
	{	
		if(root == null) return root;
		
		TreeNode left  = trimBST(root.left,  L, R);
		TreeNode right = trimBST(root.right, L, R);
		
		if(root.val < L)
		{			
			return right;
		}
		if(root.val > R)
		{
			return left;
		}
		
		root.left  = left;
		root.right = right;
		
		return root;
    }
}
