
class SubTreeInfo
{
	int BSTSize;
	int minValue;
	int maxValue;
	
	public SubTreeInfo() 
	{
		BSTSize = 0;
		minValue = Integer.MAX_VALUE;
		maxValue = Integer.MIN_VALUE;
	}
}

public class LargestBSTSubTree 
{			
	public int largestBSTSubtree(TreeNode root) 
	{
		if(root == null) return 0;
		
		SubTreeInfo treeInfo = new SubTreeInfo();
		
		populateLargestBST(root, treeInfo);
		
		return treeInfo.BSTSize;
    }

	private boolean populateLargestBST(TreeNode root, SubTreeInfo curTreeInfo) 
	{	
		boolean isLeftTreeBST;
		boolean isRightTreeBST;
		boolean bstResult;
		SubTreeInfo leftSubTreeInfo  = new SubTreeInfo();
		SubTreeInfo rightSubTreeInfo = new SubTreeInfo();
				
		
		if(root.left == null)
		{
			isLeftTreeBST = true;
			leftSubTreeInfo.maxValue = root.val;
			leftSubTreeInfo.minValue = root.val;
		}
		else
		{
			isLeftTreeBST  = populateLargestBST(root.left,  leftSubTreeInfo);
		}
		
		if(root.right == null)
		{
			isRightTreeBST = true;
			rightSubTreeInfo.maxValue = root.val;
			rightSubTreeInfo.minValue = root.val;
		}
		else
		{
			isRightTreeBST = populateLargestBST(root.right, rightSubTreeInfo);
		}
		
		
		if( isLeftTreeBST && isRightTreeBST && 
		    leftSubTreeInfo.minValue <= root.val  && leftSubTreeInfo.maxValue <= root.val && 
		    rightSubTreeInfo.minValue >= root.val && rightSubTreeInfo.maxValue >= root.val
		  )
		{
			curTreeInfo.BSTSize = 1 + leftSubTreeInfo.BSTSize + rightSubTreeInfo.BSTSize;
			
			bstResult = true;
		}
		else
		{
			curTreeInfo.BSTSize = Math.max(leftSubTreeInfo.BSTSize, rightSubTreeInfo.BSTSize);
			
			bstResult =  false;
		}
		
		curTreeInfo.maxValue = Math.max(leftSubTreeInfo.maxValue, rightSubTreeInfo.maxValue);
		curTreeInfo.minValue = Math.min(leftSubTreeInfo.minValue, rightSubTreeInfo.minValue);
		
		return bstResult;
	}
	
	public static void main(String[] args)
	{
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(15);
		
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(8);
		root.right.right = new TreeNode(7);
		
		System.out.println(new LargestBSTSubTree().largestBSTSubtree(root));
	}
}
