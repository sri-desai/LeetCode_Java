import java.util.HashMap;
import java.util.Iterator;

public class LongestSubString
{	
	/* Need to write the solution */
	public int longestSubstring(String s, int k) 
	{
		if(s == null || s.length() < k || s.trim().length() == 0)
		{
			return 0;
		}
		else
		if(k == 0)
		{
			return s.length();
		}

		return getMaxSubStr(s, k);		
    }

	
		
	private int getMaxSubStr(String s, int k) 
	{
		HashMap<Integer,   Integer> prevValues = new HashMap<>();
		HashMap<Character, Integer> curCount = new HashMap<>();
		
		int startPos = 0;
		int endPos = 0;
		
		while(startPos <= endPos && startPos < s.length())
		{
			while(endPos - startPos < k)
			{
				curCount.put(s.charAt(endPos), curCount.getOrDefault(s.charAt(endPos), 0) + 1);
				
				++endPos;
			}
			
			
		}
		
		
		
		
		return 0;
	}



	public static void main(String[] args)
	{
		//System.out.println(new LongestSubString().longestSubstring("aaabbbcdefcdefgggggggggggggggcde", 3));
		System.out.println(new LongestSubString().longestSubstring("aaabbbcdefcdefgggggggggggggggcde", 3));
	}
}
