

public class MinAbsDifference 
{
	int minDifference = Integer.MAX_VALUE;
	TreeNode	prev  = null;
	
	public int getMinimumDifference(TreeNode root) 
	{
		getInOrder(root);
		
		return minDifference;
    }

	private void getInOrder(TreeNode root)
	{
		if(root == null) return;
		
		getInOrder(root.left);
		
		if(prev != null) minDifference = Math.min(minDifference, Math.abs(root.val - prev.val));
		
		prev = root;
		
		getInOrder(root.right);
	}
	
	public static void main(String[] args)
	{
		TreeNode root = new TreeNode(1);
		root.right    = new TreeNode(3);
		root.right.left = new TreeNode(2);
		
		System.out.println(new MinAbsDifference().getMinimumDifference(root));
	}
}
