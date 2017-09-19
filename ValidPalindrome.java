
public class ValidPalindrome 
{
	public boolean isPalindrome(String s) 
	{
		if(s == null)	return true;
		
		s = s.toLowerCase();
		
		int low  = 0;
		int high = s.length() - 1;
		
		while(low < high)
		{
			if(!Character.isAlphabetic(s.charAt(low)))
			{
				++low;
			}
			else
			if(!Character.isAlphabetic(s.charAt(high)))
			{
				--high;
			}			
			else
			{
				if(s.charAt(low) != s.charAt(high))
				{
					return false;
				}
				
				++low;
				--high;
			}
			
		}
		
		return true;
    }
	
	public static void main(String[] args)
	{
		System.out.println(new ValidPalindrome().isPalindrome(".,"));
	}
}
