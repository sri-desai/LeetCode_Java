import java.util.ArrayList;
import java.util.List;

public class MinTimeDifference 
{
	public int findMinDifference(List<String> timePoints) 
	{
		final int TOTAL_TIME_MINS = 24 * 60;
		
		boolean [] setTimeInMins = new boolean[TOTAL_TIME_MINS];
		
		for(String curTime : timePoints)
		{
			String[] splitCurTime = curTime.split(":");
			
			int curHour = Integer.parseInt(splitCurTime[0]);
			int curMin  = Integer.parseInt(splitCurTime[1]);
			
			if(curHour == 0 && curMin == 0) curHour = 24;
			
			if(setTimeInMins[curHour * 60 + curMin - 1]) return 0;
			
			setTimeInMins[curHour * 60 + curMin - 1] = true;
		}
		
		int minDifference = Integer.MAX_VALUE;
		
		for(int curTimeIdx = 0; curTimeIdx < TOTAL_TIME_MINS; ++curTimeIdx)
		{
			if(!setTimeInMins[curTimeIdx]) continue;
			
			for(int nextTimeIdx = curTimeIdx + 1; nextTimeIdx < TOTAL_TIME_MINS; ++nextTimeIdx)
			{
				if(!setTimeInMins[nextTimeIdx]) continue;
				
				minDifference = Math.min(minDifference, Math.min(nextTimeIdx - curTimeIdx, 
																 TOTAL_TIME_MINS - (nextTimeIdx - curTimeIdx)
						                                        )
						                );
			}
		}
		
		return minDifference == Integer.MAX_VALUE ? -1 : minDifference;
    }
	
	public static void main(String[] args)
	{
		List<String> timeIntervals = new ArrayList<>();
		
		timeIntervals.add("12:12");
		timeIntervals.add("00:13");
		
		System.out.println(new MinTimeDifference().findMinDifference(timeIntervals));
	}
}
