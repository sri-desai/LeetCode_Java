import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MinimumSumTriangle
{
	List<List<Integer>> globalTrianle;
	HashMap<Integer, HashMap<Integer, Integer>> hmap;
	
	public int minimumTotal(List<List<Integer>> triangle) 
	{		
		if(triangle == null || triangle.size() == 0)
		{
			return 0;
		}		
		
		globalTrianle = triangle;
		
		hmap = new HashMap<>();
		
		return getSum(0, 0);
    }
	
	private int getSum(int curLevel, int curIdx)
	{
		int curItem = globalTrianle.get(curLevel).get(curIdx);		
		HashMap<Integer, Integer> curMap = new HashMap<>();
		int retVal;
		
		if(curLevel + 1 == globalTrianle.size())
		{
			curMap.put(curIdx, curItem);
			
			hmap.put(curLevel, curMap);
			
			return curItem;
		}		
		
		long  nextLeftSum = Long.MIN_VALUE;
		long  nextRightSum = Long.MIN_VALUE;
		
		if(hmap.containsKey(curLevel + 1) && hmap.get(curLevel + 1).containsKey(curIdx))
		{
			nextLeftSum = hmap.get(curLevel + 1).get(curIdx);
		}
		
		if(hmap.containsKey(curLevel + 1) && hmap.get(curLevel + 1).containsKey(curIdx + 1))
		{
			nextRightSum = hmap.get(curLevel + 1).get(curIdx + 1);
		}
		
		if(nextLeftSum == Long.MIN_VALUE)
		{
			nextLeftSum = getSum(curLevel + 1, curIdx);
		}
		if(nextRightSum == Long.MIN_VALUE)
		{
			nextRightSum = getSum(curLevel + 1, curIdx + 1);
		}
		
		retVal = (int) (curItem + Math.min(nextLeftSum, nextRightSum));
		
		curMap.put(curIdx, retVal);
		
		hmap.put(curLevel, curMap);
		
		return retVal;
	}
	
	public static void main(String[] args)
	{
		MinimumSumTriangle minObj = new MinimumSumTriangle();
		
		List<List<Integer>> alist = new ArrayList<>();
		
		ArrayList<Integer> subList = new ArrayList<>();		
		subList.add(2);		
		alist.add(subList);
		
		subList = new ArrayList<>();		
		subList.add(3);
		subList.add(4);		
		alist.add(subList);
		
		subList = new ArrayList<>();
		subList.add(6);
		subList.add(5);
		subList.add(7);
		alist.add(subList);
		
		subList = new ArrayList<>();
		subList.add(4);
		subList.add(1);
		subList.add(8);
		subList.add(3);
		alist.add(subList);
		
		
		System.out.println(minObj.minimumTotal(alist));
	}
}
