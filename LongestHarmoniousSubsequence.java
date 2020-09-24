import java.util.HashMap;
import java.util.Map;

public class LongestHarmoniousSubsequence
{
	public int findLHS(int[] nums) {
	    Map<Long, Integer> map = new HashMap<>();
	    for (long num : nums) {
	        map.put(num, map.getOrDefault(num, 0) + 1);
	    }
	    int result = 0;
	    for (long key : map.keySet()) {
	        if (map.containsKey(key + 1)) {
	            result = Math.max(result, map.get(key + 1) + map.get(key));
	        }
	    }
	    return result;
	}
	
	public static void main(String[] args)
	{
		int[] array = {1,2,1,3,0,0,2,2,1,3,3};
		
		System.out.println(new LongestHarmoniousSubsequence().findLHS(array));
	}
}
