
public class IsSubsequence 
{

	public boolean isSubsequence(String s, String t) 
	{
		int startPos = 0;
		
		if(s == null || t == null) return false;
		
		for(int i = 0; i < t.length(); ++i)
		{
			if(startPos >= s.length())
			{
				break;
			}
			
			if(s.charAt(startPos) == t.charAt(i))
			{
				++startPos;
			}
		}
		
		return startPos >= s.length() ? true : false;
    }

	

	public static void main(String[] args)
	{
		String s = "";
		String t = "ahbgdc";
		
		System.out.println(new IsSubsequence().isSubsequence(s, t));
	}
}
