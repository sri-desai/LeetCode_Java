
public class IntegerReplacement 
{
	public int integerReplacement(int n) 
	{
		long number = n;
		boolean isDone = false;
		int steps = 0;
		
		if(n == 1)
		{
			return 0;
		}
		else
		if(n == 0)
		{
			return 1;
		}
		
		while(!isDone)
		{
			if((number & 1) == 0)
			{
				number /= 2;
				
				++steps;							
			}
			else
			{
				number -= 1;
				
				++steps;
				
			}
			
			if(number == 1)
			{
				isDone = true;
			}
		}
		
		return steps;
		
    }
}
