
public class ReverseInteger
{
	public int reverse(int x)
	{
		boolean isNegative = x < 0 ? true : false;
		long result = 0;
		
		if(isNegative)
		{
			if(x == Integer.MIN_VALUE)
			{
				return 0;
			}
			
			x *= -1;
		}
		
		while(x > 0)
		{
			result = (result * 10) + (x % 10);
			
			x /= 10;
		}
		
		if(result > Integer.MAX_VALUE)
		{
			return 0;
		}
		
		return (int) (isNegative ? result * -1 : result);		
	}
	
	public static void main(String[] args)
	{
		new ReverseInteger().reverse(1534236469);
	}
}
