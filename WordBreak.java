import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WordBreak 
{	
	public boolean wordBreak(String s, List<String> wordDict) 
	{
		if(s == null)
		{
			return false;
		}
		
		HashSet<String> dict = new HashSet<>(wordDict);
		boolean[] status = new boolean[s.length() + 1];
		status[0] = true;
		
		for(int i = 1; i <= s.length(); ++i)
		{
			for(int j = 0; j < i && !status[i]; ++j)
			{
				if(status[j] && dict.contains(s.substring(j, i)))
				{
					status[i] = true;
				}
			}
		}
		
		return status[s.length()];
    }
	
	public boolean wordBreakPartTwo(String s, List<String> wordDict)
	{
		if(s == null)
		{
			return false;
		}
		
		HashSet<String> dict = new HashSet<>(wordDict);
		
		return isWordBreakable(s, 0, dict);
	}


	private boolean isWordBreakable(String s, int startPos, HashSet<String> dict)
	{
		if(startPos == s.length()) return true;
		
		for(int curPos = startPos; curPos < s.length(); ++curPos)
		{
			if(dict.contains(s.substring(startPos, curPos + 1)) && 
			   isWordBreakable(s, curPos + 1, dict)
			  )
			{
				return true;
			}
		}		
		
		return false;
	}

	public static void main(String[] args)
	{
		WordBreak obj = new WordBreak();
		List<String> list = new ArrayList<>();
		list.add("leet");
		list.add("code");
		
		System.out.println(obj.wordBreakPartTwo("leetcode", list));
		
	}
}
