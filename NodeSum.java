
public class NodeSum 
{
	public boolean findTarget(TreeNode root, int k) 
    {
       return checkTargetNumber(root, k, root);
    }

	private boolean checkTargetNumber(TreeNode curNode, int k, TreeNode root) 
	{
		if(curNode == null) return false;
		
		if(isOtherNumberPresent(root, k - curNode.val, curNode))
		{
			return true;
		}
		else
		{
			return checkTargetNumber(curNode.left, k, root) || checkTargetNumber(curNode.right, k, root);
		}		
	}

	private boolean isOtherNumberPresent(TreeNode curNode, int targetNodeVal, TreeNode excludeNode) 
	{
		if(curNode == null)	return false;
		if(curNode != excludeNode && curNode.val == targetNodeVal) return true;
		
		if(curNode.val > targetNodeVal) 
			return isOtherNumberPresent(curNode.left, targetNodeVal, excludeNode);
		else
			return isOtherNumberPresent(curNode.right, targetNodeVal, excludeNode);
	}
	
	
	public static void main(String[] args)
	{
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(6);
		
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		
		root.right.right = new TreeNode(7);
		
		System.out.println(new NodeSum().findTarget(root, 9));
	}
}
