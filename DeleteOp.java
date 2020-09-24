
public class DeleteOp
{
	public int minDistance(String word1, String word2)
    {
        if(word1 == null && word2 == null) return 0;
		if(word1 == null || word2 == null) return word1 == null ? word2.length() : word1.length();
		if(word1.length() == 0 || word2.length() == 0) return Math.max(word1.length(), word2.length());
		
		int memoization[][] = new int[word1.length() + 1][word2.length() + 1];
		
		for(int i = 0; i <= word1.length(); ++i)
		{
			for(int j = 0; j <= word2.length(); ++j)
			{
				if(i == 0 || j == 0)
				{
					memoization[i][j] = 0;
				}
				else
				if(word1.charAt(i - 1) == word2.charAt(j - 1))
				{
					memoization[i][j] = 1 + memoization[i - 1][j - 1];
				}
				else
				{
					memoization[i][j] = Math.max(memoization[i - 1][j], memoization[i][j - 1]);
				}
			}
		}
		
		return Math.abs(word1.length()  - memoization[word1.length()][word2.length()]) + 
				Math.abs(word2.length() - memoization[word1.length()][word2.length()]);
    }
	
	public static void main(String[] args)
	{
		System.out.println(new DeleteOp().minDistance("a", "ab"));
	}
}
