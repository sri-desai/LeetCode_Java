
public class FlipBit 
{
	public int flibBit(int num)
	{
		if(~num == 0)
			return Integer.BYTES * 8;
		
		int curLength  = 0;
		int prevLength = 0;
		int maxLength  = 0;
		
		while(num != 0)
		{
			if((num & 1) == 1)
			{
				++curLength;
			}
			else
			{
				prevLength = (num & 2) == 0 ? 0 : curLength;
				
				curLength = 0;
			}
			
			maxLength = Math.max(prevLength + curLength + 1, maxLength);
			
			num >>>= 1;
		}
		
		return maxLength;		
	}

	
	public int countOneBits (int num)
	{
		int count = 0;
		
		for(int bin = num; bin != 0; bin = bin & (bin - 1))
		{
			++count;
		}
		
		return count;
	}
	
	public static void main(String[] args)
	{
		System.out.println(new FlipBit().countOneBits(14));
	}
}
