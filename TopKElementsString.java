import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKElementsString 
{
	public List<String> topKFrequent(String[] words, int k) 
	{
		List<String> frequentElements = new ArrayList<>();
		Map<String, Integer> integerCount = new HashMap<>();
		List<String>[] freqCount = new List[words.length + 1];
		
		if(words == null) return frequentElements;
		
		for(String word : words)
		{
			integerCount.put(word, integerCount.getOrDefault(word, 0) + 1);
		}		
		
		for(String curKey : integerCount.keySet())
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
		String[] words = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
		
		System.out.println(new TopKElementsString().topKFrequent(words, 4));
	}
}
