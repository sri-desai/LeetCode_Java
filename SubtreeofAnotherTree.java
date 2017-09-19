import java.util.LinkedList;
import java.util.Queue;

public class SubtreeofAnotherTree
{
	public boolean isSubtree(TreeNode s, TreeNode t)
    {
		boolean isMathcFound = false;
		Queue<TreeNode> nodes = new LinkedList<>();
		
		nodes.add(s);
		
		while(!(isMathcFound || nodes.isEmpty()) )
		{
			TreeNode curNode = nodes.poll();
			
			if(curNode.val == t.val) isMathcFound = compareTrees(curNode, t);
			
			if(curNode.left  != null) nodes.add(curNode.left);
			if(curNode.right != null) nodes.add(curNode.right);
		}
		
		return isMathcFound;
    }

	private boolean compareTrees(TreeNode leftTree, TreeNode rightTree) 
	{
		if(leftTree == null && rightTree == null) return true;
		else
		if(leftTree == null || rightTree == null) return false;
		else
		if(leftTree.val == rightTree.val)
		{
			return compareTrees(leftTree.left, rightTree.left) && compareTrees(leftTree.right, rightTree.right); 
		}
		else return false;		
	}
}
