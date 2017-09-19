import java.util.Arrays;

public class CalculateHIndex 
{
	public int hIndex(int[] citations) 
	{
		if(citations == null || citations.length == 0)
		{
			return 0;
		}
		else
		if(citations.length == 1)
		{
			return citations[0] == 0 ? 0 : 1;
		}
		
		Arrays.sort(citations);
		
		int curr = citations.length / 2;
		int prevCount = citations[curr];
		
		while(++curr < citations.length)
		{
			if(citations.length - curr >= citations[curr])
			{
				prevCount = citations[curr];
			}
			else
			{
				break;
			}
		}
		
		return prevCount;		
    }
}
