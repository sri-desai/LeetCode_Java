import java.util.Stack;;

public class ReversePolish 
{
	public int evalRPN(String[] tokens) 
	{
		Stack<Integer> operands = new Stack<>();
		int b, a;
		
		for(String curOp : tokens)
		{
			if(curOp.equals("+")) {
				operands.add(operands.pop()+operands.pop());
			}
			else if(curOp.equals("/")) {
				b = operands.pop();
				a = operands.pop();
				operands.add(a / b);
			}
			else if(curOp.equals("*")) {
				operands.add(operands.pop() * operands.pop());
			}
			else if(curOp.equals("-")) {
				b = operands.pop();
				a = operands.pop();
				operands.add(a - b);
			}
			else {
				operands.add(Integer.parseInt(curOp));
			}
		}
		
		return operands.peek();
    }
}
