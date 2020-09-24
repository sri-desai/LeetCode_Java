import java.util.ArrayList;
import java.util.List;

public class BoundaryBinaryTree 
{
	private int leftRange;
	private int rightRange;
	
	public List<Integer> boundaryOfBinaryTree (TreeNode root)
	{
		List<Integer> retList = new ArrayList<>();
		
		if(root == null) return retList;
		
		leftRange = 0;
		rightRange = 0;
		
		retList.add(root.val);
		
		getBoundaryNodes(root.left,  retList, -1);
		getBoundaryNodes(root.right, retList,  1);
		
		return retList;
	}

	private void getBoundaryNodes(TreeNode root, List<Integer> retList, int curRange)
	{
		if(root == null) return;
		if(root.left == null && root.right == null)
		{
			retList.add(root.val);
		}
		else
		{
			if(leftRange > curRange)
			{
				retList.add(root.val);
				
				leftRange = curRange;
			}
			else
			if(rightRange < curRange)
			{
				retList.add(root.val);
				
				rightRange = curRange;
			}
			
			getBoundaryNodes(root.left, retList, curRange - 1);
			getBoundaryNodes(root.right, retList, curRange + 1);
		}
	}
	
	public static void main(String[] args)
	{
		TreeNode root = new TreeNode(1);
		
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		
		root.left.right.left = new TreeNode(51);
		root.left.right.right = new TreeNode(52);
		
		System.out.println(new BoundaryBinaryTree().boundaryOfBinaryTree(root));
	}
}
