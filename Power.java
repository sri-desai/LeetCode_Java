
public class Power 
{
	public double myPow(double x, int n) 
	{
		boolean isNNeg = false;
		long nVal = n;
		
		if(x == 0.0)
		{
			return 0;
		}
		else
		if(nVal == 0 || x == 1)
		{
			return 1;
		}
		else
		if(nVal == 1)
		{
			return x;
		}
		else
		if(nVal < 0)
		{
			nVal *= -1;	
			
			isNNeg = true;
		}
		
		double temp = myPow(x, (int) (nVal/2));
		
		temp *= temp;
		
		if((nVal & 1) == 0)
		{
			if(isNNeg)
				return 1 / temp;
			else
				return temp;
		}
		else
		{
			if(isNNeg)
				return 1 / (x * temp);
			else
				return x * temp;
		}				
    }
	
	public static void main(String[] args)
	{
		Power obj = new Power();
		
		System.out.println(obj.myPow(2.0, -2147483648));
	}
}
