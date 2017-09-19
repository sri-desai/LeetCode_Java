import java.util.Stack;

public class RemoveDigits 
{
	public String removeKdigits(String num, int k) 
	{
		StringBuffer sb = new StringBuffer();
		
		int charDeleted = 0;
		
		if(num == null || num.length() <= k)
		{
			return new String("0");
		}
		
		Stack<Character> stack = new Stack<>();
		
		for(int i = 0; i < num.length(); ++i)
		{
			while(k > 0 && !stack.isEmpty() && num.charAt(i) < stack.peek())
			{
				stack.pop();
				--k;
			}
			
			stack.push(num.charAt(i));
		}
		
		while(k > 0 && !stack.isEmpty())
		{
			stack.pop();
			
			--k;
		}
						
		while(!stack.isEmpty())
		{
			sb.append(Character.toString(stack.pop()));
		}
		
		sb = sb.reverse();
		
		while(sb.length() > 1 && sb.charAt(0) == '0')
		{
			sb = sb.deleteCharAt(0);
		}
		
		return sb.toString();
    }
	
	public static void main(String args[])
	{
		RemoveDigits removeObj = new RemoveDigits();
		
		System.out.println(removeObj.removeKdigits("10200", 1));
	}
}
