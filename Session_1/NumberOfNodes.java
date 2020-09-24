import java.util.LinkedList;
import java.util.Queue;

public class NumberOfNodes 
{
	/* Not effecient, runs in O(n) time, sucks*/
	public int countNodes(TreeNode root) 
	{
		long count = 0;
		
		Queue<TreeNode> queue = new LinkedList<>();
		
		queue.add(root);
	
		while(!queue.isEmpty())
		{
			++count;
			
			TreeNode curNode = queue.remove();
			
			if(curNode.left != null)
			{
				queue.add(curNode.left);
			}
			
			if(curNode.right != null)
			{
				queue.add(curNode.right);
			}
		}
		
		return (int) count;
    }
}
