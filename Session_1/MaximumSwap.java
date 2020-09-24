import java.util.HashMap;

public class MaximumSwap
{
	public int maximumSwap(int num) 
	{
		if(num == 0) return 0;
		
		char[] curNumber = Integer.toString(num).toCharArray();
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i < curNumber.length; ++i)
		{
			map.put(curNumber[i] - '0', i);
		}
		
		for(int i = 0; i < curNumber.length; ++i)
		{
			for(int k = 9; k > curNumber[i] - '0'; --k)
			{
				if(map.containsKey(k) && map.get(k) > i)
				{
					int endIdx = map.get(k);
					char temp   = curNumber[endIdx];
					
					curNumber[endIdx] = curNumber[i];
					curNumber[i]      = temp;
					
					return Integer.valueOf(new String(curNumber));
				}
			}
		}
		
		return num;
    }
	
	public static void main(String[] args)
	{
		System.out.println(new MaximumSwap().maximumSwap(2736));
	}
}
