
public class MultiplyStrings
{
	public String multiply(String num1, String num2)
	{
		if(num1.trim().length() == 0 || num2.trim().length() == 0) return "";
		if(num1.trim().equals("0")   || num2.trim().equals("0"))   return "0";
		
		StringBuffer retResult = new StringBuffer();
		
		String topString    = num1.length() > num2.length() ? num1 : num2;
		String bottomString = topString == num1 ? num2 : num1;
		retResult = null;
		
		for(int i = bottomString.length() - 1; i >= 0; --i)
		{
			int j;
			int carry  = 0;
			StringBuffer tempResult = new StringBuffer();
			
			for(j = topString.length() - 1; j >= 0; --j)
			{
				int result = (bottomString.charAt(i) - '0') * (topString.charAt(j) - '0');
				tempResult.insert(0, (result + carry) % 10);
				
				carry = (result + carry) / 10;
			}
			
			if(carry != 0) tempResult.insert(0, carry);
			
			retResult = addSum(retResult, tempResult, (bottomString.length() - 1) - i);
		}
		
		return retResult.toString();
		
    }

	private StringBuffer addSum(StringBuffer retResult, StringBuffer tempResult, int pos) 
	{
		if(retResult == null) return tempResult;
		StringBuffer result = new StringBuffer();
		
		int carry = 0;
		
		for(int i = retResult.length() - 1; i > retResult.length() - 1 - pos; --i)
		{
			result.insert(0, retResult.charAt(i));
		}
		
		for(int i = tempResult.length() - 1, j = retResult.length() - 1 - pos; i >= 0; --i, --j)
		{
			int sum;
			
			if(j >= 0) sum = carry + tempResult.charAt(i) - '0' + retResult.charAt(j) - '0';
			else       sum = carry + tempResult.charAt(i) - '0';
			
			result.insert(0, sum % 10);
			
			carry = sum / 10;
		}
		
		if(carry != 0) result.insert(0, carry);
		
		return result;
	}

	public static void main(String[] args)
	{
		System.out.println(new MultiplyStrings().multiply("20", "10000000000000000000000000"));
	}
}
