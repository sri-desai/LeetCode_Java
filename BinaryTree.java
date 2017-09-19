
public class BinaryTree
{
	public TreeNode buildTree(int[] preorder, int[] inorder) 
	{
		TreeNode root = getTree(0, 0, inorder.length - 1, preorder, inorder);
		
		return root;
    }

	private TreeNode getTree(int preOrderStart, int inOrderStart, int inOrderEnd, int[] preorder, int[] inorder) 
	{
		
		if(preOrderStart >= preorder.length || inOrderStart > inOrderEnd)
		{
			return null;
		}
		
		TreeNode root = new TreeNode(preorder[preOrderStart]);
		
		int inIndex = 0; // Index of current root in inorder
	    for (int i = inOrderStart; i <= inOrderEnd; i++) {
	        if (inorder[i] == root.val) {
	            inIndex = i;
	        }
	    }
	    
	    root.left  = getTree(preOrderStart + 1, inOrderStart, inIndex - 1, preorder, inorder);
	    root.right = getTree(preOrderStart + inIndex - inOrderStart + 1, inIndex + 1, inOrderEnd, preorder, inorder);
		
		return root;
	}
}
