import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WordBreak 
{	
	/* First Approach */
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
			for(int j = 0; j < i; ++j)
			{
				if(status[j] && dict.contains(s.substring(j, i)))
				{
					status[i] = true;
				}
			}
		}
		
		return status[s.length()];
    }


	public static void main(String[] args)
	{
		WordBreak obj = new WordBreak();
		List<String> list = new ArrayList<>();
		list.add("aaaa");
		list.add("aaa");
		
		System.out.println(obj.wordBreak("aaaaaaa", list));
		
	}
}
