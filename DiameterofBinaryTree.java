
public class DiameterofBinaryTree
{
	int curMax = 0;
	
	public int diameterOfBinaryTree(TreeNode root) 
    {
		getDiameter(root);
		
		return curMax == 0 ? 0 : curMax - 1;
    }

	private int getDiameter(TreeNode root) 
	{
		if(root == null) return 0;
		
		int leftPath  = getDiameter(root.left);
		int rightPath = getDiameter(root.right);
		
		curMax = Math.max(curMax, 1 + leftPath + rightPath);
		
		return 1 + Math.max(leftPath, rightPath);		
	}
	
	 
	 public static void main(String[] args)
	 {
		 ;
	 }
}
