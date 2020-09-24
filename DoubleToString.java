
public class DoubleToString 
{
	public String convertToString(double number)
	{
		StringBuffer sbuffer = new StringBuffer();
		
		sbuffer.append("0.");
		
		while(sbuffer.length() <= 32 && number != 0.0)
		{
			int intNum = (int)(number * 10.0);
			
			sbuffer.append(Integer.toString(intNum));
			
			number = (number * 10.0) - (intNum * 1.0);
		}
		
		return sbuffer.toString();
	}
	
	public String convertToBinary (double number)
	{
		StringBuffer sbuffer = new StringBuffer();
		
		if(number <= 0 || number >= 1)
		{
			return "ERROR";
		}
		
		sbuffer.append("0.");
		
		while(number > 0)
		{
			double r = number * 2;			
			
			if(r >= 1)
			{
				sbuffer.append("1");
				
				number = r - 1;
			}
			else
			{
				sbuffer.append("0");
				
				number = r;
			}
			
			if(sbuffer.length() > 32)
			{
				return "ERROR";
			}
		}
		
		return sbuffer.toString();
	}
	
	public static void main(String[] args)
	{
		System.out.println(new DoubleToString().convertToBinary(0.75));
	}
}
