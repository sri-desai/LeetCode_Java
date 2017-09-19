import java.util.HashMap;

public class FractiontoRecurringDecimal 
{
	public String fractionToDecimal(int numerator1, int denominator1) 
	{
		StringBuffer result = new StringBuffer();
		
		HashMap<Long, Integer> map = new HashMap<>();
		
		if(numerator1 == 0) return Integer.toString(0);
		result.append(numerator1 < 0 ^ denominator1 < 0 ? "-" : "");
		
		long numerator   = Math.abs((long)numerator1);
		long denominator = Math.abs((long)denominator1);
		
		result.append(numerator / denominator);
		
		numerator %= denominator;
		
		if(numerator > 0) result.append(".");
		else			  return result.toString();
		
		map.put(numerator, result.length());	
		
		while(numerator != 0)
		{
			numerator *= 10;	
			
			if(map.containsKey(numerator))
			{
				result.insert(map.get(numerator), "(");
				
				result.append(")");
				
				break;
			}			
					
			long resNumber = numerator / denominator;
						
			map.put(numerator, result.length());	
			
			result.append(resNumber);				
			
			numerator %= denominator;
			
			
		}
		
		return result.toString();
    }
	
	public static void main(String[] args)
	{
		System.out.println(new FractiontoRecurringDecimal().fractionToDecimal(1, 6));
	}
}
