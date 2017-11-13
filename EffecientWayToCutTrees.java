import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EffecientWayToCutTrees 
{
	/* Need to test */
	public int cutOffTree(List<List<Integer>> forest) 
    {
        Map<Integer, List<int[]>> treesPosition = new HashMap<>();
        
        boolean isOne = forest.get(0).get(0) == 1;
        
        for(int curRow = 0; curRow < forest.size(); ++curRow)
        {
        	for(int curCol = 0; curCol < forest.get(curRow).size(); ++curCol)
        	{
        		int curTreeHeight = forest.get(curRow).get(curCol);
        		int[] curPos      = {curRow, curCol};
        		
        		if(!treesPosition.containsKey(curTreeHeight))
        		{
        			treesPosition.put(curTreeHeight, new ArrayList<>());
        		}
        		
        		treesPosition.get(curTreeHeight).add(curPos);
        	}
        }
        
        List<Integer> orderedKeyList = new ArrayList<>(treesPosition.keySet());
        int[]         curPosition    = {0, 0};
        int           totalCount     = 0;
        
        Collections.sort(orderedKeyList);
        
        for(int curHeightTreeIdx = 0; curHeightTreeIdx < orderedKeyList.size(); ++curHeightTreeIdx)
        {
        	int curTree = orderedKeyList.get(curHeightTreeIdx);
        	
        	if(curTree <= 1) continue;
        	
        	if(!canBeReduced(curTree, forest, treesPosition.get(curTree), curPosition))
        	{
        		return -1;
        	}
        	
        	curPosition[0] = treesPosition.get(curTree).get(0)[0];
        	curPosition[1] = treesPosition.get(curTree).get(0)[1];
        	
        	++totalCount;
        }
        
        return isOne ? totalCount : totalCount - 1;         		
    }

	private boolean canBeReduced(int curTree, List<List<Integer>> forest, 
			                     List<int[]> treePosList, int[] curPosition)
	{
		if(treePosList.size() > 1) return false;
		
		int[] treePos = treePosList.get(0);
		boolean[][] visited = new boolean[forest.size()][forest.get(0).size()];
		
		if(!canBeReached(treePos, curPosition, forest, visited)) return false;
		
		forest.get(treePos[0]).set(treePos[1], 1);
		
		curPosition[0] = treePos[0];
		curPosition[1] = treePos[1];
		
		return true;
	}
	
	private boolean isValidIndex(int[] position, List<List<Integer>> forest)
	{
		return position[0] >= 0 && position[0] < forest.size() &&
			   position[1] >= 0 && position[1] < forest.get(0).size();
	}

	private boolean canBeReached(int[] treePos, int[] curPosition, 
			                     List<List<Integer>> forest, boolean[][] visited)
	{
		if(treePos[0] == curPosition[0] && treePos[1] == curPosition[1]) return true;
		
		if(!isValidIndex(curPosition, forest)) return false;
		
		if(visited[curPosition[0]][curPosition[1]]) return false;
		
		if(forest.get(curPosition[0]).get(curPosition[1]) > 1 || 
		   forest.get(curPosition[0]).get(curPosition[1]) == 0) return false;
		
		visited[curPosition[0]][curPosition[1]] = true;
		
		return canBeReached(treePos, new int[]{curPosition[0] + 1, curPosition[1]    }, forest, visited) ||
			   canBeReached(treePos, new int[]{curPosition[0] - 1, curPosition[1]    }, forest, visited) ||
			   canBeReached(treePos, new int[]{curPosition[0]    , curPosition[1] + 1}, forest, visited) ||
			   canBeReached(treePos, new int[]{curPosition[0]    , curPosition[1] - 1}, forest, visited);
	}
	
	public static void main(String[] args)
	{
		List<List<Integer>> mainList = new ArrayList<>();
		
		List<Integer> subArray1 = new ArrayList<>();
		List<Integer> subArray2 = new ArrayList<>();
		List<Integer> subArray3 = new ArrayList<>();
		
		
		subArray1.add(2);
		subArray1.add(3);
		subArray1.add(4);
		subArray2.add(0);
		subArray2.add(0);
		subArray2.add(5);
		subArray3.add(8);
		subArray3.add(7);
		subArray3.add(6);
		
		mainList.add(subArray1);
		mainList.add(subArray2);
		mainList.add(subArray3);
		
		System.out.println(new EffecientWayToCutTrees().cutOffTree(mainList));
	}
}
