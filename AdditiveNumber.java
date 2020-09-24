import java.util.ArrayList;
import java.util.List;
import java.util.zip.Checksum;

/* Not correct */
public class AdditiveNumber 
{
	public boolean isAdditiveNumber(String num) 
	{
		if(num == null || num.trim().length() < 3) return false;
		
		List<String> numList = new ArrayList<>();
		
		return checkValidity(0, num.trim(), numList);
    }      

	private boolean checkValidity(int startPos, String num, List<String> numList)
	{
		if(startPos >= num.length())
		{
			if(numList.size() < 3) return false;
			if(checksum( numList.get(numList.size() - 3), 
					          numList.get(numList.size() - 2),
					          numList.get(numList.size() - 1)
					        ) != 0) return false;
			return true;	 		
		}
		
		boolean isValid = false;
		
		if(numList.size() < 2)
		{
			for(int i = startPos; i < num.length() && !isValid; ++i)
			{
				String curNumStr = num.substring(startPos, i + 1);
				
				if(!isStringValid(curNumStr)) continue;
				
				numList.add(curNumStr);
				
				isValid |= checkValidity(i + 1, num, numList);
				
				numList.remove(numList.size() - 1);
			}			
		}
		else
		{
			String firstNumStr = numList.get(numList.size() - 2);
			String secNumStr   = numList.get(numList.size() - 1);
			
			for(int i = startPos; i < num.length() && !isValid; ++i)
			{
				String curNumStr = num.substring(startPos, i + 1);
				
				if(!isStringValid(curNumStr)) continue;			
				
				if(checksum(firstNumStr, secNumStr, curNumStr) > 0) continue;
				else if(checksum(firstNumStr, secNumStr, curNumStr) < 0) return false;
				else
				{
					numList.add(curNumStr);
					
					isValid |= checkValidity(i + 1, num, numList);
					
					numList.remove(numList.size() - 1);
				}							
			}			
		}
		
		return isValid;
	}


	private int checksum(String firstNumStr, String secNumStr, String curNumStr)
	{
		int retVal = 0;
		int sum    = 0;
		int carry  = 0;
		
		int maxLen = Math.max(firstNumStr.length(), Math.max(secNumStr.length(), curNumStr.length())) - 1;
		
		for(int i = maxLen; i >= 0; --i)
		{
			int firstNum = firstNumStr.length() > maxLen - i ? firstNumStr.charAt(maxLen - i) - '0' : 0;
			int secNum   = secNumStr.length()   > maxLen - i ? secNumStr.charAt(maxLen - i)   - '0' : 0;
									
		}
		
		return 0;
	}

	private boolean isStringValid(String str)
	{
		return str != null && str.length() != 0 && str.charAt(0) != '0';
	}
	public static void main(String[] args)
	{
		System.out.println(new AdditiveNumber().isAdditiveNumber("12012122436"));
	}
}
