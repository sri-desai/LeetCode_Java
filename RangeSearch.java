import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RangeSearch 
{
	int[] array;
	List<Integer> result;
	
	public int[] searchRange(int[] nums, int target) 
	{
		int[] retVal = {-1, -1};
		
        if(nums == null)
        {        	
        	return retVal; 
        }
        
        array = nums;
        result = new ArrayList<>();
        
        generateElements(0, nums.length - 1, target);
        
        if(result.size() == 0)
        {
        	return retVal;
        }
        
        Collections.sort(result);
        
        retVal[0] = result.get(0);
        retVal[1] = result.get(result.size() - 1);
        
        return retVal;     
    }

	private void generateElements(int low, int high, int value) 
	{
		if(low > high)
		{
			return;
		}
		else
		if(array[low] == value && array[high] == value)
		{
			result.add(low);
			result.add(high);
			
			return;
		}
		
		int mid = (low + high) / 2;
		
		if(array[mid] > value)
		{
			generateElements(low, mid - 1, value);
		}
		else
		if(array[mid] < value)
		{
			generateElements(mid + 1, high, value);
		}
		else
		{
			result.add(mid);
			
			generateElements(low, mid - 1, value);
			
			generateElements(mid + 1, high, value);
		}
				
	}
	
	public static void main(String[] args)
	{
		int[] array = {5, 7, 8, 8, 8, 10};
		
		
		for(int output : new RangeSearch().searchRange(array, 8))
		{
			System.out.println(output);
		}
	}
}
