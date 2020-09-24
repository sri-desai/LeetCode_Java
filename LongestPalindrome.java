import java.util.Arrays;
import java.util.HashSet;

public class LongestPalindrome 
{
	public String longestPalindrome(String s) 
	{
		if(s == null || s.length() == 0)
		{
			return null;
		}
				
		return getLargestPalindrome(s, 0, s.length() - 1);
    }

	private String getLargestPalindrome(String givenString, int startIdx, int endIdx) 
	{		
		int curStart = startIdx;
		int curEnd   = endIdx;
		StringBuffer res = new StringBuffer();
		
		if(startIdx < 0 || startIdx >= givenString.length() ||
		   endIdx   < 0 || endIdx   >= givenString.length() ||
		   startIdx > endIdx)
		{
			return null;
		}
		
		while(curStart < curEnd)
		{
			if(givenString.charAt(startIdx) != givenString.charAt(endIdx))
			{
				break;
			}
			
			++curStart;
			--curEnd;
		}
		
		if(curStart == curEnd)
		{
			res.delete(0, res.length());
			
			res.append(givenString.substring(startIdx, endIdx + 1));
			
			return res.toString();
		}
		else
		{
			String first = getLargestPalindrome(givenString, startIdx + 1, endIdx);
			
			String second = getLargestPalindrome(givenString, startIdx, endIdx - 1);
			
			if(first != null && second != null)
			{
				if(first.length() > second.length())
				{
					return first;
				}
				else
				{
					return second;
				}
			}
			
			return null;
		}
		
	}
	
	public int longestPalindromeCount(String s)
	{
		int[] charCount = new int[26];
		
		for(int i = 0; i < s.length(); ++i)
		{
			++charCount[s.charAt(i) - 'a'];
		}
		
		Arrays.sort(charCount);
		
		boolean isOddOver = false;
		int totalCount = 0;
		
		for(int i = 0; i < 26; ++i)
		{
			if((charCount[i] & 1) == 1 && isOddOver)
			{
				continue;
			}
			else
			{
				totalCount += charCount[i];
			}
			
			isOddOver = (charCount[i] & 1) == 1 ? true : false;
		}
		
		return totalCount;
	}
	
	public boolean containsDuplicate(int[] nums) 
    {
        if(nums == null || nums.length == 0) return false;
        
       	HashSet<Integer> set = new HashSet<>();
		
		for(int i : nums)
		{
			if(!set.add(i)) return true;
		}
		
		return false;
    }
	
	public static void main(String[] args)
	{
		int[] array = {1, 1};
		
		System.out.println(new LongestPalindrome().containsDuplicate(array));
	}
}
