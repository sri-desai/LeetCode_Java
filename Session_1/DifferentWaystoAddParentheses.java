import java.util.ArrayList;
import java.util.List;

public class DifferentWaystoAddParentheses 
{
	public List<Integer> diffWaysToCompute(String input) 
	{
		List<Integer> result = new ArrayList<>();
		
		for(int i = 0; i < input.length(); ++i)
		{
			if(Character.isDigit(input.charAt(i))) continue;
			
			List<Integer> leftResult  = diffWaysToCompute(input.substring(0, i));
			List<Integer> rightResult = diffWaysToCompute(input.substring(i+1));
			
			for(Integer left : leftResult)
			{								
				for(Integer right : rightResult)
				{
					if(input.charAt(i) == '+')
					{
						result.add(left + right);  
					}
					else
					if(input.charAt(i) == '-')
					{
						result.add(left - right);  
					}
					else
					{
						result.add(left * right);  
					}
				}
			}
		}
		
		if(result.size() == 0)
		{
			result.add(Integer.valueOf(input));
		}
		
		return result;
    }
}
