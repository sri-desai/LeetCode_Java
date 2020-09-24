import java.util.Stack;

public class BSTIterator 
{
	Stack<TreeNode> stack;
	
	private void populateStack (TreeNode root)
	{
		if(root == null)
		{
			return;
		}
		else
		{
			stack.push(root);
			populateStack(root.left);
		}
	}
	
	public BSTIterator(TreeNode root) 
	{	
		stack     = new Stack<>();
		
		populateStack(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() 
    {
        return stack.size() > 0;
    }

    /** @return the next smallest number */
    public int next() 
    {
        TreeNode top = stack.pop();
        
        populateStack(top.right);
        
        return top.val;
    }
    
    public static void main(String[] args)
    {
    	TreeNode root = new TreeNode(5);
    	
    	root.left     = new TreeNode(2);
    	root.right    = new TreeNode(7);
    	
    	root.left.left   = new TreeNode(1);
    	root.left.right  = new TreeNode(3);
    	root.right.left  = new TreeNode(6);
    	root.right.right = new TreeNode(8);
    	
    	BSTIterator obj = new BSTIterator(root);
    	
    	while(obj.hasNext())
    	{
    		System.out.println(obj.next());
    	}
    }
}
