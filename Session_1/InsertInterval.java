import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class InsertInterval
{
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) 
	{
        Collections.sort(intervals, new Comparator<Interval>() 
        {
			@Override
			public int compare(Interval o1, Interval o2) 
			{
				// TODO Auto-generated method stub
				return o1.start - o2.start;
			}
		});
                
        List<Interval> retList = new ArrayList<>();
    	
    	boolean isIntervalToAdd = true;
    	
    	for(Interval curInterval : intervals)
    	{    		    		
    		if(curInterval.start > newInterval.end)
    		{
    			if(isIntervalToAdd)
    			{
    				retList.add(newInterval);
    				
    				isIntervalToAdd = false;
    			}
    			
    			retList.add(curInterval);
    			
    		}    		    	
    		else
    		if(curInterval.end < newInterval.start)
    		{
    			retList.add(curInterval);
    		}
    		else
    		{
    			newInterval.start = Math.min(newInterval.start, curInterval.start);
    			newInterval.end   = Math.max(newInterval.end,   curInterval.end);
    		}    		
    	}
    	
    	if(isIntervalToAdd)
    	{
    		retList.add(newInterval);
    	}
    	
    	return retList;        
    }
	
	public static void main(String[] args)
	{
		List<Interval> input = new ArrayList<>();
		Interval newInterval = new Interval(4, 9);
		
		input.add(new Interval(1, 2));
		input.add(new Interval(3, 5));
		input.add(new Interval(6, 7));
		input.add(new Interval(8, 10));
		input.add(new Interval(12, 16));
		
		System.out.println(new InsertInterval().insert(input, newInterval));
	}
}
