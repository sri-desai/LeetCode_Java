
public class MaximumBinaryTree
{
	public TreeNode constructMaximumBinaryTree(int[] nums) 
	{
		return maxBinaryTree(0, nums.length - 1, nums);
    }

	private TreeNode maxBinaryTree(int lowIdx, int highIdx, int[] nums) 
	{
		if(lowIdx > highIdx) return null;
		
		int maxIdx = lowIdx;
		
		for(int i = lowIdx + 1; i <= highIdx; ++i)
		{
			if(nums[maxIdx] < nums[i]) maxIdx = i;
		}
		
		TreeNode root = new TreeNode(nums[maxIdx]);
		
		root.left  = maxBinaryTree(lowIdx, maxIdx - 1, nums);
		root.right = maxBinaryTree(maxIdx + 1, highIdx, nums);
		
		return root;
	}
	
	public static void main(String[] args)
	{
		
	}
}
