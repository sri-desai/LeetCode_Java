
public class Partition
{
	public boolean canPartitionKSubsets(int[] nums, int k) 
	{		
		if(k == 0) return false;
		
		int sum = 0;
		
		for(int num : nums) sum += num;
		
		if(sum % k != 0) return false;
		
		boolean[] visited = new boolean[nums.length];
		
		return canPartition(nums, visited, 0, 0, k, sum / k);
    }

	private boolean canPartition(int[] nums, boolean[] visited, int startPos, 
			                     int curPartitionSum, int partitionCountLeft,
			                     int targetOfEachPartition) 
	{
		
		if(partitionCountLeft == 0) return true;
		
		if(curPartitionSum == targetOfEachPartition)
		{
			return canPartition(nums, visited, 0, 0, partitionCountLeft - 1, 
					            targetOfEachPartition);
		}
		else
		if(curPartitionSum > targetOfEachPartition)
		{
			return false;
		}
		
		for(int curPos = startPos; curPos < nums.length; ++curPos)
		{
			if(!visited[curPos])
			{
				visited[curPos] = true;
				
				if(canPartition(nums, visited, curPos + 1, curPartitionSum + nums[curPos], 
						partitionCountLeft, targetOfEachPartition))
				{
					return true;
				}
				
				visited[curPos] = false;
			}
		}
		
		return false;
	}
	
	public static void main(String[] args)
	{
		int[] array = {2, 2, 4};
		
		System.out.println(new Partition().canPartitionKSubsets(array, 2));
	}
}
