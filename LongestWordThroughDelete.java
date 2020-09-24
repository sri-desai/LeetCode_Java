import java.util.ArrayList;
import java.util.List;

public class LongestWordThroughDelete 
{
	public String findLongestWord(String s, List<String> d) 
	{
		if(s == null || s.length() == 0 || d.size() == 0)
			return "";
		
		int[] countArray = new int[26];
		
		for(int i = 0; i < s.length(); ++i)
		{
			countArray[s.charAt(i) - 'a']++; 
		}
		
		return getRes(d, countArray);
    }

	private String getRes(List<String> d, int[] countArray) 
	{
		String retStr = "";
		
		for(int i = 0; i < d.size(); ++i)
		{
			int charCount;
			for(charCount = 0; charCount < d.get(i).length(); ++charCount)
			{
				if(countArray[d.get(i).charAt(charCount) - 'a'] == 0)
				{
					break;
				}
			}
			
			if(charCount == d.get(i).length() && retStr.length() <= charCount)
			{
				if(retStr.length() < d.get(i).length())
				{
					retStr = d.get(i);
				}
				else
				{
					retStr = retStr.compareTo(d.get(i)) < 0 ? retStr : d.get(i);
				}
			}
		}
		
		return retStr;
	}
	
	public static void main(String[] args)
	{
		List<String> list = new ArrayList<>();
		
		list.add("ba");
		list.add("ab");
		list.add("a");
		list.add("b");
		
		System.out.println(new LongestWordThroughDelete().findLongestWord("bab", list));
	}
}
