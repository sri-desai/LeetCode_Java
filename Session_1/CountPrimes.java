import java.util.Arrays;

public class CountPrimes
{
	public int countPrimes(int n) 
	{
		int count = 0;
		boolean[] elements = new boolean[n + 1];
		
		Arrays.fill(elements, true);
		
		for(int i = 2; i <= (int)Math.sqrt(n); ++i)
		{
			if(!elements[i]) continue;
			
			setToFalse(i, elements);
		}
		
		for(int i = 2; i < n; ++i)
		{
			if(elements[i]) ++count;
		}
		
		return count;
    }

	private void setToFalse(int number, boolean[] elements) 
	{
		for(int i = 2 * number; i < elements.length; i += number)
		{
			elements[i] = false;
		}
	}
	
	public static void main(String[] args)
	{
		System.out.println(new CountPrimes().countPrimes(10));
	}
}
