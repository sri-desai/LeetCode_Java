
public class RotateFunction
{
	public int maxRotateFunction(int[] A) 
	{
		if(A == null || A.length == 0) return 0;
		
		long sum     = 0;
		
		long prevSum = 0;
		
		for(int i = 0; i < A.length; ++i)
		{
			sum += A[i];
			prevSum += i * A[i];
		}
		
		long maxSum  = prevSum;
		
		for(int i = 1; i < A.length; ++i)
		{
			long curSum = prevSum + sum - A.length * A[A.length - i];
			
			if(curSum > maxSum) maxSum = curSum;
			
			prevSum = curSum;
		}
				
		return (int)maxSum;
    }
	
	public static void main(String[] args)
	{
		int[] elem = {1,2,3,4,5,6,7,8,9,10};
		
		System.out.println(new RotateFunction().maxRotateFunction(elem));
	}
}
