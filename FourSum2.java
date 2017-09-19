import java.util.HashMap;
import java.util.HashSet;

public class FourSum2 
{
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) 
	{
		int count = 0;
		HashMap<Integer, Integer> abSum = new HashMap<>();
		
		for(int i = 0; i < A.length; ++i)
		{
			for(int j = 0; j < B.length; ++j)
			{
				abSum.put(A[i]+B[j], abSum.getOrDefault(A[i]+B[j], 0) + 1);
			}
		}
		
		for(int i = 0; i < C.length; ++i)
		{
			for(int j = 0; j < D.length; ++j)
			{
				int sumToCheck = C[i] + D[j] == 0 ? 0 : -(C[i] + D[j]);
				
				count += abSum.getOrDefault(sumToCheck, 0);
			}
		}
		
		return count;
    }
	
	public static void main(String[] args)
	{
		int[] a = {1, 2};
		int[] b = {-2, -1};
		int[] c = {-1,  2};
		int[] d = {0, 2};
		
		System.out.println(new FourSum2().fourSumCount(a, b, c, d));
	}
}
