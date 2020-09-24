
public class MinimumWindowSubstring 
{
	private final int MAX_ASCII_CHAR = 256;
	
	public String minWindow(String s, String t) 
	{
		if(s.length() < t.length()) return "";
		
		int[] strHash = new int[MAX_ASCII_CHAR];
		int[] patHash = new int[MAX_ASCII_CHAR];
		
		for(int i = 0; i < t.length(); ++i)
		{
			++patHash[t.charAt(i)];
		}
		
		int count = 0;
		int minLen = Integer.MAX_VALUE;
		int startIdx = 0;
		int curStart = 0;
		
		for(int i = 0; i < s.length(); ++i)
		{
			++strHash[s.charAt(i)];
			
			if(strHash[s.charAt(i)] <= patHash[s.charAt(i)]) ++count;
			
			if(count == t.length())
			{
				while(strHash[s.charAt(curStart)] > patHash[s.charAt(curStart)])
				{
					--strHash[s.charAt(curStart++)];
				}
				
				if( i - curStart + 1 < minLen)
				{
					startIdx = curStart;
					minLen = i - curStart + 1;
				}
			}
			
			
		}
		
		return minLen == Integer.MAX_VALUE ? "" : s.substring(startIdx, startIdx + minLen);
    }

	public static void main(String[] args)
	{
		System.out.println(new MinimumWindowSubstring().minWindow("ADOBECODEBANC", "ABC"));
	}
}
