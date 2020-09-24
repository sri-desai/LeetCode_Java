import java.util.stream.IntStream;

public class SumOfLeftLeaves 
{
	public int minMoves(int[] nums)
	{
		return IntStream.of(nums).sum() - nums.length * IntStream.of(nums).min().getAsInt();
	}
		
	public int sumOfLeftLeaves(TreeNode root) 
	{
		if(root == null) return 0;
		
		return getLeafSum(root.left, true) + getLeafSum(root.right, false);
    }

	private int getLeafSum(TreeNode root, boolean leftChildToParent)
	{
		if(root == null) return 0;
		if(root.left == null && root.right == null && leftChildToParent) return root.val;
		
		return getLeafSum(root.left, true) + getLeafSum(root.right, false);
	}
		
}
