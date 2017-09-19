import java.util.ArrayList;
import java.util.Collections;

public class CountingSort
{
	public void sortColors(int[] nums) 
	{
		int[] colorsCount = new int[3];
		
		if(nums == null || nums.length == 0)
		{
			return;
		}
		
		for(int i = 0; i < nums.length; ++i)
		{
			++colorsCount[nums[i]];
		}
		
		int startLoc = 0;
		
		for(int i = 0; i < nums.length && startLoc < colorsCount.length; ++i)
		{
			if(colorsCount[startLoc]-- != 0)
			{
				nums[i] = startLoc;
			}
			else
			{
				++startLoc;
				
				--i;
			}
		}
    }
	
	public static void main(String[] args)
	{
		int[] array = {2, 0, 1};
		
		new CountingSort().sortColors(array);
		
		for(int num : array)
		{
			System.out.println(num);
		}
	}
	
}
