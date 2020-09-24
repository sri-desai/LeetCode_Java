
public class DeepestNode 
{
	private int maxLevel;
	public int deepestNode;
	
	public void deepestNode (TreeNode root, int curlevel)
	{
		if(root == null)
			return;
		
		if(curlevel >= maxLevel)
		{
			maxLevel    = curlevel;
			deepestNode = root.val;
		}
				
		deepestNode(root.left, curlevel + 1);
		deepestNode(root.right, curlevel + 1);
	}
	
	public static void main(String[] args)
	{
		TreeNode root = new TreeNode(10);
		root.left     = new TreeNode(20);
		root.right    = new TreeNode(30);
		root.left.left = new TreeNode(40);
		
		DeepestNode obj = new DeepestNode();
		
		obj.deepestNode(root, 0);
		
		System.out.println(obj.deepestNode);		
	}
}
