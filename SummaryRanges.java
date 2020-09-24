import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class SummaryRanges 
{
	private TreeMap<Integer, Interval> mapOfStartTime;
	
    /** Initialize your data structure here. */
    public SummaryRanges() 
    {
    	mapOfStartTime = new TreeMap<>();
    }
    
    public void addNum(int val)
    {
    	/* do not add val to the list if the key is already present*/
    	if(mapOfStartTime.containsKey(val)) return;
    	
        /* get the next lower key and higher key*/
    	Integer lowerStartTime  = mapOfStartTime.lowerKey(val);
    	Integer higherStartTime = mapOfStartTime.higherKey(val);    	
    	
    	/* if both keys are not null and in sequence merge them */
    	if(lowerStartTime != null && higherStartTime != null    &&
    	   mapOfStartTime.get(lowerStartTime).end    == val - 1 &&
    	   mapOfStartTime.get(higherStartTime).start == val + 1)
    	{
    		mapOfStartTime.get(lowerStartTime).end = mapOfStartTime.get(higherStartTime).end;
    		
    		mapOfStartTime.remove(higherStartTime);
    	}
    	
    	/* if lower key is not null update the end of lower key interval */
    	else
    	if(lowerStartTime != null && mapOfStartTime.get(lowerStartTime).end + 1 >= val)
    	{
    		mapOfStartTime.get(lowerStartTime).end = Math.max(val, 
    												 mapOfStartTime.get(lowerStartTime).end);
    	}
    	
    	/* if higher key is not null update the start of higher key*/
    	else
    	if(higherStartTime != null && mapOfStartTime.get(higherStartTime).start == val + 1)
    	{
    		mapOfStartTime.put(val, new Interval(val, mapOfStartTime.get(higherStartTime).end));
    		mapOfStartTime.remove(higherStartTime);
    	}
    	
    	/* else, create new interval*/
    	else
    	{
    		mapOfStartTime.put(val, new Interval(val, val));
    	}
    }
    
    public List<Interval> getIntervals() 
    {
        return new ArrayList<Interval>(mapOfStartTime.values());
    }
}