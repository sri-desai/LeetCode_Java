
public class BT_To_Dll 
{
	private TreeNode dllHead;
	
	public TreeNode btToDll (TreeNode rootNode)
	{
		dllHead = null;
		
		if(rootNode == null) return dllHead;
		
		convertBtToDll(rootNode, true);
		
		return dllHead;
	}

	private TreeNode convertBtToDll(TreeNode rootNode, boolean returnLeft) 
	{		
		if(rootNode.left == null && rootNode.right == null)
		{
			if(dllHead == null) dllHead = rootNode;
			
			return rootNode;
		}
		else
		{
			TreeNode leftNode = rootNode.left == null ? null   : convertBtToDll(rootNode.left,  false);
			TreeNode rightNode = rootNode.right == null ? null : convertBtToDll(rootNode.right, true);
			
			if(leftNode != null) 
			{
				leftNode.right = rootNode;
				rootNode.left = leftNode;
			}
			if(rightNode != null)
			{
				rightNode.left = rootNode;
				rootNode.right = rightNode;
			}
			
			if(returnLeft)
			{
				return leftNode == null ? rootNode : leftNode;
			}
			else
			{
				return rightNode == null ? rootNode : rightNode;
			}
		}
	}
	
	public static void printDllTree (TreeNode head)
	{
		while(head != null)
		{
			System.out.println(head.val);
			
			head = head.right;
		}
	}
	
	public static void main(String[] args)
	{
		/*TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(6);
		
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(4);
		root.left.left.left = new TreeNode(0);
		root.left.left.right = new TreeNode(2);
		
		root.right.right = new TreeNode(8);
		root.right.right.left = new TreeNode(7);
		root.right.right.right = new TreeNode(9);*/
		
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(12);
		root.right = new TreeNode(15);
		
		root.left.left = new TreeNode(25);
		root.left.right = new TreeNode(30);
		
		root.right.left = new TreeNode(36);
		
		printDllTree(new BT_To_Dll().btToDll(root));
	}
}
