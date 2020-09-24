import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPattern2 
{
	public boolean wordPatternMatch(String pattern, String str) 
	{
		if(pattern == null && str == null) return true;
		if(pattern == null || str == null) return false;
		
		Map<Character, String> patternStringMap = new HashMap<>();
		Set<String>            stringSet        = new HashSet<>();
		
		return isMatch(str, pattern, 0, 0, patternStringMap, stringSet);
    }

	private boolean isMatch(String str, String pattern, int curStrIdx, int curPatIdx, 
			                Map<Character, String> patternStringMap, Set<String> stringSet)
	{
		if(curStrIdx == str.length() && curPatIdx == pattern.length()) return true;
		if(curStrIdx == str.length() || curPatIdx == pattern.length()) return false;
		
		char curPatChar = pattern.charAt(curPatIdx);
		
		if(patternStringMap.containsKey(curPatChar))
		{
			String curMappedString = patternStringMap.get(curPatChar);
			
			if(str.startsWith(curMappedString, curStrIdx))
			{
				return isMatch(str, pattern, curStrIdx + curMappedString.length(), curPatIdx + 1, 
						      patternStringMap, stringSet);
			}
			else
			{
				return false;
			}
		}
		else
		{
			for(int curIdx = curStrIdx; curIdx < str.length(); ++curIdx)
			{
				String curStr = str.substring(curStrIdx, curIdx + 1);
				
				if(stringSet.contains(curStr)) continue;
				
				stringSet.add(curStr);
				
				patternStringMap.put(curPatChar, curStr);
				
				
				if(isMatch(str, pattern, curIdx + 1, curPatIdx + 1, patternStringMap, stringSet))
				{
					return true;
				}
				
				patternStringMap.remove(curPatChar);
				
				stringSet.remove(curStr);
			}
			
			return false;
		}
	}
	
	public static void main(String[] args)
	{
		System.out.println(new WordPattern2().wordPatternMatch("ab", "aa"));		
	}
} 
