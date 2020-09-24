import java.util.ArrayList;
import java.util.Collections;

public class TreeSum 
{
	public int sumNumbers(TreeNode root)
	{
		if(root == null)
		{
			return 0;
		}
		
		ArrayList<String> distinctElements = getElements(root);
		
		int val = 0;
		
		for(String num : distinctElements)
		{
			val += Integer.parseInt(num);
		}
		
		return val;
	}

	private ArrayList<String> getElements(TreeNode root) 
	{
		ArrayList<String> list = new ArrayList<>();
		
		/* Leaf node */
		if(root.left == null && root.right == null)
		{			
			list.add(Integer.toString(root.val));
		}
		else
		{
			ArrayList<String> left  = null;
			ArrayList<String> right = null;
			
			if(root.left != null)
			{
				left = getElements(root.left);
			}
			if(root.right != null)
			{
				right = getElements(root.right);
			}
			
			if(left != null)
			{
				for(String number : left)
					list.add(Integer.toString(root.val) + number);
			}
			
			if(right != null)
			{
				for(String number : right)
					list.add(Integer.toString(root.val) + number);				
			}
			
		}
		
		return list;
	}
	
	public static void main(String[] args)
	{
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(0);
		root.left.left = new TreeNode(0);
		root.right = new TreeNode(0);
		root.right.right = new TreeNode(0);
		
		System.out.println(new TreeSum().sumNumbers(root));
	}
}
