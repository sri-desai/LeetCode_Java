
/* result has to be lexicographically small */
public class RemoveDuplicateLetters 
{
	public String removeDuplicateLetters(String s) 
	{
		int[] charCount = new int[26];
		
		int smallCharIdx = 0;
		
		for(int i = 0; i < s.length(); ++i)
		{
			++charCount[s.charAt(i) - 'a'];
		}
		
		for(int i = 0; i < s.length(); ++i)
		{						
			if(s.charAt(i) < s.charAt(smallCharIdx))
			{
				smallCharIdx = i;
			}
			
			if(--charCount[s.charAt(i) - 'a'] == 0)
			{
				break;
			}
		}
		
		return s.length() == 0 ? "" : s.charAt(smallCharIdx) + 
			  removeDuplicateLetters(s.substring(smallCharIdx + 1).
			  replace("" + s.charAt(smallCharIdx), ""));
    }
	
	public static void main(String[] args)
	{
		System.out.println(new RemoveDuplicateLetters().removeDuplicateLetters("cbacdcbc"));
	}
}
