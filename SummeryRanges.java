import java.util.ArrayList;
import java.util.List;

public class SummeryRanges 
{
	public List<String> summaryRanges(int[] nums) 
	{
		List<String> list = new ArrayList<>();
		
		if(nums == null || nums.length == 0)
		{
			return list;
		}
		else
		if(nums.length == 1)
		{
			list.add(Integer.toString(nums[0]));
			
			return list;
		}
		
		long prevBeginning = nums[0];
		
		for(int i = 1; i < nums.length; ++i)
		{
			long prevNumber = nums[i - 1];
			long curNumber  = nums[i];
			
			if(prevNumber + 1 != curNumber)
			{
				if(prevBeginning != prevNumber)
					list.add(Long.toString(prevBeginning) + "->" + Long.toString(prevNumber));
				else
					list.add(Long.toString(prevBeginning));
				
				prevBeginning = curNumber;
			}
			
			if(i == nums.length - 1 && prevBeginning == curNumber)
			{
				list.add(Long.toString(prevBeginning));
			}
			else
			if(i == nums.length - 1 && prevBeginning != curNumber)
			{
				list.add(Long.toString(prevBeginning) + "->" + Long.toString(curNumber));
			}
			else
			{
				;
			}
			
			
		}			
		return list;
	}
	
	public static void main(String[] args)
	{
		SummeryRanges obj = new SummeryRanges();
		int[] array = {0,1,2,4,5,7};
		
		System.out.println(obj.summaryRanges(array));
		
	}
}
