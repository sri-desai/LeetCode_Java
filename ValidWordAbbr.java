import java.lang.reflect.Array;
import java.util.Arrays;

public class ValidWordAbbr 
{
	public boolean validWordAbbreviation(String word, String abbr) 
	{
		if(word == null && abbr == null) return true;
		if(word == null || abbr == null) return false;
		if(word.length() < abbr.length()) return false;
		
		int wordIdx = 0;
		int posJump = 0;
		
		for(int i = 0; i < abbr.length(); ++i)
		{			
			if(abbr.charAt(i) >= '0' && abbr.charAt(i) <= '9')
			{
				if(posJump == 0 && abbr.charAt(i) == '0') return false;
				
				posJump = posJump * 10 + abbr.charAt(i) - '0';
			}			
			else
			{
				wordIdx += posJump;
				
				if(wordIdx >= word.length() || word.charAt(wordIdx) != abbr.charAt(i)) return false;
				
				++wordIdx;
				
				posJump = 0;
			}

		}
		
		wordIdx += posJump;
		
		return wordIdx == word.length();
    }
	
	public static void main(String[] args)
	{
		System.out.println(new ValidWordAbbr().validWordAbbreviation("internationalization", "i5a11o1"));
		
		int[] array = new int[5];
		
	    ;
	}
}
