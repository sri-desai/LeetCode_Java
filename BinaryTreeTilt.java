

public class BinaryTreeTilt 
{
	private int totalTilt;
	
	public int findTilt(TreeNode root)
	{
		totalTilt = 0;
		
		modifyTilt(root);
		
		return totalTilt;
    }

	private int modifyTilt(TreeNode root)
	{
		if(root == null) return 0;
		
		int leftSum = modifyTilt(root.left);
		int rightSum = modifyTilt(root.right);
		
		totalTilt += Math.abs(leftSum - rightSum);
		
		return leftSum + rightSum + root.val;		
	}
	
	public static void main(String[] args)
	{
		TreeNode root = new TreeNode(1);
		root.left     = new TreeNode(2);
		root.right    = new TreeNode(3);
		
		System.out.println(new BinaryTreeTilt().findTilt(root));
	}

}
