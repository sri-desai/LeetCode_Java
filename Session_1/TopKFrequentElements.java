import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

class FrequentElements
{
	int element;
	int count;
	
	public FrequentElements(int item, int count)
	{
		this.element = item;
		this.count  = count;
	}
};

public class TopKFrequentElements 
{
	public List<Integer> topKFrequent(int[] nums, int k) 
	{
		HashMap<Integer, Integer> countMap = new HashMap<>();
		List<Integer> list = new ArrayList<>();
		PriorityQueue<FrequentElements> maxHeap = new PriorityQueue<>(new Comparator<FrequentElements>() {

			@Override
			public int compare(FrequentElements o1, FrequentElements o2) {
				// TODO Auto-generated method stub
				return o2.count - o1.count;
			}
		});
		
		for(int i = 0; i < nums.length; ++i)
		{
			if(countMap.containsKey(nums[i]))
			{
				countMap.put(nums[i], countMap.get(nums[i]) + 1);
			}
			else
			{
				countMap.put(nums[i], 1);
			}
		}
		
		Iterator<Integer> iterator = countMap.keySet().iterator();
		
		while(iterator.hasNext())
		{
			int item = iterator.next();
			
			maxHeap.add(new FrequentElements(item, countMap.get(item)));
		}
		
		while(k-- > 0)
		{
			list.add(maxHeap.remove().element);
		}
		
		return list;
    }
	
	public static void main(String[] args)
	{
		int[] array = {1,1,1,2,2,3,4, 4,4,4};
		
		System.out.println(new TopKFrequentElements().topKFrequent(array, 2));
	}
}
