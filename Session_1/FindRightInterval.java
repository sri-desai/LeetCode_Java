import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class FindRightInterval 
{
	public int[] findRightInterval(Interval[] intervals) 
	{
		int[] array = new int[intervals.length];
		List<Interval> list = new ArrayList<>();
		
		HashMap<Interval, Integer> map = new HashMap<>();
		
		for(int i = 0; i < intervals.length; ++i)
		{
			map.put(intervals[i], i);
			
			list.add(intervals[i]);
			
			array[i] = -1;
		}
		
		if(intervals.length <= 1)
		{
			return array;
		}
		
		Arrays.sort(intervals, new Comparator<Interval>() 
							   {
							public int compare(Interval id1, Interval id2)
							{
								return id1.start - id2.start;
							}
	   });
		
	  for(int i = 0; i < intervals.length; ++i)
	  {
		  int j;
		  
		  boolean found = false;
		  
		  for( j = i + 1; j < intervals.length; ++j)
		  {
			  if(intervals[j].start >= intervals[i].end)
			  {
				  found = true;
				  
				  break;
			  }
		  }
		  
		  if(found)
		  {
			  map.put(intervals[i], map.get(intervals[j]));  			  
		  }
		  else
		  {
			  map.put(intervals[i], -1);
		  }
	  }
	  	  
	  for(int i = 0; i < list.size(); ++i)
	  {
		  array[i] = map.get(list.get(i));
	  }
	  
	  return array;
    }

	public int[] effecientSolution(Interval[] intervals)
	{
		TreeMap<Integer, Integer> map = new TreeMap<>();
		
		int[] retArray = new int[intervals.length];
		
		for(int i = 0; i < intervals.length; ++i)
		{
			map.put(intervals[i].start, i);
		}
		
		for(int i = 0; i < intervals.length; ++i)
		{
			Integer minIndex = map.ceilingKey(intervals[i].end);
			retArray[i] = minIndex != null ? map.get(minIndex) : -1;
		}
		
		return retArray;
	}
	
	public static void main(String[] args)
	{
		Interval[] array = new Interval[3];
		array[0] = new Interval(3, 4);
		array[1] = new Interval(2, 3);
		array[2] = new Interval(1, 2);
		
		for(int ans : new FindRightInterval().effecientSolution(array))
		{
			System.out.println(ans);
		}
	}
}
