import java.util.Stack;

public class EvaluateReversePolishNotation
{
	public int evalRPN(String[] tokens) 
	{
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0; i < tokens.length; ++i)
		{
			if(tokens[i].equals("+") || tokens[i].equals("-") || 
			   tokens[i].equals("*") || tokens[i].equals("/"))
			{
				if(calculate(stack, tokens[i]) == -1)
				{
					return -1;
				}
			}
			else
			{
				stack.push(Integer.parseInt(tokens[i]));
			}
		}
		
		return stack.pop();
    }

	private int calculate(Stack<Integer> stack, String operator) 
	{
		if(stack.size() <= 1) return -1;
		
		int operand1 = stack.pop();
		int operand2 = stack.pop();
		
		if(operator.equals("+"))
		{
			stack.push(operand2 + operand1);
		}
		else
		if(operator.equals("-"))
		{
			stack.push(operand2 - operand1);
		}
		else
		if(operator.equals("*"))
		{
			stack.push(operand2 * operand1);
		}
		else
		{
			stack.push(operand2 / operand1);
		}		
		
		return 0;
	}
	
	public static void main(String[] args)
	{
		String[] values = {"4", "3", "-"};
		
		System.out.println(new EvaluateReversePolishNotation().evalRPN(values));
	}
}
