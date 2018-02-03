
public class AddOneRowtoTree 
{
	public TreeNode addOneRow(TreeNode root, int v, int d) 
	{ 
		if(d == 1)
		{
			TreeNode newRoot = new TreeNode(v);
			
			newRoot.left = root;
			
			return newRoot;
		}
		else
		{
			getNewTree(root, 1, d - 1, v);
			
			return root;
		}
    }

	private void getNewTree(TreeNode root, int curDepth, int targetDepth, int valueToInsert) 
	{
		if(root == null) return;
		
		if(curDepth == targetDepth)
		{
			TreeNode leftSubTree  = new TreeNode(valueToInsert);
			TreeNode rightSubTree = new TreeNode(valueToInsert);
			
			leftSubTree.left = root.left;
			rightSubTree.right = root.right;
			
			root.left = leftSubTree;
			root.right = rightSubTree;
		}
		else
		{
			getNewTree(root.left,  curDepth + 1, targetDepth, valueToInsert);
			getNewTree(root.right, curDepth + 1, targetDepth, valueToInsert);
		}
	}
	
	public static void main(String[] args)
	{
		TreeNode root = new TreeNode(4);
		root.left     = new TreeNode(2);
		
		new AddOneRowtoTree().addOneRow(root, 1, 1);
	}
}
