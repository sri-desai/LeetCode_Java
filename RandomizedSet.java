import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomizedSet
{
	private Map<Integer, Integer> valLocMap;
	private List<Integer>         valList;
	private Random                randomNumGen;
	
	public RandomizedSet()
	{
        valLocMap = new HashMap<>();
        valList   = new ArrayList<>();
        randomNumGen = new Random();
    }
        
    public boolean insert(int val)
    {
        if(valLocMap.containsKey(val)) return false;
        
        valLocMap.put(val, valList.size());
        
        valList.add(val);
        
        return true;
    }
        
    public boolean remove(int val)
    {
    	if(!valLocMap.containsKey(val)) return false;
    	
    	int curLoc = valLocMap.get(val);
    	
    	if(curLoc < valList.size() - 1)
    	{
    		valList.set(curLoc, valList.get(valList.size() - 1));    	
    		
    		valLocMap.put(valList.get(valList.size() - 1), curLoc);       		
    	}
    	
    	valList.remove(valList.size() - 1);
    	
    	valLocMap.remove(val);
    	
    	return true;
    }
        
    public int getRandom()
    {
        return valList.get(randomNumGen.nextInt(valList.size()));
    }
}
