import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LongestSubStringWithoutRepeat 
{
	public int lengthOfLongestSubstring(String s) 
	{
		if(s == null || s.length() == 0) return 0;
		
		HashSet<Character> set = new HashSet<>();
		int removeIdx          = 0;
		int curMax             = 0;
		
		for(int i = 0; i < s.length(); ++i)
		{
			if(set.contains(s.charAt(i)))
			{
				while(s.charAt(removeIdx) != s.charAt(i))
				{
					set.remove(s.charAt(removeIdx++));
				}
				
				set.remove(s.charAt(removeIdx++));
			}
			
			set.add(s.charAt(i));
			
			curMax = Math.max(curMax, set.size());			
		}
		
		return curMax;
    }
	
	public int lengthOfLongestSubstringTwoDistinct(String s) 
	{
		if(s == null || s.length() == 0) return 0;
		
        Map<Character, Integer> map = new HashMap<>();
        
        int startPos = 0;
        int maxLen   = 0;
        
        for(int i = 0; i < s.length(); ++i)
        {
        	map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        	
        	while(map.size() > 2)
        	{
        		if(map.get(s.charAt(startPos)) == 1)
        		{
        			map.remove(s.charAt(startPos));
        		}
        		else
        		{
        			map.put(s.charAt(startPos), map.get(s.charAt(startPos)) - 1);
        		}        		        	
        		
        		++startPos;
        	}
        	
        	maxLen = Math.max(maxLen, i - startPos + 1);
        }
        
        return maxLen;
    }
	
	public static void main(String[] args)
	{
		System.out.println(new LongestSubStringWithoutRepeat().lengthOfLongestSubstringTwoDistinct("eceba"));
	}
}
