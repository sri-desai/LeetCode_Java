import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicates	
{
	public List<Integer> findDuplicates(int[] nums) 
	{
		List<Integer> retList = new ArrayList<>();
		
		for(int i = 0; i < nums.length; ++i)
		{
			while(nums[i] != nums[nums[i] - 1])
			{
				int targetIdx = nums[i] - 1;
				int temp = nums[i];
				nums[i]  = nums[targetIdx];
				nums[targetIdx] = temp;				
			}
		}
		
		for(int i = 0; i < nums.length; ++i)
		{
			if(nums[i] != i + 1) retList.add(nums[i]);
		}
		
		return retList;
    }
	
	public static void main(String[] args)
	{
		int[] array = {4,3,2,7,8,2,3,1};
		
		System.out.println(new FindAllDuplicates().findDuplicates(array));
	}
}
