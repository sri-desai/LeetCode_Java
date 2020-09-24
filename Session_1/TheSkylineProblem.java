import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/* Need to update */
public class TheSkylineProblem 
{
	public List<int[]> getSkyline(int[][] buildings) 
	{
		List<int[]> retVal = new ArrayList<>();
		
		int curBuildingIdx = 0;
		int curPoint       = buildings[curBuildingIdx][0];
		
		updateList(curPoint, buildings[curBuildingIdx][2], retVal);
		
		for(int i = 1; i < buildings.length; ++i)
		{
			if(isStartsFromWithIn(buildings[i], buildings[curBuildingIdx]))
			{
				if(buildings[i][2] > buildings[curBuildingIdx][2])
				{
					curPoint = buildings[i][0];
				}
				else
				{
					curPoint = buildings[curBuildingIdx][1];
				}
				
				curBuildingIdx = i;
				
				updateList(curPoint, buildings[curBuildingIdx][2], retVal);
			}
			
			else
			if(!isStartsFromWithIn(buildings[i], buildings[curBuildingIdx]))
			{
				continue;
			}
			else
			{
				updateList(0, 0, retVal);
				
				curPoint = buildings[i][0];
				
				curBuildingIdx = i;
				
				updateList(curPoint, buildings[curBuildingIdx][2], retVal);
			}
		}
		
		updateList(0, 0, retVal);
		
		return retVal;
    }

	private boolean isStartsFromWithIn(int[] subBuilding, int[] mainBuilding) 
	{
		return subBuilding[0] >= mainBuilding[0] && subBuilding[1] > mainBuilding[1];
	}

	private void updateList(int xCoOrdinate, int yCoOrdinate, List<int[]> retVal) 
	{
		int[] pointToInsert = {xCoOrdinate, yCoOrdinate};
		
		retVal.add(pointToInsert);
	}

	public static void main(String[] args)
	{
		int[][] buildings = { {2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8} };
		
		for(int[] points : new TheSkylineProblem().getSkyline(buildings))
		{
			System.out.println(points[0] + ' ' + points[1]);
		}		
		
	}
}
