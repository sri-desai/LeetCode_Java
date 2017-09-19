import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Course_Schedule {
    
    static int[] preReq;
    
    public int[] findOrder(int numCourses, int[][] prerequisites) 
    {
        
    	preReq = new int[numCourses];
    	int startIdx = 0;
    	int starterNode = -1;
    	int[] finalList = new int[numCourses];
    	HashSet<Integer> list = new HashSet<>();
    	HashMap<Integer, ArrayList<Integer>> hmap  = new HashMap<>();
    	
    	for(int i = 0; i < prerequisites.length; ++i)
    	{
    		preReq[prerequisites[i][0]]++;
    		
    		int firstCourse = prerequisites[i][0];
    		int secCourse   = prerequisites[i][1];
    		
    		ArrayList<Integer> alist;
    		
    		if(hmap.containsKey(secCourse))
    		{
    			alist = hmap.get(secCourse);
    			
    			alist.add(firstCourse);
    			
    			hmap.put(secCourse, alist);
    		}
    		else
    		{
    			alist = new ArrayList<>();
    			
    			alist.add(firstCourse);
    			
    			hmap.put(secCourse, alist);
    		}
    	}
    	
    	if(getStarterNode(list) == -1)
    	{
    		return new int[0];
    	}
    	
    	starterNode = getStarterNode(list);
    	
    	while(startIdx < numCourses)
    	{
    		finalList[startIdx++] = starterNode;
    		
    		list.add(starterNode);

    		/*
    		for(int i = 0; i < prerequisites.length; ++i)
        	{
    			if(prerequisites[i][1] == starterNode)
    			{
    				preReq[prerequisites[i][0]]--;
    			}    			        		
        	}
        	*/
    		
    		ArrayList<Integer> alist = hmap.get(starterNode);
    		
    		for(int i = 0; alist != null && i < alist.size(); ++i)
    		{
    			if(preReq[alist.get(i)] > 0)
    			{
    				--preReq[alist.get(i)];
    			}
    		}
    		
    		starterNode = getStarterNode(list);
    		
    		if(starterNode == -1)
    		{    			
    			break;
    		}
    	}
    	
    	if(list.size() != numCourses)
    	{
    		return new int[0];
    	}
    	else
    	{
    		return finalList;
    	}
    
    	
    }

    public static int getStarterNode(HashSet<Integer> list)
    {
    	int startSub = -1;
    	
    	for(int i = 0; i < preReq.length && startSub == -1; ++i)
    	{
    		if(preReq[i] == 0 && !list.contains(i))
    		{
    			startSub = i;
    		}
    	}    	
    	return startSub;
    	
    }
}
