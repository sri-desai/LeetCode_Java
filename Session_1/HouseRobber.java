
public class HouseRobber
{
	public int rob(int[] nums) 
	{
		if(nums.length == 0) return 0;
		if(nums.length == 1) return nums[0];
		if(nums.length == 2) return Math.max(nums[0], nums[1]); 
		
		int[] houseIncome = new int[nums.length];
		
		houseIncome[0] = nums[0];
		houseIncome[1] = Math.max(nums[0], nums[1]);
		
		for(int i = 2; i < nums.length; ++i)
		{
			houseIncome[i] = Math.max(nums[i] + houseIncome[i - 2], houseIncome[i - 1]);
		}
		
		return houseIncome[houseIncome.length - 1];
    }
}
