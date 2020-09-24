import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Print_Right_View_Tree 
{	
	static int lastLevel = 0;
	
	public List<Integer> rightSideView(TreeNode_file root) 	
	{
		List<Integer> list = new ArrayList<>();
		
		//printTree(root);
		
		print_rightSideView(list, root, 1);
				
		return list;        
    }
   

	private void print_rightSideView(List<Integer> list, TreeNode_file root, int myLevel) 
    {		
		if(root == null)
		{
			return;
		}
		
		if(lastLevel < myLevel)
		{
			list.add(root.val);
			
			lastLevel = myLevel;
		}
		
		print_rightSideView(list, root.right, myLevel + 1);
		print_rightSideView(list, root.left,  myLevel + 1);
	}

	public static void main(String[] args)
    {
    	TreeNode_file rootNode = new TreeNode_file(1);
    	rootNode.left     = new TreeNode_file(2);
//    	rootNode.right    = new TreeNode_file(3);
//    	rootNode.left.right = new TreeNode_file(5);
//    	rootNode.right.right = new TreeNode_file(4);
//    	
    	Print_Right_View_Tree soln = new Print_Right_View_Tree();
    	
    	
    }
}

	class TreeNode_file 
	{
	    int val;
	    TreeNode_file left;
	    TreeNode_file right;
	    TreeNode_file(int x) { val = x; }
	}