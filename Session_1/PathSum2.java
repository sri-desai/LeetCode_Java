import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PathSum2 
{
	 public boolean hasPathSum(TreeNode root, int sum) 
	    {
	        if(root == null) return false;
	        if(sum == root.val && root.left == null && root.right == null) return true;
	        else   return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);	    
	    }
	    
	
	public static void main(String[] args)
	{
		TreeNode root = new TreeNode(1);
		
		System.out.println(new PathSum2().hasPathSum(root, 1));
	}
}
