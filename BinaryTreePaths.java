import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths
{
	List<String> mainList;
	
	public List<String> binaryTreePaths(TreeNode root) 
	{
		mainList = new ArrayList<>();
		
		if(root == null) return mainList;
		
		StringBuffer sbuf = new StringBuffer();
		
		getPaths(root, sbuf);
		
		return mainList;
    }

	private void getPaths(TreeNode root, StringBuffer sbuf)
	{
		if(root == null)
		{
			return;
		}
		else if(root.left == null && root.right == null)
		{
			sbuf.append(root.val);
			
			mainList.add(sbuf.toString());
		}
		else
		{
			StringBuffer leftBuffer = new StringBuffer(sbuf);
			
			leftBuffer.append(root.val);
			
			leftBuffer.append("->");
			
			StringBuffer rightBuffer = new StringBuffer(leftBuffer);
			
			getPaths(root.left, leftBuffer);
			
			getPaths(root.right, rightBuffer);			
		}		
	}
	
	public static void main(String[] args)
	{
		TreeNode root = new TreeNode(1);
		root.left     = new TreeNode(2);
		root.right    = new TreeNode(3);
		
		root.left.right = new TreeNode(5);
		
		System.out.println(new BinaryTreePaths().binaryTreePaths(root));
	}
}
