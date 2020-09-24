
public class PalindromicSubstring
{
	public int countSubstrings(String s) 
	{
		if(s == null || s.trim().length() == 0) return 0;
		
		int count = 0;
		
		s = s.trim();
		
		for(int len = 1; len <= s.length(); ++len)
		{
			for(int startPos = 0; startPos < s.length(); ++startPos)
			{
				if(isValidPalindrome(s, startPos, startPos + len - 1))
				{
					++count;
				}
			}
		}
		
		return count;
	}

	private boolean isValidPalindrome(String s, int startPos, int endPos) 
	{
		if(endPos >= s.length()) return false;
		
		while(startPos < endPos)
		{
			if(s.charAt(startPos) != s.charAt(endPos)) return false;
			
			++startPos;
			--endPos;
		}
		
		return true;
	}
	
	public static void main(String[] args)
	{
		System.out.println(new PalindromicSubstring().countSubstrings(""));
	}
}
