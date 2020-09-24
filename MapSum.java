import java.util.HashMap;
import java.util.Map;

/*
 * This problem could have been solved using Trie.
 * 
 * But I found this approach bit fascinating. 
 * 
 * Inspired by "https://discuss.leetcode.com/user/wavy"
 *  
 */
public class MapSum 
{
	private Map<String, Integer> subStringsMap;
	private Map<String, Integer> compStringMap;
	
    public MapSum()
    {
    	subStringsMap = new HashMap<>();
    	compStringMap = new HashMap<>();
    }
    
    public void insert(String key, int val) 
    {
        int deltaToInsert = val - compStringMap.getOrDefault(key, 0);
        
        String subStrings = "";        
        for(char subChar : key.toCharArray())
        {
        	subStrings += subChar;
        	
        	subStringsMap.put(subStrings, subStringsMap.getOrDefault
        			                      (subStrings, 0) + deltaToInsert
        			         );        	
        }
        
        compStringMap.put(key, compStringMap.getOrDefault(key, 0) + deltaToInsert);
    }
    
    public int sum(String prefix) 
    {
        return subStringsMap.getOrDefault(prefix, 0);
    }
    
    
    public static void main(String[] args)
    {
    	MapSum mapObj = new MapSum();
    	
    	mapObj.insert("apple", 3);
    	
    	System.out.println(mapObj.sum("ap"));
    	
    	mapObj.insert("app", 2);
    	
    	System.out.println(mapObj.sum("ap"));
    }
}
