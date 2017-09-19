
public class DetectCapital 
{
	public boolean detectCapitalUse(String word) 
	{
		if(word == null || word.length() <= 1) return true;
		
		int res = checkValidity(word, 1);
		
		return res == 1 ? Character.isUpperCase(word.charAt(0))                                          : 
			   res == 0 ? Character.isUpperCase(word.charAt(0)) || Character.isLowerCase(word.charAt(0)) :
			   false;
    }

	private int checkValidity(String word, int curPos) 
	{
		if(curPos == word.length() - 1)
		{
			return Character.isUpperCase(word.charAt(curPos)) ? 1 : 0;
		}
		else
		{
			int curCharValue  = Character.isUpperCase(word.charAt(curPos)) ? 1 : 0;
			int nextCharValue = checkValidity(word, curPos + 1);
			
			return curCharValue == nextCharValue ? curCharValue : -1;
			
		}
	}
	
	public static void main(String[] args)
	{
		System.out.println(new DetectCapital().detectCapitalUse("uS"));
	}
}
