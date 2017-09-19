import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class RemoveInvalidParentheses 	
{
	public List<String> removeInvalidParentheses(String s) 
	{
		List<String> retList = new ArrayList<>();
		Stack<Character> stack = new Stack<>();
				
		StringBuffer subString  = new StringBuffer();
		StringBuffer mainString = new StringBuffer();
		
		for(int i = 0; i < s.length(); ++i)
		{
			if(s.charAt(i) != ')')
			{
				 stack.push(s.charAt(i));
			}		
			else
			if(stack.size() != 0)
			{				
				if(getTopBracket(stack) == '(')
				{
					while(stack.peek() != '(')
					{
						subString.insert(0, stack.pop());
					}
					
					subString.insert(0, stack.pop());
					
					subString.append(')');
				}
				else
				{
					
				}
				
				if(stack.size() == 0)
				{
					mainString.append(subString);
					
					subString.setLength(0);
				}
				
			}
		}
		
		stack.clear();
		
		retList.add(mainString.toString() + subString.toString());
		
		subString.setLength(0);
		mainString.setLength(0);
		
		
		
		return retList;
    }
	
	private char getTopBracket(Stack<Character> stack) 
	{
		Iterator<Character> iterator = stack.iterator();
		
		while(iterator.hasNext())
		{
			char ch = iterator.next();
			
			if(ch == '(' || ch == ')') return ch;
		}
		
		return (char)-1;
	}

	public static void main(String[] args)
	{
		System.out.println(new RemoveInvalidParentheses().removeInvalidParentheses("((abcdef)a)"));
	}
}
