
public class RemoveElement
{
	public int removeElement(int[] nums, int val) 
	{
		int count = 0;
		
		for(int num : nums)
		{
			if(num != val)
			{
				nums[count++] = num;
			}
		}
		
		return count;
    }
	
	public static void main(String[] args)
	{
		int[] array = {3,2,2,3};
		
		System.out.println(new RemoveElement().removeElement(array, 3));
		
		return;
	}
}
