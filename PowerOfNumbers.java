
public class PowerOfNumbers 
{
	public double myPow(double x, int n) 
	{		
		return getPow(x, n);	
	}
	
	public double getPow (double x, long n)
	{
		if(n == 0)
		{
			return 1;
		}
		else
		if(n < 0)
		{
			n *= -1;
			
			if((n & 1) == 1)
			{
				double temp = x;
				double prod = getPow(x, n / 2);
				
				return 1 / (temp * prod * prod);				
			}
			else
			{
				double prod = getPow(x, n / 2);
				
				return 1 / (prod * prod);								
			}
		}
		else
		{
			if((n & 1) == 1)
			{
				double temp = x;
				double prod = getPow(x, n / 2);
				
				return temp * prod * prod;				
			}
			else
			{
				double prod = getPow(x, n / 2);
				
				return prod * prod;								
			}
		}
	}
	
	public static void main(String[] args)
	{
		double num = new PowerOfNumbers().myPow(2.0, -2147483648);
		System.out.println(num);
	}
}
