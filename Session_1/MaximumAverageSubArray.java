import java.util.HashMap;
import java.util.Map;

public class MaximumAverageSubArray 
{
	public double findMaxAverage(int[] nums, int k) 
	{
		int sum = 0;
		long max = 0;
		
		for(int i = 0; i < k; ++i)
		{
			sum += nums[i];
		}
		
		max = sum;
		
		int startPos = 0;
		int endPos   = k - 1;
		
		while(++endPos < nums.length)
		{
			sum += nums[endPos];
			sum -= nums[startPos++];
			
			max = Math.max(max, sum);
		}
		
		return max * 1.0 / k;
    }

	public boolean judgeCircle(String moves) 
    {
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < moves.length(); ++i)
        {
        	map.put(moves.charAt(i), map.getOrDefault(moves.charAt(i), 0) + 1);
        }
        
        return map.get('D') == map.get('U') && map.get('L') == map.get('R');
        
    }
	public static void main(String[] args)
	{
		System.out.println(new MaximumAverageSubArray().findMaxAverage(new int[] {-1}, 1));
	}
}
