
public class StringtoInteger 
{
	public int myAtoi(String str) 
	{
		int     isPositive = -1;		
		long    retVal     = 0;
		boolean isValid    = true;
		boolean isNumberOver = false;
		
		if(str == null || str.isEmpty()) return 0;
		
		for(int i = 0; i < str.length(); ++i)
		{				
			if(retVal >= Integer.MAX_VALUE || retVal <= Integer.MIN_VALUE) break;
			
			if(str.charAt(i) == ' ')
			{
				if(isNumberOver) break;
			}
			else if(str.charAt(i) == '+')
			{
				if(isPositive > -1) isValid    = false;
				else                isPositive = 1;
				isNumberOver = true;
			}
			else if(str.charAt(i) == '-')
			{
				if(isPositive > -1) isValid    = false;
				else                isPositive = 0;
				isNumberOver = true;
			}
			else if(str.charAt(i) >= '0' && str.charAt(i) <= '9') 
			{
				retVal = retVal * 10 + str.charAt(i) - '0';
				
				isNumberOver = true;
			}			
			else break;			
		}
		
		if(!isValid) return 0;
		
		retVal = isPositive == 0 ? -retVal : retVal;
		
		return (int) (retVal >= Integer.MAX_VALUE ? Integer.MAX_VALUE : 
			          retVal <= Integer.MIN_VALUE ? Integer.MIN_VALUE : retVal);
    }
	
	public static void main(String[] args)
	{
		System.out.println(new StringtoInteger().myAtoi("9223372036854775809"));
	}
}
