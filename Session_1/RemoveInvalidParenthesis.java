import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class RemoveInvalidParenthesis 
{
	private boolean isValidString (String str)
	{
		int count = 0;
		
		for(int i = 0; i < str.length(); ++i)
		{
			if(str.charAt(i) == '(') ++count;
			if(str.charAt(i) == ')') --count;
			
			if(count < 0) return false;
		}
		
		return count == 0;
	}
	
	public List<String> removeInvalidParentheses(String s) 
	{        
        Queue<String> stringsToProcess     = new LinkedList<>();
        Set<String>   processedStrings     = new HashSet<>();
        List<String>  validParenthesesList = new ArrayList<>();
        
        /* this flag corresponds to the highest level at
         * which we can find the valid parenthesis 
         * 
         * No need to split the string down the level
         * */
        boolean validParenthesisFound = false;
        
        stringsToProcess.add(s);
        
        while(!stringsToProcess.isEmpty())
        {
        	String stringToProcess = stringsToProcess.remove();
        	
        	if(processedStrings.contains(stringToProcess)) continue;
        	
        	processedStrings.add(stringToProcess);
        	
        	if(isValidString(stringToProcess))
        	{
        		validParenthesesList.add(stringToProcess);    
        		
        		validParenthesisFound = true;
        	}
        	
        	if(validParenthesisFound) continue;
        	
        	for(int curCharIdx = 0; curCharIdx < stringToProcess.length(); ++curCharIdx)
    		{
        		if(stringToProcess.charAt(curCharIdx) == '(' ||
         		   stringToProcess.charAt(curCharIdx) == ')'
         	      )    			
    			{
    				stringsToProcess.add(stringToProcess.substring(0, curCharIdx) + 
    						             stringToProcess.substring(curCharIdx + 1)
    						            );
    			}
    		}
        }
        
        return validParenthesesList;
    }
	
	public static void main(String[] args)
	{
		System.out.println(new RemoveInvalidParenthesis().removeInvalidParentheses("()())()"));
	}
}
