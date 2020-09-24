import java.util.Stack;

public class RemoveKDigits
{
	public String removeKdigits(String num, int k) 
	{
		if(k <= 0) return num;	
		if(num == null) return "";
		if(k >= num.length()) return "0";
		
		Stack<Character> stack = new Stack<>();
		StringBuffer sbuff = new StringBuffer();
		
		for(int i = 0; i < num.length(); ++i)
		{
			while(k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i))
			{
				stack.pop();
				
				k--;
			}
			
			stack.push(num.charAt(i));
		}
		
		while(k > 0 && !stack.isEmpty())
		{
			stack.pop();
			
			k--;
		}
		
		while(!stack.isEmpty())
		{
			sbuff.insert(0, stack.pop());
		}
		
		while(sbuff.length() > 1 && sbuff.charAt(0) == '0')
		{
			sbuff.deleteCharAt(0);
		}
		
		return sbuff.toString();
    }

	public static void main(String[] args)
	{
		System.out.println(new RemoveKDigits().removeKdigits("10", 1));
	}
}
