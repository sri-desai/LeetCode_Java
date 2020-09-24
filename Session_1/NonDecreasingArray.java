
public class NonDecreasingArray 
{
	public boolean checkPossibility(int[] nums) 
    {
         int count = 0;
         
         for(int pos = 0; pos < nums.length - 1; ++pos)
         {
        	 if(nums[pos] > nums[pos + 1])
        	 {
        		 ++count;
        		 
        		 if(pos > 0 && nums[pos + 1] < nums[pos - 1]) nums[pos + 1] = nums[pos];
            	 else nums[pos] = nums[pos + 1];
        	 }
        	 
        	 
         }
         
         return count <= 1;
    }
	
	public static void main(String[] args)
	{
		int[] array = {3, 4, 2, 3};
		
		System.out.println(new NonDecreasingArray().checkPossibility(array));
	}
}
