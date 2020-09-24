import java.util.Arrays;

public class WiggleSort 
{
	public void wiggleSort(int[] nums) 
	{
		if(nums == null || nums.length <= 2)
		{
			return;
		}
		
		Arrays.sort(nums);
		
		int nextLocation = (int) Math.ceil(nums.length / 2.0);
		int nextEnd = nextLocation;
		int index   = 0;
		
		int[] resArray = new int[nums.length];
		int i;
		
		for( i = 0; i <= nextEnd && nextLocation < nums.length; ++i)
		{
			resArray[index++] = nums[i];
			resArray[index++] = nums[nextLocation++];
		}
		
		while(i < nextEnd)
		{
			resArray[index++] = nums[i++];
		}	
		
		for( i = 0; i < nums.length; ++i)
		{
			nums[i] = resArray[i];
		}
    }
	
	public static void main(String[] args)
	{
		WiggleSort obj = new WiggleSort();
		int[] array = {1, 2};
		
		obj.wiggleSort(array);
		
		System.out.println(array);
		
	}
}
