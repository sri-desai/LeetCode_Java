import java.util.ArrayList;
import java.util.List;

public class PascalTriangle
{
	public List<List<Integer>> generate(int numRows) 
	{
		List<List<Integer>> returnList = new ArrayList();
		
		if(numRows == 0) return returnList;
		
		List<Integer> subList = new ArrayList<>();
		
		subList.add(1);
		
		returnList.add(subList);
		
		if(numRows == 1) return returnList;
		
		subList = new ArrayList<>();
		
		subList.add(1);
		
		subList.add(1);
		
		returnList.add(subList);
		
		if(numRows == 2) return returnList;
		
		for(int row = 3; row <= numRows; ++row)
		{
			subList = new ArrayList<>();
			List<Integer> prevList = returnList.get((row - 1) - 1);
			
			subList.add(prevList.get(0));
			subList.add(1, prevList.get(prevList.size() - 1));
			
			for(int i = 1; i < prevList.size(); ++i)
			{
				subList.add(1, prevList.get(i) + prevList.get(i - 1));
			}
			
			returnList.add(subList);
		}
		
		return returnList;
		
    }

	public static void main(String[] args)
	{
		System.out.println(new PascalTriangle().generate(5));
	}
}
