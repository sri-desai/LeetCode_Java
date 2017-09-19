
public class BalancedBinaryTree
{
	public boolean isBalanced(TreeNode root)
    {
        return checkBinary(root) >= 0 ? true :false; 
    }
    
    private int checkBinary(TreeNode root)
    {
        if(root == null) return 0;
        
        int left = checkBinary(root.left);
        
        if(left == -1) return -1;
        
        int right = checkBinary(root.right);
        
        if(right == -1) return -1;
        
        return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right);
    }
    
    public static void main(String[] args)
    {
    	TreeNode root = new TreeNode(2);
    	root.right    = new TreeNode(3);
    	root.right.right    = new TreeNode(4);
    	root.right.right.right    = new TreeNode(6);
    	
    	System.out.println(new BalancedBinaryTree().isBalanced(root));
    	
    }
}
