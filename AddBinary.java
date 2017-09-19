
public class AddBinary 
{
	boolean isCarry = false;
	
	public String addBinary(String first, String second) 
	{
		StringBuffer sbuff = new StringBuffer();
		
		String a = first.length() > second.length() ? first : second;
		String b = a == first ? second : first;
		
						
		/* consider a's length will be same or more than b's length */
		for(int i = 0; i < Math.max(a.length(), b.length()); ++i)
		{
			if(a.length() - i - 1 >= 0 && b.length() - i - 1 >= 0)
			{
				sbuff.append(twoBitsAdd(a.charAt(a.length() - i - 1), b.charAt(b.length() - i - 1), isCarry));
			}
			else
			{
				sbuff.append(twoBitsAdd(a.charAt(a.length() - i - 1), '0', isCarry));
			}
		}
		
		if(isCarry) sbuff.append(1);
		
		return sbuff.reverse().toString();
		
		
    }
	
	private char twoBitsAdd(char first, char second, boolean prevCarry)
	{		
		if(first == '1' && second == '1')
		{			
			isCarry = true;
			
			return prevCarry ? '1' : '0';
		}
		else
		if(first == '1' || second == '1')
		{
			return prevCarry ? twoBitsAdd('1', '1', false) : '1';
		}
		else
		{
			if(prevCarry)
			{
				isCarry = false;
				
				return '1';
			}
			else
			{
				return '0';
			}
		}
	}
	
	public static void main(String[] args)
	{
		System.out.println(new AddBinary().addBinary("1010", "1011"));
	}
}
