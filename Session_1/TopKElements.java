import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKElements 
{
	public List<Integer> topKFrequent(int[] nums, int k) 
	{
		List<Integer> frequentElements = new ArrayList<>();
		Map<Integer, Integer> integerCount = new HashMap<>();
		List<Integer>[] freqCount = new List[nums.length + 1];
		
		if(nums == null) return frequentElements;
		
		for(int num : nums)
		{
			integerCount.put(num, integerCount.getOrDefault(num, 0) + 1);
		}		
		
		for(int curKey : integerCount.keySet())
		{
			int count = integerCount.get(curKey);
			
			if(freqCount[count] == null)
			{
				freqCount[count] = new ArrayList<>();
			}
			
			freqCount[count].add(curKey);
		}
		
		int lastIdx = freqCount.length - 1;
		
		while(k > 0)
		{
			if(freqCount[lastIdx] != null && !freqCount[lastIdx].isEmpty())
			{
				frequentElements.add(freqCount[lastIdx].remove(0));
				
				--k;
			}
			else
			{
				lastIdx--;
			}
		}
		
		return frequentElements;
    }
	
	public static void main(String[] args)
	{
		System.out.println(new TopKElements().topKFrequent(new int[] {1,1,1,2,2,3}, 2));
	}
}
