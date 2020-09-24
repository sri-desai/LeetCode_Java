import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Permutation2 
{
	HashSet<Integer> insertedValue;
	
	public List<List<Integer>> permute(int[] nums) 
	{
        List<List<Integer>> mainList = new ArrayList<>();
        List<Integer> subList = new ArrayList<>();
        
        insertedValue = new HashSet<>();
        
        getElements(nums, subList, mainList);    
        
        return mainList;
    }

	private void getElements(int[] nums, List<Integer> subList, List<List<Integer>> mainList) 
	{
		if(subList.size() == nums.length)
		{
			mainList.add(new ArrayList<>(subList));
			
			return;
		}
		else
		{
			for(int i = 0; i < nums.length; ++i)
			{
				if(!insertedValue.contains(nums[i]))
				{
					subList.add(nums[i]);
					
					insertedValue.add(nums[i]);
					
					getElements(nums, subList, mainList);
					
					subList.remove(subList.size() - 1);
					
					insertedValue.remove(nums[i]);
				}
			}
		}
	}
	
	public static void main(String[] args)
	{
		int[] array = {1, 2, 3};
		
		System.out.println(new Permutation2().permute(array));
	}
}
