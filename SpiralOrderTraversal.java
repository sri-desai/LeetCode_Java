import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class SpiralOrderTraversal 
{
	public List<Integer> spiralTraversal (TreeNode root)
	{
		List<Integer> list = new ArrayList<>();
		Stack<TreeNode> s1 = new Stack<>();
		Stack<TreeNode> s2 = new Stack<>();
		
		if(root == null) return list;
		
		s1.push(root);
		
		while(!s1.isEmpty() || !s2.isEmpty())
		{
			while(!s1.isEmpty())
			{
				TreeNode curNode = s1.pop();
				
				list.add(curNode.val);
				
				if(curNode.right != null) s2.push(curNode.right);
				if(curNode.left  != null) s2.push(curNode.left);
			}
			while(!s2.isEmpty())
			{
				TreeNode curNode = s2.pop();
				
				list.add(curNode.val);
				
				if(curNode.left  != null) s1.push(curNode.left);
				if(curNode.right != null) s1.push(curNode.right);
			}
		}
		
		return list;
	}
	
	public static void main(String[] args)
	{
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(7);
		root.left.right = new TreeNode(6);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(4);
		
		System.out.println(new SpiralOrderTraversal().spiralTraversal(root));
	}
}
