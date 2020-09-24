
public class MinimumSizeSubArray
{
	 public int minSubArrayLen(int s, int[] a)
	 {
		 if(a == null || a.length == 0 || s == 0) return 0;
		 
		 int minWindowLen   = Integer.MAX_VALUE;
		 int windowStartIdx = 0;
		 int windowEndIdx   = 0;
		 long sum           = 0;
		 
		 while(windowEndIdx < a.length)
		 {
			 sum += a[windowEndIdx];
			 
			 while(sum >= s && windowEndIdx >= windowStartIdx)
			 {
				 minWindowLen = Math.min(minWindowLen, windowEndIdx - windowStartIdx + 1);
				 
				 sum -= a[windowStartIdx++];
			 }
			 
			 windowEndIdx++;
		 }
		 
		 return minWindowLen == Integer.MAX_VALUE ? 0 : minWindowLen;
	 }
	 
	 public static void main(String[] args)
	 {
		 int[] array = {1};
		 
		 System.out.println(new MinimumSizeSubArray().minSubArrayLen(3, array));
	 }
				
}
