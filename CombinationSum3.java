import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 
{
	public List<List<Integer>> combinationSum3(int k, int n) 
	{
		List<List<Integer>> list = new ArrayList<>();
		List<Integer> subList    = new ArrayList<>();
		
		populateData(k, n, 1, subList, list);
		
		return list;
    }

	private void populateData(int numberCount, int reqSum, int startPos, 
			                  List<Integer> subList, List<List<Integer>> mainList) 
	{
		if(numberCount == 0 && reqSum == 0)
		{
			mainList.add(new ArrayList<>(subList));
			
			return;
		}
		else
		{
			for(int pos = startPos; pos <= 9; ++pos)
			{
				if(reqSum < pos)
				{
					break;
				}
				else
				{
					subList.add(pos);
					populateData(numberCount - 1, reqSum - pos, pos + 1, subList, mainList);
					subList.remove(subList.size() - 1);
				}
			}
		}
		
	}
	
	public static void main(String[] args)
	{
		System.out.println(new CombinationSum3().combinationSum3(3, 7));
	}
}
