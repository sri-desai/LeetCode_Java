import java.util.ArrayList;
import java.util.List;

public class validNumber 
{
	public List<Integer> getValidArray (int[] nums)
	{
		List<Integer> list = new ArrayList<>();
		
		int lastValidIdx = -1;
		
		boolean isValid = true;
		
		list.add(nums[0]);
		
		if(nums[0] != 0) lastValidIdx = 0;
		
		for(int i = 1; i < nums.length; ++i)
		{
			if(nums[i] == 0)
			{
				list.add(0);
			}
			else
			if(lastValidIdx >= 0 && nums[i] == list.get(lastValidIdx) && isValid)
			{
				int num = list.get(lastValidIdx);
				
				list.remove(lastValidIdx);
				
				list.add(lastValidIdx, num * 2);
				
				isValid = false;
			}
			else
			{				
				list.add(++lastValidIdx, nums[i]);
				
				isValid = true;
			}
		}
		
		return list;
	}
	
	public static void main(String[] args)
	{
		int[] nums = {2, 4, 5, 0, 0, 5};
		
		new validNumber().getValidArray(nums);
	}
}
