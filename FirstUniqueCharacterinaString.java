
public class FirstUniqueCharacterinaString
{
	public int firstUniqChar(String s) 
	{
		int[] charCount = new int[26];
		
		for(int i = 0; i < s.length(); ++i)
		{
			charCount[s.charAt(i) - 'a']++;
		}
		
		for(int i = 0; i < s.length(); ++i)
		{
			if(charCount[s.charAt(i) - 'a'] == 1)
			{
				return i;
			}
		}
		
		return -1;
    }
	
	public boolean isAnagram(String s, String t)
    {
        if(s == null && t == null) return true;
        if(s == null || t == null) return false;
        if(s.length() == 0 && t.length() == 0) return true;
        if(s.length() != t.length())           return false;
        
        int[] count = new int[26];
        
        for(int i = 0; i < s.length(); ++i)
        {
            ++count[s.charAt(i) - 'a'];
        }
        
        for(int i = 0; i < t.length(); ++i)
        {
            --count[t.charAt(i) - 'a'];
        }
        
        for(int i = 0; i < 26; ++i)
        {
            if(count[i] != 0) return false;
        }
        
        return true;
    }
	
	public static void main(String[] args)
	{
		System.out.println(new FirstUniqueCharacterinaString().isAnagram("a", "a"));
	}
}
