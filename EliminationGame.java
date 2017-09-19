import java.util.ArrayList;
import java.util.List;

public class EliminationGame
{
	public int lastRemaining(int n) 
	{
		if(n < 1)
			return 0;
		else
		if(n == 1)
			return 1;
		
		int startPos = 1;
		
		List<Integer> mainList = new ArrayList<>();
		
		for(int i = 2; i <= n; i += 2)
		{
			mainList.add(i);
		}
		
		
		while(mainList.size() > 1)
		{
			List<Integer> subList = new ArrayList<>();
			
			startPos = (mainList.size() & 1)  == 1 ? 1 : 0; 
			
			for(int i = startPos; i < mainList.size(); i += 2)
			{
				subList.add(mainList.get(i));
			}
			
			mainList = subList;
		}
		
		return mainList.get(0);
    }
	
	public static void main (String[] args)
	{
		System.out.println(new EliminationGame().lastRemaining(9));
	}
}
