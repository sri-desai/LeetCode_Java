
public class PrintRightView
{
	private int curMaxLevel = -1;
	
	public void rightView (TreeNode root)
	{
		if(root == null) return;
		
		printRightTree(root, 0);
	}

	private void printRightTree(TreeNode root, int curLevel) 
	{
		if(root == null) return;
		
		if(curLevel > curMaxLevel)
		{
			System.out.println(root.val);
			
			curLevel = curMaxLevel;
		}
		
		printRightTree(root.right, curLevel + 1);
		printRightTree(root.left, curLevel + 1);
		
	}
}
