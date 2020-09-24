
public class PredicttheWinner 
{
	public boolean PredictTheWinner(int[] nums) 
	{
		return isPlayer1Winner(nums, 0, nums.length - 1) >= 0;
    }

	private int isPlayer1Winner(int[] nums, int startPos, int endPos) 
	{					
		return startPos == endPos ? nums[startPos] : 
			   Math.max(nums[startPos] - isPlayer1Winner(nums, startPos + 1, endPos), 
				        nums[endPos]   - isPlayer1Winner(nums, startPos, endPos - 1));
	}
	
	public static void main(String[] args)
	{
		int[] coins = {1, 5, 233, 7};
		
		System.out.println(new PredicttheWinner().PredictTheWinner(coins));
	}
}
