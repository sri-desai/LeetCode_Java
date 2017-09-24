
public class MergeBinaryTrees 
{
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) 
	{
		if(t1 == null && t2 == null) return null;
		
		TreeNode curNode;
		
		curNode = t1 == null ? new TreeNode(t2.val) : t2 == null ? 
				  new TreeNode(t1.val) : new TreeNode(t1.val + t2.val);
						  				 
		curNode.left  = mergeTrees(t1 == null ? null : t1.left,   t2 == null ? null : t2.left);
		curNode.right = mergeTrees(t1 == null ? null : t1.right,  t2 == null ? null : t2.right);
		
		return curNode;
    }
	
	public static void main(String[] args)
	{
		TreeNode firstTree = new TreeNode(1);
		firstTree.left     = new TreeNode(3);
		firstTree.right    = new TreeNode(2);		
		firstTree.left.left = new TreeNode(5);
		

		TreeNode secondTree  = new TreeNode(2);
		secondTree.left      = new TreeNode(1);
		secondTree.right     = new TreeNode(3);		
		secondTree.left.right = new TreeNode(4);
		secondTree.right.right = new TreeNode(7);
		
		TreeNode retNode = new MergeBinaryTrees().mergeTrees(firstTree, secondTree);
		
		System.out.println(retNode);
	}
}
