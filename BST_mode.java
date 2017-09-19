import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* need to correct the soln */
public class BST_mode
{
	public Integer[] findMode(TreeNode root) 
	{
		List<Integer> mode = new ArrayList<>();
		
		calculateMode(root, mode);
		
		return mode.toArray(new Integer[0]);
    }

	private void calculateMode(TreeNode root, List<Integer> mode)
	{
		int curMode = 0;
		
		Queue<TreeNode> nodes = new LinkedList<>();
		
		nodes.add(root);
		
		while(!nodes.isEmpty())
		{
			TreeNode curNode = nodes.poll();
			
			int curCount = countNodes(curNode, root);
			
			if(curCount >= curMode)
			{
				mode.add(curNode.val);
				
				curMode = curCount;
			}
		}
		
	}

	private int countNodes(TreeNode curNode, TreeNode root)
	{
		if(root == null) return 0;
		
		int count = root.val == curNode.val ? 1 : 0;
		
		return count + countNodes(curNode, root.left) + countNodes(curNode, root.right);
	}
	
	public static void main(String[] args)
	{
		TreeNode root = new TreeNode(1);
		root.right  = new TreeNode(2);
		root.right.left = new TreeNode(2);
		
		System.out.println(new BST_mode().findMode(root));
	}
}
