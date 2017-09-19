import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KeyboardRow
{	
	public String[] findWords(String[] words) 
	{
		List<String> list = new ArrayList<>();
		
        String[] check = {"qwertyuiop", "asdfghjkl", "zxcvbnm", " "};
        
        for(String word : words)
        {
        	boolean isFound = true;
        	
        	int prevIdx = -1;
        	
        	for(int j = 0; j < check.length; ++j)
    		{
        		if(check[j].indexOf(Character.toLowerCase(word.charAt(0))) != -1)
        		{
        			prevIdx = j;
        			
        			break;
        		}
    		}
        	
        	if(prevIdx == -1) continue;
        	
        	for(int i = 1; i < word.length(); ++i)
        	{
        		if(check[prevIdx].indexOf(Character.toLowerCase(word.charAt(i))) == -1)
        		{
        			isFound = false;
        			
        			break;
        		}
        	}
        	
        	if(isFound)
        	{
        		list.add(word);
        	}
        	        	
        }
        
        return list.toArray(new String[0]);
    }
	
	public static void main(String[] args)
	{
		String[] words = {"Alaska"};
		
		System.out.println(Arrays.deepToString(new KeyboardRow().findWords(words)));
	}
}
