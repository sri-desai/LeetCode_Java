import java.util.ArrayList;
import java.util.List;

public class MissingRanges 
{
	public List<String> findMissingRanges(int[] nums, int lower, int upper) 
	{
        List<String> missingRangeList = new ArrayList<>();
        
        /* to include lower as part of the result string */
        long prevNum = (long)lower - 1;
        
        for(int curNum : nums)
        {
        	populateRangesToList(prevNum, (long)curNum, missingRangeList);
        	
        	prevNum = curNum;
        }
        
        /* to include upper as part of the string */
        populateRangesToList(prevNum, (long)upper + 1, missingRangeList);
        
        return missingRangeList;
    }

	private void populateRangesToList(long prevNum, long curNum, List<String> missingRangeList)
	{		
		if(prevNum == curNum || prevNum + 1 == curNum) return;
		
		StringBuffer curMissingRange = new StringBuffer();
		
		if(prevNum + 1 == curNum - 1)
		{
			curMissingRange.append(Long.toString(prevNum + 1));
		}
		else
		{
			curMissingRange.append(Long.toString(prevNum + 1) + "->" + 
								   Long.toString(curNum - 1));
		}
		
		missingRangeList.add(curMissingRange.toString());
	}
	
	public static void main(String[] args)
	{
		int[] rangeArray = {2147483647};
		
		System.out.println(new MissingRanges().findMissingRanges(rangeArray, -2147483648, 2147483647));
	}
}
