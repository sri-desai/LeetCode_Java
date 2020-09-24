import java.util.HashMap;

public class WordPattern 
{
	public boolean wordPattern(String pattern, String str)
	{
		if(pattern == null || pattern.trim().length() == 0 || str == null || str.trim().length() == 0) return false;
		
		HashMap<Character, String>    charMatch = new HashMap<>();
		HashMap<String,    Character> strMatch  = new HashMap<>();

		String[] splitWords = str.split("\\s+");
		
		if(pattern.length() != splitWords.length) return false;
		
		for(int i = 0; i < pattern.length(); ++i)
		{
			if(!populateDataAndTest(charMatch, strMatch, pattern, splitWords, i)) return false;
		}
		return true;
    }
	
	

	private boolean populateDataAndTest(HashMap<Character, String> charMatch, 
			                            HashMap<String, Character> strMatch,
			                            String pattern, String[] splitWords, int i)
	{
		
		if(charMatch.get(pattern.charAt(i)) == null && strMatch.get(splitWords[i]) == null)
		{
			charMatch.put(pattern.charAt(i), splitWords[i]);
			
			strMatch.put(splitWords[i], pattern.charAt(i));
			
			return true;
		}
		else
		if(charMatch.get(pattern.charAt(i)) != null && strMatch.get(splitWords[i]) != null)
		{
			return charMatch.get(pattern.charAt(i)).equals(splitWords[i]);
		}
		else
		{
			return false;
		}
	}



	public static void main(String[] args)
	{
		System.out.println(new WordPattern().wordPattern("abba", "dog dog dog dog"));
	}
}
