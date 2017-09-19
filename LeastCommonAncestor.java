import java.util.*;

public class LeastCommonAncestor 
{
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) 
	{
		List<TreeNode> listP = new ArrayList<>();
		List<TreeNode> listQ = new ArrayList<>();
		
		getAdded(root, p, q, listP, listQ);
		
		HashSet<TreeNode> hlistQ = new HashSet<>(listQ);
		
		
		
		for(TreeNode pVal : listP)
		{
			if(hlistQ.contains(pVal))
			{
				return pVal;
			}
		}
		
		return null;		
    }

	private void getAdded(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> listP, List<TreeNode> listQ) 
	{
		if(root == null)
		{
			return;
		}
		
		if(root.val == p.val)
		{
			listP.add(root);		
		}
		else
		if(root.val == q.val)
		{
			listQ.add(root);
		}
		
		getAdded(root.left, p, q, listP, listQ);
		getAdded(root.right, p, q, listP, listQ);
		
		if(listP.size() > 0 && (listP.get(listP.size() - 1) == root.left || listP.get(listP.size() - 1) == root.right))
		{
			listP.add(root);
		}
		if(listQ.size() > 0 && (listQ.get(listQ.size() - 1) == root.left || listQ.get(listQ.size() - 1) == root.right))
		{
			listQ.add(root);
		}
		
		return;
	}

	public static void main(String[] args)
	{
		/*
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		*/
		TreeNode root = new TreeNode(37);
		root.left  =  new TreeNode(-34);
		root.right  =  new TreeNode(-48);
		TreeNode left = root.left;
		TreeNode right = root.right;

		left.right = new TreeNode(-100);


		right.left = new TreeNode(-100);
		right.right = new TreeNode(48);
		right.right.left = new TreeNode(-54);
		right.right.left.left = new TreeNode(-71);
		right.right.left.right = new TreeNode(-22);
		right.right.left.right.right = new TreeNode(8);


		
		System.out.println(new LeastCommonAncestor().lowestCommonAncestor(root, root.left, root.right).val);
	}
}
