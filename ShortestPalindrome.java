
public class ShortestPalindrome 
{
	public String shortestPalindrome(String s) 
	{
		if(s == null || s.length() <= 1) return s;
		
		StringBuffer sbuff = new StringBuffer(s);
		
		int lastPalindromeIdx = getEndPalindromeIdx(sbuff, 0);
					
		return sbuff.insert(0, new StringBuffer(s.substring(lastPalindromeIdx + 1)).
				               reverse().toString()).toString();		
    }
	
	private int getEndPalindromeIdx (StringBuffer s, int startPos)
	{
		int endPos = s.length() - 1;
		
		while(startPos < endPos)
		{
			if(isPalindrome(s, startPos, endPos))
			{
				return endPos;
			}
			
			endPos--;
		}
		
		return startPos;
	}

	private boolean isPalindrome(StringBuffer s, int startPos, int endPos) 
	{
		while(startPos < endPos)
		{
			if(s.charAt(startPos) != s.charAt(endPos))
			{
				return false;
			}
			
			++startPos;
			--endPos;
		}
		
		return true;
	}
	
	public static void main(String[] args)
	{
		System.out.println(new ShortestPalindrome().shortestPalindrome("aba"));
	}
}
