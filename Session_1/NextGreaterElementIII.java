import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class NextGreaterElementIII 
{
	public int nextGreaterElement(int n) 
	{
		if(n == 0) return -1;
		
		char[] number = Integer.toString(n).toCharArray();
		TreeMap<Integer, Integer> posMap = new TreeMap<>();
		
		if(isDescending(number)) return -1;
		
		for(int i = number.length - 1; i >= 0; --i)
		{
			Integer prevGreaterKey = posMap.higherKey(number[i] - '0');
			
			if(prevGreaterKey != null)
			{
				char temp = number[posMap.get(prevGreaterKey)];
				number[posMap.get(prevGreaterKey)] = number[i];
				number[i] = temp;
				
				Arrays.sort(number, i + 1, number.length);
				
				break;
			}
			posMap.put(number[i] - '0', i);
		}
		
		long result = Long.parseLong(new String(number));
		
		return result > Integer.MAX_VALUE ? -1 : (int)result;
    }

	private boolean isDescending(char[] number) 
	{
		for(int i = 1; i < number.length; ++i)
		{
			if(number[i] > number[i - 1]) return false;
		}
		
		return true;
	}
	
	public static void main(String[] args)
	{
		System.out.println(new NextGreaterElementIII().nextGreaterElement(12443322));
	}
}
