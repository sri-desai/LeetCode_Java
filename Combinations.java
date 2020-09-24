import java.util.ArrayList;
import java.util.List;

public class Combinations 
{
	public List<List<Integer>> combine(int n, int k) 
	{
		List<List<Integer>> mainList = new ArrayList<>();
		List<Integer> subList = new ArrayList<>();
		if(n < k || k == 0)
		{
			return mainList;
		}
		
		getElements(1, n, k, mainList, subList);	
		
		return mainList;
    }

	private void getElements(int startPos, int n, int k, List<List<Integer>> mainList, List<Integer> subList) 
	{
		if(k == 0)
		{
			mainList.add(new ArrayList<>(subList));
		}
		else
		{
			for(int i = startPos; i <= n; ++i)
			{
				subList.add(i);
				getElements(i + 1, n, k - 1, mainList, subList);
				subList.remove(subList.size() - 1);
			}
		}		
	}
	
	public static void main(String[] args)
	{
		System.out.println(new Combinations().combine(20, 16));
	}
}
