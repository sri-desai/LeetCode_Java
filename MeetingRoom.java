import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoom 
{
	public int minMeetingRooms(Interval[] intervals) 
	{
        PriorityQueue<Interval> earlierEndTimeHeap = new PriorityQueue<>(new Comparator<Interval>() {

			@Override
			public int compare(Interval firstInterval, Interval secondInterval) 
			{
				return firstInterval.end - secondInterval.end;
			}
		});
        
        Arrays.sort(intervals, new Comparator<Interval>() 
        {
			@Override
			public int compare(Interval o1, Interval o2)
			{
				return o1.start - o2.start;
			}
        	
		});
        
        int minMeetingRoomsRequired = Integer.MIN_VALUE;
        
        for(Interval curReservation : intervals)
        {
        	while(!earlierEndTimeHeap.isEmpty() && earlierEndTimeHeap.peek().end <= curReservation.start)
        	{
        		earlierEndTimeHeap.remove();
        	}
        	
        	earlierEndTimeHeap.add(curReservation);
        	
        	minMeetingRoomsRequired = Math.max(minMeetingRoomsRequired, earlierEndTimeHeap.size());
        }
        
        return minMeetingRoomsRequired == Integer.MIN_VALUE ? 0 : minMeetingRoomsRequired;
    }
}
