import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class NextGreaterElement 
{
	public int nextGreaterElement(int n) 
	{
		if(n >= 0 && n <= 9) return -1;
		
		int[] array = Integer.toString(n).chars().map(c -> c -= '0').toArray();	
		
		if(isSorted(array, false)) return -1;
		if(isSorted(array, true))  
		{
			int temp = array[array.length - 2];
			array[array.length - 2] = array[array.length - 1];
			array[array.length - 1] = temp; 			
		}
		else
		{
			for(int pos = array.length - 2; pos >= 0; --pos)
			{
				if(array[pos] < array[pos + 1])
				{
					int temp = array[pos + 1];
					array[pos + 1] = array[pos];
					array[pos] = temp; 
					
					break;
				}
			}
		}
		
		try {
			return Integer.parseInt(Arrays.toString(array).replaceAll("\\D+",""));
			
		} catch (Exception e) 
		{
			return -1;
		}
		
		
		
    }
	private boolean isSorted(int[] array, boolean ascending) 
	{
		boolean isSorted = true;
		
		for(int i = 1; i < array.length && isSorted; ++i)
		{
			if(ascending  && array[i - 1] > array[i]) isSorted = false;
			if(!ascending && array[i - 1] < array[i]) isSorted = false;
		}
		
		return isSorted;
	}
	public static void main(String[] args)
	{
		System.out.println(new NextGreaterElement().nextGreaterElement(2147483647));
	}
}
