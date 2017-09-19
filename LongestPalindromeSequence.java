

public class LongestPalindromeSequence 
{
	public int longestPalindromeSubseq(String s) 
	{
		if(s == null || s.length() == 0)
		{
			return 0;
		}
		
		int[][] memoization = new int[s.length()][s.length()];
		
		for(int i = 0; i < s.length(); ++i)
		{
			memoization[i][i] = 1;
		}
		
		for(int length = 2; length <= s.length(); ++length)
		{
			for(int start = 0; start <= s.length() - length; ++start)
			{
				int end = start + length - 1;
				
				if(s.charAt(start) == s.charAt(end))
				{
					memoization[start][end] = 2 + memoization[start + 1][end - 1];
				}
				else
				{
					memoization[start][end] = Math.max(memoization[start + 1][end],
							                           memoization[start][end - 1] 
							                          );
				}
			}
		}
		
		return memoization[0][s.length() - 1];		
    }

	public static void main(String[] args)
	{
		System.out.println(new LongestPalindromeSequence().longestPalindromeSubseq("bbbab"));
	}
}
