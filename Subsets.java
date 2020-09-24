import java.util.ArrayList;
import java.util.List;

public class Subsets 
{
	public List<List<Integer>> subsets(int[] nums) 
	{
		List<List<Integer>> mainList = new ArrayList<>();
		
		mainList.add(new ArrayList<>());
		
		ArrayList<Integer> subList = new ArrayList<>();
		
		if(nums == null)
		{
			return mainList;
		}
		else
		if(nums.length == 0)
		{					
			return mainList;					
		}
		
		for(int i = 1; i < (int)Math.pow(2, nums.length); ++i)
		{
			for(int bitCount = 0; bitCount < nums.length; ++bitCount)
			{
				if((i & (1 << bitCount)) > 0)
				{
					subList.add(nums[bitCount]);
				}
								
			}
			
			mainList.add(subList);
			
			subList = new ArrayList<>();
		}
		
		return mainList;
    }
	
	public static void main (String[] args)
	{
		int[] array = {1,2,3};
				
		System.out.println(new Subsets().subsets(array));
	}
}
