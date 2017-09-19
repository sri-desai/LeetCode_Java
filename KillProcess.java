import java.util.ArrayList;
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
			List<Integer> parent;
						
			if(parentMap.containsKey(ppid.get(i)))
			{
				parent = parentMap.get(ppid.get(i));
			}
			else
			{
				parent = new ArrayList<>();
				parentMap.put(ppid.get(i), parent);
			}
			
			parent.add(i);
		}
				
		childProcesses.add(kill);
		
		while(!childProcesses.isEmpty())
		{
			int parentProcess = childProcesses.poll();
			
			killedProcesses.add(parentProcess);
			
			
		}
		return killedProcesses;
		
    }
}
