import java.util.List;

public class HouseRob 
{
	public int rob(int[] nums) 
	{
		if(nums == null || nums.length == 0)
		{
			return 0;
		}
		else
		if(nums.length == 1)
		{
			return nums[0];
		}
		
		return Math.max(robber(nums, 0, nums.length - 2), robber(nums, 1, nums.length - 1));
    }

	private int robber(int[] nums, int start, int end) 
	{		
		if(start == end)
		{
			return nums[start];
		}
		
		int firstHouse  = nums[start];
		int secondHouse = Math.max(nums[start + 1], firstHouse);
		int cur = 0;
				
		for(int i = start + 2; i <= end; ++i)
		{
			cur = Math.max(firstHouse + nums[i], secondHouse);
			
			firstHouse = secondHouse;
			secondHouse = cur;
		}
		
		return cur == 0 ? Math.max(firstHouse, secondHouse) : cur;
	}
	
	public static void main(String[] args)
	{
		int[] arr = {1, 3, 1, 3, 100};
		
		new HouseRob().rob(arr);
	}
}
