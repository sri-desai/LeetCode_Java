public class ProductofArrayExceptSelf 
{
	public int[] productExceptSelf(int[] nums) 
	{
		int   prevProduct = 1; 
		int[] output = new int[nums.length];		
		
		output[0] = prevProduct;
		
		prevProduct = nums[0];
		
		for(int i = 1; i < nums.length; ++i)
		{
			output[i]    = prevProduct;
			prevProduct *= nums[i]; 
		}
		
		prevProduct = nums[output.length - 1];
		
		for(int i = output.length - 2; i >= 0; --i)
		{
			output[i]   *= prevProduct;
			prevProduct *= nums[i];
			
		}		
		return output;
    }
	
	public static void main (String[] args)
	{
		int[] array = {1, 2, 3, 4};
		
		new ProductofArrayExceptSelf().productExceptSelf(array);
	}
}
