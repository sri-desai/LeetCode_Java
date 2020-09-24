import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class IntersectionofTwoArrays 
{
	public int[] intersection(int[] nums1, int[] nums2) 
    {
        Set<Integer> firstArray = new HashSet<>();
        Set<Integer> retArray   = new HashSet<>();
        
        for(int num : nums1)
        {
        	firstArray.add(num);
        }
        
        for(int num : nums2)
        {
        	if(firstArray.contains(num)) retArray.add(num);
        }
        
        int[] retVal = new int[retArray.size()];
        int i = 0;
        
        for(int num : retArray)
        {
        	retVal[i++] = num;
        }
        
        return retVal;
    }
	
	
	public int[] intersect (int[] nums1, int[] nums2)
	{
		HashMap<Integer, Integer> elemCount = new HashMap<>();
		
		int[] smallArray = nums1.length < nums2.length ? nums1 : nums2;
		int[] remArray   = smallArray == nums1 ? nums2 : nums1;
		List<Integer> retArray = new ArrayList<>();
		
		for(int num : smallArray)
		{
			elemCount.put(num, elemCount.getOrDefault(num, 0) + 1);
		}
		
		for(int num : remArray)
		{
			if(elemCount.containsKey(num) && elemCount.get(num) > 0)
			{
				retArray.add(num);
				elemCount.put(num, elemCount.get(num) - 1);				
			}
		}
		
		 int[] retVal = new int[retArray.size()];
	        int i = 0;
	        
	        for(int num : retArray)
	        {
	        	retVal[i++] = num;
	        }
	        
	        return retVal;
	}

	public String reverseWords(String s) 
    {
        String[] splittedString = s.split("\\s");
        StringBuffer retVal = new StringBuffer();
        
        for(int i = 0; i < splittedString.length; ++i)
        {
        	retVal.append(new StringBuffer(splittedString[i]).reverse());
        	
        	if(i != splittedString.length - 1)
        	{
        		retVal.append(" ");
        	}
        }
        
        return retVal.toString();        
    }
}
