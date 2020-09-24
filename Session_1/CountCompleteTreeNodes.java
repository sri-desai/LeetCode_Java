



public class CountCompleteTreeNodes
{
	/* Need to correct */
	public int countNodes(TreeNode root) 
	{
		if(root == null) return 0;
		
		int lHeight = get_height(root.left);
		int rHeight = get_height(root.right);
		
		return lHeight == rHeight ? lHeight == 0 ? 1 : (2 << (1 + lHeight)) - 1 : 1 + countNodes(root.left) + countNodes(root.right);		
    }
	
	private int get_height(TreeNode root)
	{
		return root == null ? 0 : 1 + get_height(root.left);
	}
	
	public static void main(String[] args)
	{
		TreeNode root = new TreeNode(1);
		
		System.out.println(new CountCompleteTreeNodes().countNodes(root));
	}
}
