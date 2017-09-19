import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class GenerateParanthesis 
{
	public List<String> generateParenthesis(int n) 
	{
		HashSet<String> set = getParenthesis(n);
		
		List<String> list = new ArrayList<>();
		Iterator<String> iterator = set.iterator();
		
		while(iterator.hasNext())
		{
			list.add(iterator.next());
		}
		
		return list;
    }

	private HashSet<String> getParenthesis(int remaining) 
	{
		HashSet<String> set = new HashSet<>();
		
		if(remaining == 0)
		{
			;
		}
		else
		if(remaining == 1)
		{
			set.add("()");
		}
		else
		{
			HashSet<String> prev = getParenthesis(remaining - 1);
			
			for(String str : prev)
			{
				for(int i = 0; i < str.length(); ++i)
				{
					if(str.charAt(i) == '(') 
						set.add(getNewString(str, i));
				}
				
				set.add(str + "()");
			}
		}
		
		return set;
	}

	private String getNewString(String prevStr, int pos) 
	{
		String left = prevStr.substring(0, pos + 1);
		String right = prevStr.substring(pos + 1);
		
		return left + "()" + right;
	}
	
	public static void main(String[] args)
	{
		System.out.println(new GenerateParanthesis().generateParenthesis(3));
	}
}
