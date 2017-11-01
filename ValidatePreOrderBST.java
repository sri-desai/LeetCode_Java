import java.util.Stack;

public class ValidatePreOrderBST 
{
	public boolean verifyPreorder(int[] preorder) 
	{
		int low = Integer.MIN_VALUE;
		Stack<Integer> stack = new Stack<>();
		
		for(int curNodeVal : preorder)
		{
			if(curNodeVal < low) return false;
			
			while(!stack.isEmpty() && curNodeVal > stack.peek())
			{
				low = stack.pop();
			}
			
			stack.push(curNodeVal);
		}
		
		return true;		
    }
	
	public boolean verifyPreorder_Opt(int[] preorder) 
	{
		int low = Integer.MIN_VALUE;
		int curTopOfStackIdx = -1;
		
		for(int curNodeVal : preorder)
		{
			if(curNodeVal < low) return false;
			
			while(curTopOfStackIdx >= 0 && curNodeVal > preorder[curTopOfStackIdx])
			{
				low = preorder[curTopOfStackIdx--];
			}
			
			preorder[++curTopOfStackIdx] = curNodeVal;
		}
		
		return true;		
    }
}
