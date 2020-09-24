
public class DecodeString 
{
	String globalStr;
	
	public String decodeString(String s) 
	{
		if(s == null)
		{
			return null;
		}
		
		globalStr = s;
		
		return getString(0, s.length() - 1);
    }

	private String getString(int startPos, int endPos) 
	{
		int numberOfTimesRepeat = 0;
		StringBuffer retVal = new StringBuffer();
		
		for(int i = startPos; i <= endPos; ++i)
		{
			if(globalStr.charAt(i) == '[')
			{
				int getEndOfBrackert = endOfBracket(i + 1);
				
				retVal.append(getCombined(numberOfTimesRepeat, getString(i + 1, getEndOfBrackert - 1)));
				
				i = getEndOfBrackert - 1;	
				
				numberOfTimesRepeat = 0;
			}
			else
			if(globalStr.charAt(i) >= '0' && globalStr.charAt(i) <= '9')
			{
				numberOfTimesRepeat = (numberOfTimesRepeat * 10) + globalStr.charAt(i) - '0';
			}
			else
			if(globalStr.charAt(i) != ']')
			{
				retVal.append(globalStr.charAt(i));
			}
		}
		
		return retVal.toString();
	}

	private String getCombined(int numberOfTimesRepeat, String string)
	{
		StringBuffer ret = new StringBuffer();
		
		for(int i = 0; i < numberOfTimesRepeat; ++i)
		{
			ret.append(new String(string));
		}
		
		return ret.toString();
	}

	private int endOfBracket(int i) 
	{
		int openBracketCount = 0;
		
		for(int pos = i; pos < globalStr.length(); ++pos)
		{
			if(globalStr.charAt(pos) == ']' && openBracketCount == 0)
			{
				return pos;
			}
			else
			if(globalStr.charAt(pos) == ']')
			{
				--openBracketCount;
			}
			else
			if(globalStr.charAt(pos) == '[')
			{
				++openBracketCount;
			}
		}
		
		return -1;
	}

	public static void main(String[] args)
	{
			System.out.println(new DecodeString().decodeString("sd2[f2[e]g]i"));
	}
}
