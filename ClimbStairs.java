
public class ClimbStairs  {
	
	public int climbStairs(int n) {
		
		if(n <= 0) return 0;
		
		if(n == 1) return 1;
		
		int[] differentWays = new int[n];
		
		differentWays[0] = 1;
		differentWays[1] = 2;
		
		for(int curStair = 2; curStair < n; ++curStair) {			
			differentWays[curStair] = differentWays[curStair - 1] + differentWays[curStair - 2];
		}
		
		return differentWays[n - 1];		
	}
}
