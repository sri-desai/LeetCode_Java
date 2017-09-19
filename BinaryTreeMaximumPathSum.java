
public class BinaryTreeMaximumPathSum
{
	int maxSum = Integer.MIN_VALUE;
	
	public int maxPathSum(TreeNode root) 
	{
		getMaxSum(root);
		
		return maxSum;
    }

	private int getMaxSum(TreeNode root) 
	{
		if(root == null) return 0;
		
		int leftSum  = Math.max(0, getMaxSum(root.left));
		int rightSum = Math.max(0, getMaxSum(root.right));
		
		maxSum = Math.max(maxSum,root.val + leftSum + rightSum);
		
		return Math.max(leftSum, rightSum) + root.val;		
	}
}
