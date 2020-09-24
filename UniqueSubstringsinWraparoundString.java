import java.util.HashSet;

public class UniqueSubstringsinWraparoundString 
{
	public int findSubstringInWraproundString(String p) 
	{
		if(p == null || p.isEmpty()) return 0;
		
		HashSet<String> set = new HashSet<>();
	
		int count = 0;
		
		for(int len = 1; len <= p.length(); ++len)
		{
			for(int i = 0; i <= p.length() - len; ++i)
			{
				isValid(p.substring(i, i + len), set);				
			}
		}
	
		return set.size();
    }

	private void isValid(String givenStr, HashSet<String> set) 
	{
		if(givenStr.length() == 1) set.add(givenStr);
		
		boolean isValid = true;
		
		for(int curIdx = 1; curIdx < givenStr.length() && isValid; ++curIdx)
		{
			if((givenStr.charAt(curIdx) - 'a') != (givenStr.charAt(curIdx - 1) - 'a' + 1) % 26 )
				isValid = false;
		}
		
		if(isValid) set.add(givenStr);
		
		return;
	}

	public static void main(String[] args)
	{
		System.out.println(new UniqueSubstringsinWraparoundString().findSubstringInWraproundString("abaab"));
	}
}
