
public class MaxOneSequence 
{
	public int getOneSequence (int num)
	{
		int maxLength = 0;
		int firstHalf = 0;
		int secHalf   = 0;
		boolean isSwitchDone = false;
		
		if(~num == 0)
		{
			maxLength = Integer.BYTES * 8;
			
			return maxLength;
		}
		
		int count = 0;
		
		while(count++ < 32)
		{
			if((num & 1) == 1 && !isSwitchDone)
			{
				++firstHalf;
			}
			else
			if((num & 1) == 1)
			{
				++secHalf;
			}
			else
			if((num & 1) == 0 && !isSwitchDone)
			{
				++secHalf;
				
				isSwitchDone = true;
			}
			else
			if((num & 1) == 0)
			{						
				firstHalf = secHalf - 1;
				
				secHalf = 0;
			}
			
			maxLength = Math.max(maxLength, firstHalf + secHalf);
			
			num = num >> 1;
		}
		
		return maxLength;
	}
	
	public static void main(String args[])
	{
		System.out.println(new MaxOneSequence().getOneSequence(4));
	}
}
