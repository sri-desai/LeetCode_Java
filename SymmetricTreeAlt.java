

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/*	class TreeNode 
   {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
   }
 */
public class SymmetricTreeAlt 
{
	public boolean isSymmetric(TreeNode_Sym root) 
	{
		if(root == null) return false;
		
		ArrayList<Integer> alist = new ArrayList<>();
		
		storeInorder(root, alist);
		
		return isPalindrome(alist);
			
    }

	private void storeInorder(TreeNode_Sym root, ArrayList<Integer> alist) 
	{
		if(root == null)
		{
			return;
		}
		
		storeInorder(root.left, alist);
		alist.add(root.val);
		storeInorder(root.right, alist);		
	}

	private boolean isPalindrome(ArrayList<Integer> alist)
	{
		boolean isPalindrome = true;
		
		int startIdx = 0;
		int endIdx   = alist.size() > 0 ? alist.size() - 1 : 0;
		
		while(startIdx < endIdx)
		{
			if(alist.get(startIdx) != alist.get(endIdx))
			{
				isPalindrome = false;
				
				break;
			}
			
			startIdx++;
			--endIdx;
		}
		
		return isPalindrome;
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

