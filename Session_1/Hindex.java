import java.util.Arrays;

public class Hindex 
{
	public int hIndex(int[] citations) 
	{
		if(citations == null)
		{
			return 0;
		}
		
		int hIndex = 0;
		Arrays.sort(citations);
		
		for(int i = 0; i < citations.length; ++i)
		{
			if(citations.length - i > citations[i])
			{
				++hIndex;
			}
		}
		
		return citations.length - hIndex;
	}
}
