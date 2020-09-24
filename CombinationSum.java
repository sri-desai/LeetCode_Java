import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum 
{
	List<List<Integer>> mainList;
	
	public List<List<Integer>> combinationSum2(int[] candidates, int target) 
	{
		mainList = new ArrayList<>();
		
		if(candidates == null)
		{
			return mainList;
		}
		
		Arrays.sort(candidates);
		
		List<Integer> subList = new ArrayList<>();
		
		getCombination(candidates, target, subList, 0);
		
		return mainList;
    }

	private void getCombination(int[] candidates, int target, List<Integer> subList, int startPoint)
	{
		if(target == 0)
		{
			mainList.add(new ArrayList<>(subList));
			
			return;
		}
		else
		if(target < 0)
		{
			return;
		}
		else
		{
			for(int i = startPoint; i < candidates.length; ++i)
			{
				if(i > startPoint && candidates[i] == candidates[i - 1])
				{
					;
				}
				else
				{
					subList.add(candidates[i]);
					getCombination(candidates, target - candidates[i], subList, i + 1);
					subList.remove(subList.size() - 1);					
				}							
			}
		}
		
	}
	
	public static void main(String[] args)
	{
		int[] array = {1, 1, 2, 5};
		
		System.out.println(new CombinationSum().combinationSum2(array, 2));
	}
}
