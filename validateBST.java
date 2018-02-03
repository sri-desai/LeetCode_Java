
public class validateBST 
{
	public boolean isValidBST(TreeNode root) 
    {
        if(root == null)
        {
        	return true;
        }
        
        return isBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
	
	private boolean isBST(TreeNode root, long minVal, long MaxVal)
	{
		if(root == null)
		{
			return true;
		}
		
		if(root.val > minVal && root.val < MaxVal)
		{
			return isBST(root.left, minVal, root.val) && 
				   isBST(root.right, root.val, MaxVal);
		}
		else
		{
		    return false;
		}
	}
	
	public static void main(String[] args)
	{
		validateBST isBst = new validateBST();
		
		TreeNode head = new TreeNode(2147483647);
		
		System.out.println(isBst.isValidBST(head));
		
	}
}
