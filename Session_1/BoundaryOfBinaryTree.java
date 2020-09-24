import java.util.ArrayList;
import java.util.List;

public class BoundaryOfBinaryTree
{
	public List<Integer> boundaryOfBinaryTree(TreeNode root) 
    {
        List<Integer> retList = new ArrayList<>();
        
        if(root == null) return retList;
        
        retList.add(root.val);
        
        populateLeftNonLeafNode  (root.left,  retList);
        populateLeafNodes        (root.left,  retList);
        populateLeafNodes        (root.right, retList);
        populateRightNonLeafNode  (root.right, retList);
        
        return retList;
    }

	private void populateRightNonLeafNode(TreeNode root, List<Integer> retList) 
	{
		if(root == null || root.left == null && root.right == null) return;
				
		if(root.right == null) populateLeftNonLeafNode(root.left, retList);
		else				  populateLeftNonLeafNode(root.right, retList);
		
		retList.add(root.val);
		
	}

	private void populateLeafNodes(TreeNode root, List<Integer> retList) 
	{
		if(root == null) return;
		
		if(root.left == null && root.right == null) retList.add(root.val);
		
		populateLeafNodes(root.left,  retList);
		populateLeafNodes(root.right, retList);
		
	}

	private void populateLeftNonLeafNode(TreeNode root, List<Integer> retList)
	{
		if(root == null || root.left == null && root.right == null) return;
		
		retList.add(root.val);
		
		if(root.left == null) populateLeftNonLeafNode(root.right, retList);
		else				  populateLeftNonLeafNode(root.left, retList);
				
	}
	
	public static void main(String[] args)
	{
		TreeNode root = new TreeNode(1);
		
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		
		root.left.right.left = new TreeNode(20);
		root.left.right.left.left = new TreeNode(7);
		root.left.right.right.right = new TreeNode(8);
		root.right.left.left = new TreeNode(9);
		root.right.left.right = new TreeNode(10);
		
		
		System.out.println(new BoundaryOfBinaryTree().boundaryOfBinaryTree(root));
	}
}
