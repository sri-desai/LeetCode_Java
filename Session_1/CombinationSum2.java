import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 
{
	List<List<Integer>> mainList;
	
	 public List<List<Integer>> combinationSum(int[] candidates, int target) 
	 {
		 mainList = new ArrayList<>();
		 List<Integer> subList = new ArrayList<>();
		 
		 if(candidates == null || candidates.length == 0)
		 {
			 return mainList;
		 }
		 
		 Arrays.sort(candidates);
		 
		 populateList(candidates, target, 0, subList);
		 
		 return mainList;
	 }

	private void populateList(int[] candidates, int target, int startPos, List<Integer> subList) 
	{
		for(int curPos = startPos; curPos < candidates.length; ++curPos)
		{
			if(candidates[curPos] > target)
			{
				break;
			}
			else
			if(candidates[curPos] == target)
			{
				List<Integer> finalList = new ArrayList<>(subList);
				
				finalList.add(candidates[curPos]);
				
				mainList.add(finalList);
				
				break;
			}
			else
			{
				subList.add(candidates[curPos]);
				
				populateList(candidates, target - candidates[curPos], curPos, subList);
				
				subList.remove(subList.size() - 1);
			}
		}
	}
	
	public static void main(String[] args)
	{
		int[] candidates = {2, 3, 6, 7};
		
		CombinationSum2 obj = new CombinationSum2();
		
		obj.combinationSum(candidates, 7);
		
		System.out.println(obj.mainList);
	}
}
