import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.w3c.dom.ls.LSInput;

public class MergeIntervals
{
	public List<Interval> merge(List<Interval> intervals) 
	{
		if(intervals == null || intervals.size() == 0)
		{
			return new ArrayList<Interval>();
		}
		else
		if(intervals.size() == 1)
		{
			return intervals;
		}
		
		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) 
			{
				// TODO Auto-generated method stub
				return o1.start == o2.start ? o1.start - o2.start : o1.end - o2.end;
			}
		});
		
		//List<Integer> list = new ArrayList<>();
		List<Interval> retList = new ArrayList<>();
		
		int prevStart = intervals.get(0).start;
		int prevEnd   = intervals.get(0).end;
				
		for(int i = 1; i < intervals.size(); ++i)
		{
			if(intervals.get(i).start <= prevEnd)
			{
					prevEnd = Math.max(intervals.get(i).end, prevEnd);
			}
			else
			{
				
				retList.add(new Interval(prevStart, prevEnd));
				
				prevStart = intervals.get(i).start;
				
				prevEnd = intervals.get(i).end;
				
			}		
		}
		
		retList.add(new Interval(prevStart, prevEnd));
				
		return retList;
    }
	
	public static void main(String[] args)
	{
		ArrayList<Interval> alist = new ArrayList<>();
		
		alist.add(new Interval(2, 6));
		/*alist.add(new Interval(1, 3));
		alist.add(new Interval(15, 18));
		alist.add(new Interval(8, 10));*/
		
		new MergeIntervals().merge(alist);
	}
}
