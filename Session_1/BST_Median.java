import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class BST_Median 
{
	boolean isNodeFound;
	
	public int findMedian (TreeNode root)
	{
		int nodes = getCountOfNodes(root);
		
		if((nodes & 1) == 0)
		{
			isNodeFound = false;
			
			int firstNode = getNode(root, nodes / 2);
			
			isNodeFound = false;
			
			int secNode   = getNode(root, nodes / 2 + 1);	
			
			return (firstNode + secNode) / 2;
		}
		else
		{
			isNodeFound = false;
			
			return getNode(root, nodes / 2 + 1);
		}
	}

	private int getNode(TreeNode root, int nodeCount) 
	{
		if(root == null) return nodeCount;
		
		int nodeInLeftSubTree = getNode(root.left, nodeCount);
		
		if(!isNodeFound && nodeInLeftSubTree == 1)
		{
			isNodeFound = true;
			
			return root.val;
		}
		else
		if(isNodeFound)
		{
			return nodeInLeftSubTree;
		}
		
		return getNode(root.right, nodeInLeftSubTree - 1);
	}

	private int getCountOfNodes(TreeNode root)
	{
		if(root == null) return 0;
		else             return 1 + getCountOfNodes(root.left) + getCountOfNodes(root.right);
	}
	
	public static void main(String[] args)
	{		
		TreeNode root = new TreeNode(6);
		
		root.left     = new TreeNode(3);
		root.right    = new TreeNode(8);
		
		root.left.left  = new TreeNode(1);
		root.left.right = new TreeNode(4);
		
		root.right.left  = new TreeNode(7);
		
		System.out.println(new BST_Median().findMedian(root));
	}
}
