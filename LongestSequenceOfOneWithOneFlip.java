
public class LongestSequenceOfOneWithOneFlip 
{
	public int getMaxSequenceOfOnes (int num)
	{
		int curCount  = 0;
		int prevCount = 0;
		int maxCount  = 0;
		
		if(~num == 0)
			return 8 * Integer.BYTES;
		
		while(num > 0)
		{
			if((num & 1) == 1)
			{
				++curCount;
			}
			else
			{
				prevCount = (num & 2) == 0 ? 0 : curCount;
			
				curCount = 0;
			}
			
			maxCount = Math.max(prevCount + curCount + 1, maxCount);
			
			num >>= 1;
		}
		
		return maxCount;
	}
	
	public static void main(String[] args)
	{
		System.out.println(new LongestSequenceOfOneWithOneFlip().getMaxSequenceOfOnes(0xFFFFFFFF));
	}
}
