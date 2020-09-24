import java.util.Arrays;

public class ArrayPartition 
{
	 public int arrayPairSum(int[] nums) 
	 {
		 Arrays.sort(nums);
		 
		 int maxSum = 0;
		 
		 for(int i = 0; i < nums.length - 1; i += 2)
		 {
			 maxSum += nums[i];   
	     }
		 
		 return maxSum;
	 }
	 
	 public static void main(String[] args)
	 {
		 int[] array = {1,4,3,2};
		 
		 System.out.println(new ArrayPartition().arrayPairSum(array));
	 }
}
