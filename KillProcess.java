import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KillProcess
{
	public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) 
	{
		List<Integer>    killedProcesses = new ArrayList<>();
		HashMap<Integer, List<Integer>> parentMap = new HashMap<>();
		Queue<Integer> childProcesses = new LinkedList<>();
		
		for(int i = 0; i < ppid.size(); ++i)
		{
			List<Integer> childList;
						
			if(parentMap.containsKey(ppid.get(i)))
			{
				childList = parentMap.get(ppid.get(i));
			}
			else
			{
				childList = new ArrayList<>();
				parentMap.put(ppid.get(i), childList);
			}
			
			childList.add(pid.get(i));
		}
				
		childProcesses.add(kill);
		
		while(!childProcesses.isEmpty())
		{
			int parentProcess = childProcesses.poll();
			
			killedProcesses.add(parentProcess);
			
			if(parentMap.containsKey(parentProcess))
			{
				childProcesses.addAll(parentMap.get(parentProcess));
			}
						
		}
		
		return killedProcesses;		
    }
	
	public static void main(String[] args)
	{
		List<Integer> pid = new ArrayList<>();
		List<Integer> ppid = new ArrayList<>();
		
		pid.add(1);
		pid.add(3);
		pid.add(10);
		pid.add(5);
		
		ppid.add(3);
		ppid.add(0);
		ppid.add(5);
		ppid.add(3);
		
		System.out.println(new KillProcess().killProcess(pid, ppid, 5));
	}
}
