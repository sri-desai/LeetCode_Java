import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskScheduler 
{
	public int leastInterval(char[] tasks, int n) 
	{
		int[] charCount = new int[26];
		
		for(char curTask : tasks)
		{
			++charCount[curTask - 'A'];
		}
		
		Map<Character, Integer> prevNTasksMap = new HashMap<>();
		List<Character> taskOrder = new ArrayList<>();
		
		getInterval(0, charCount, prevNTasksMap, taskOrder, n);
		
		return taskOrder.size();
		
    }

	private void getInterval(int curLevel, int[] charCount, 
			                 Map<Character, Integer> prevNTasksMap, 
			                 List<Character> taskOrder, int minDifference)
	{
		boolean isAnyTasksPending = false;
		boolean isTaskScheduled   = false;
		
		for(int curTaskIdx = 0; curTaskIdx < 26; ++curTaskIdx)
		{
			if(charCount[curTaskIdx] == 0) continue;
			
			isAnyTasksPending = true;
			
			char curTask = (char) ('A' + curTaskIdx);
			
			if( (prevNTasksMap.containsKey(curTask) && 
			    curLevel - prevNTasksMap.get(curTask) > minDifference) ||
				!prevNTasksMap.containsKey(curTask)
			  )
			{
				isTaskScheduled = true;
				
				prevNTasksMap.put(curTask, curLevel);
				
				--charCount[curTaskIdx];
				
				taskOrder.add(curTask);
				
				getInterval(curLevel + 1, charCount, prevNTasksMap, taskOrder, minDifference);
				
			}
			
		}
		
		if(!isAnyTasksPending) return;
		
		if(!isTaskScheduled)
		{
			prevNTasksMap.clear();
			
			taskOrder.add('i');
			
			getInterval(curLevel + 1, charCount, prevNTasksMap, taskOrder, minDifference);
		}
	}
	
	public static void main(String[] args)
	{
		char[] tasks = {'A','A','A','B','B','B'};
		
		System.out.println(new TaskScheduler().leastInterval(tasks, 2));
	}
}
