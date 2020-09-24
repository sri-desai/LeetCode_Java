import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithKDistinctChars 
{
	public int lengthOfLongestSubstringKDistinct(String s, int k) 
	{
		if(s == null || s.length() == 0) return 0;
		if(k >= s.length())              return s.length();
		
		int startPos  = 0;
		int curMaxLen = 0;
		Map<Character, Integer> charCountMap = new HashMap<>();
		
		for(int curIdx = 0; curIdx < s.length(); ++curIdx)
		{			
			charCountMap.put(s.charAt(curIdx), 
					         charCountMap.getOrDefault(s.charAt(curIdx), 0) + 1);
			
			while(charCountMap.size() > k)
			{
				decRemoveCharFromMapAndSet(s.charAt(startPos++), charCountMap);
			}
			
			curMaxLen = Math.max(curMaxLen, curIdx - startPos + 1);
		}
		
		return curMaxLen;
		
    }

	private void decRemoveCharFromMapAndSet(char charToRemove, Map<Character, Integer> charCountMap) 
	{
		if(charCountMap.get(charToRemove) == 1)
		{
			charCountMap.remove(charToRemove);		
		}
		else
		{
			charCountMap.put(charToRemove, charCountMap.get(charToRemove) - 1);
		}		
	}
	
	public static void main(String[] args)
	{
		int maxLen = new LongestSubStringWithKDistinctChars().lengthOfLongestSubstringKDistinct("eceba", 2);
		
		System.out.println(maxLen);
	}
	
}
