import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning 
{
	public List<List<String>> partition(String s)
	{		
		List<List<String>> mainList = new ArrayList<>();
		List<int[]>       subList  = new ArrayList<>();
		
		if(s == null || s.trim().length() == 0) return mainList;
		
		populateStrings(0, s, subList, mainList);
		
		return mainList;
	}

	private void populateStrings(int startPos, String givenStr, List<int[]> subList, List<List<String>> mainList)
	{
		if(startPos >= givenStr.length())
		{
			List<String> SubStrList = new ArrayList<>();
			for(int i = 0; i < subList.size(); ++i)
			{
				int[] pos = subList.get(i);
				
				SubStrList.add(givenStr.substring(pos[0], pos[1] + 1));
			}
			
			mainList.add(SubStrList);
			
			return;
		}
		
		for(int i = startPos; i < givenStr.length(); ++i)
		{
			if(isPalindrome(startPos, i, givenStr)) 
			{
				int[] pos = new int[2];
				
				pos[0] = startPos;
				pos[1] = i;
				
				subList.add(pos);
				
				populateStrings(i + 1, givenStr, subList, mainList);
				
				subList.remove(subList.size() - 1);
			}
		}
	}

	private boolean isPalindrome(int startPos, int endPos, String str) 
	{			
		if(endPos >= str.length() || startPos > endPos) return false;
		if(endPos == startPos) return true;
		
		boolean retValue = true;
	
		while(startPos < endPos && retValue)
		{
			if(str.charAt(startPos) != str.charAt(endPos)) retValue = false;
			
			++startPos;
			--endPos;
		}
		
		return retValue;
	}

	public static void main(String[] args)
	{
		System.out.println(new PalindromePartitioning().partition("aaaaaaaaaaaaaaaaa"));
	}
}
