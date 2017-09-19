public class StringIterator 	
{
	private int     countIdx;
	private String  input_string;	
	private int     count;
	private char    charToReturn;

    public StringIterator(String compressedString) 
    {
        input_string = compressedString;
        countIdx     = 1; 
        count        = input_string.charAt(countIdx) - '0';
        charToReturn = input_string.charAt(countIdx - 1);
    }
    
    public char next() 
    {        
        if(countIdx == input_string.length() - 1 && count == 0)
        {
        	return ' ';
        }
        else
        {
        	if(count == 0)
        	{
        		countIdx += 2;
        		
        		charToReturn = input_string.charAt(countIdx - 1);
        		
        		count  = input_string.charAt(countIdx) - '0';
        	}
        	
        	count --;
        	
        	return charToReturn;
        }        
    }
    
    public boolean hasNext()
    {
        return countIdx < input_string.length() - 1 || count > 0;
    }
}