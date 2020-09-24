import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode_Sym 
   {
     int val;
     TreeNode_Sym left;
     TreeNode_Sym right;
     TreeNode_Sym(int x) { val = x; }
   }
 
public class Symmetric_Tree 
{
	public boolean isSymmetric(TreeNode_Sym root) 
	{
		if(root == null) return true;
		
		return isMirror(root.left, root.right);
    }

	private boolean isMirror(TreeNode_Sym leftTree, TreeNode_Sym rightTree) 
	{
		if(leftTree == null && rightTree == null) return true;
		if(leftTree == null || rightTree == null) return false;
		
		return leftTree.val == rightTree.val            && 
			   isMirror(leftTree.left, rightTree.right) &&
			   isMirror(leftTree.right, rightTree.left); 		
	}

	public static void main (String[] args)
	{
		TreeNode_Sym rootNode = new TreeNode_Sym(1);
		
		rootNode.left = new TreeNode_Sym(2);
		rootNode.right = new TreeNode_Sym(2);
		
		Symmetric_Tree tree = new Symmetric_Tree();
		
		System.out.println(tree.isSymmetric(rootNode));
	}
}

