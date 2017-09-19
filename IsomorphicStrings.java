import java.util.HashMap;

public class IsomorphicStrings
{
	public boolean isIsomorphic(String s, String t) 
    {
        if(s == null && t == null)   return true;
        if(s == null || t == null)   return false;
        
        HashMap<Character, Character> map = new HashMap<>();
        
        for(int i = 0; i < s.length(); ++i)
        {
        	if(map.containsKey(s.charAt(i)))
        	{
        		if(map.get(s.charAt(i)) != t.charAt(i)) return false;
        	}
        	else
        	{
        		map.put(s.charAt(i), t.charAt(i));
        	}
        }
        
        return true;
    }
	
	public static void main(String[] args)
	{
		System.out.println(new IsomorphicStrings().isIsomorphic("paper", "title"));
	}
}
