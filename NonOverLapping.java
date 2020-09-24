import java.util.Arrays;
import java.util.Comparator;

public class NonOverLapping 
{
	 public int eraseOverlapIntervals(Interval[] intervals) 
	 {
		 Arrays.sort(intervals, new Comparator<Interval>() {
			    public int compare(Interval idx1, Interval idx2) {
			        return idx1.end - idx2.end;
			    }
			});
		 
		 int end = intervals[0].end;
		 int count = 0;
		 
		 for(int i = 1; i < intervals.length; ++i)
		 {
			if(intervals[i].start >= end)
			{
				end = intervals[i].end;
				++count;
			}
		 }
		 
		 
		 return intervals.length - count;
	 }
	 
	 public static void main (String[] args)
	 {
		 Interval[] array = new Interval[2];
		 
		 array[0] = new Interval(10, 20);
		 array[1] = new Interval(1, 2);
		 
		 System.out.println(new NonOverLapping().eraseOverlapIntervals(array));
	 }
}
