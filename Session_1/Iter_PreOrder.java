import java.util.HashSet;
import java.util.Stack;

public class Iter_PreOrder 
{
	public void iterativePreOrder (TreeNode root)
	{
		Stack<TreeNode> stack = new Stack<>();
		HashSet<TreeNode> visitedNode = new HashSet<>();
		
		stack.add(root);
		
		while(!stack.isEmpty())
		{
			TreeNode curNode = stack.peek();
			
			if(visitedNode.contains(curNode))
			{
				stack.pop();
				
				System.out.println(curNode.val);
			}
			else
			{
				visitedNode.add(curNode);
				
				if(curNode.right != null) stack.push(curNode.right);
				if(curNode.left  != null) stack.push(curNode.left);
			}
		}
	}
	
	public static void main(String[] args)
	{
		TreeNode root = new TreeNode(1);
		
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		
		root.left.right = new TreeNode(4);
		
		new Iter_PreOrder().iterativePreOrder(root);
	}
}
