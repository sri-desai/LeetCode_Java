
public class LongestPalindromicSubstring
{
	private int lowerIdx;
	private int length;
	
	public String longestPalindrome(String s) 
	{
		if(s == null || s.length() == 0) return "";
		else if(s.length() == 1) return s;			
		
		for(int i = 0; i < s.length() - 1; ++i)
		{
			checkPalindrome(s, i, i);
			checkPalindrome(s, i, i + 1);
		}
		
		return s.substring(lowerIdx, lowerIdx + length);
    }
	
	private void checkPalindrome(String s, int startPos, int endPos) 
	{
		while(startPos >= 0 && endPos < s.length() && s.charAt(startPos) == s.charAt(endPos))
		{
			--startPos;
			++endPos;
		}
		
		if(endPos - startPos - 1 > length)
		{
			lowerIdx = startPos + 1;
			length   = endPos - startPos - 1;
		}
		
	}

	public static void main(String[] args)
	{
		System.out.println(new LongestPalindromicSubstring().longestPalindrome("ccd"));
	}
}
