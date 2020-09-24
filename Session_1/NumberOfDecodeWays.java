import java.util.Arrays;

public class NumberOfDecodeWays 
{
	public int numDecodings(String s) 
	{
		if(s == null || s.trim().isEmpty()) return 0;
		
		int[] countMatrix = new int[s.length()];
		
		Arrays.fill(countMatrix, -1);
		
		return populateDecodeWays(s, 0, countMatrix);				
    }

	private int populateDecodeWays(String stringToProcess, int startIdx,
			                       int[] countMatrix) 
	{
		if(startIdx == stringToProcess.length()) return 1;
		if(startIdx >  stringToProcess.length()) return 0;
						
		if(countMatrix[startIdx] != -1) 
			return countMatrix[startIdx];
		
		int curCount = 0;
		
		if(stringToProcess.charAt(startIdx) == '0') return 0;
		
		for(int curIdx = startIdx; curIdx < stringToProcess.length() && curIdx < startIdx + 2; ++curIdx)
		{			
			int curNumber = Integer.parseInt(stringToProcess.substring(startIdx, curIdx + 1));
			
			if(curNumber > 0 && curNumber <= 26)
			{
				curCount += populateDecodeWays(stringToProcess, curIdx + 1, countMatrix);
			}
		}
		
		countMatrix[startIdx] = curCount;
		 
		return curCount;
	}
	
	public static void main(String[] args)
	{
		int num = new NumberOfDecodeWays().numDecodings("12");
		
		System.out.println(num);
	}
}
 