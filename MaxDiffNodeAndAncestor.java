import java.util.LinkedList;
import java.util.Queue;

public class MaxDiffNodeAndAncestor
{
	private int maxDifference;
	
	public int getMaxDiffNodeAndAncestor (TreeNode root)
	{
		if(root == null) return 0;
		
		maxDifference = Integer.MIN_VALUE;
		
		getMaxDifference(root.left, root);
		getMaxDifference(root.right, root);
		
		return maxDifference == Integer.MIN_VALUE ? 0 : maxDifference;
	}

	private void getMaxDifference(TreeNode root, TreeNode parentNode) 
	{
		if(root == null) return;
		
		TreeNode nextParentNode = parentNode;
		
		maxDifference = Math.max(maxDifference, parentNode.val - root.val);	
		
		nextParentNode = root.val > parentNode.val ? root : parentNode;
		
		getMaxDifference(root.left,  nextParentNode);
		getMaxDifference(root.right, nextParentNode);
	}
	
	public static void main(String[] args)
	{
		TreeNode root = new TreeNode(8);
		root.left = new TreeNode(3);
		root.right = new TreeNode(10);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(6);
		root.left.right.left = new TreeNode(4);
		root.left.right.right = new TreeNode(7);
		
		 root.right.right = new TreeNode(14);
		 root.right.left = new TreeNode(13);
		 
		 System.out.println(new MaxDiffNodeAndAncestor().getMaxDiffNodeAndAncestor(root));
	}
}
