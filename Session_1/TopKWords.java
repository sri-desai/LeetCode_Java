import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKWords 
{
	public List<String> topKFrequent(String[] words, int k) 
	{
		Map<String, Integer> frequencyCountMap = new HashMap<>();
		List<String>         returnString      = new ArrayList<>();
		PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>( 
				
		(a, b) -> a.getValue() == b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue()
		);
		
		
		for(String word : words)
		{
			frequencyCountMap.put(word, frequencyCountMap.getOrDefault(word, 0) + 1);
		}
		
		for(Map.Entry<String, Integer> entry : frequencyCountMap.entrySet())
		{
			minHeap.offer(entry);
			
			if(minHeap.size() > k) minHeap.poll();
		}
		
		while(!minHeap.isEmpty())
		{
			returnString.add(0, minHeap.poll().getKey());
		}
		
		return returnString;
    }
	
	public static void main(String[] args)
	{
		String[] words = {"love", "i"};
		
		System.out.println(new TopKWords().topKFrequent(words, 2));
	}
}
