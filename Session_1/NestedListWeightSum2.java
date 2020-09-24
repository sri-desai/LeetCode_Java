import java.util.ArrayList;
import java.util.List;

class NumberNode
{
	int val;
	int level;
}

class NestedInteger
{
	int val;
	int level;
}

public class NestedListWeightSum2 
{
	private void populateList(List<NestedInteger> nestedList, int curLevel, 
			                  List<NumberNode> resultList)
	{
		for(int i = 0; i < nestedList.size(); ++i)
		{
			if(nestedList.get(i).isInteger())
        	{
        		NumberNode curNode = new NumberNode();
        		
        		curNode.val = nestedList.get(i).getInteger();
        		curNode.level = curLevel;        		
        	}
        	else
        	{
        		populateList(nestedList.get(i).getList(), curLevel + 1, resultList);
        	}
		}
	}
	
	public int depthSumInverse(List<NestedInteger> nestedList) 
	{
        if(nestedList == null || nestedList.size() == 0) return 0;
        
        List<NumberNode> resultList = new ArrayList<>();
        
        populateList(nestedList, 1, resultList);
        
        int maxLevel = 1;
        int totalSum = 0;
        
        for(NumberNode curNumber : resultList)
        {
        	maxLevel = Math.max(maxLevel, curNumber.level);
        }
        
        for(NumberNode curNumber : resultList)
        {
        	totalSum += (curNumber.val * (maxLevel - curNumber.level + 1)); 
        }
        
        return totalSum;
    }
}
