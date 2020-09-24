import java.util.List;
import java.util.Stack;

public class OceanFlow 
{
    public List<int[]> pacificAtlantic(int[][] matrix) 
    {
    	Stack<int[]> stack = new Stack<>();
    	
    	boolean isPathFound = false;
    	
        for(int i = 0; i < matrix[0].length && !isPathFound; ++i)
        {
        	//if(isPath(0, i, matrix, stack, 0))
        	{
        		isPathFound = true;
        	}
        }
        
        for(int i = 0; i < matrix.length && !isPathFound; ++i)
        {
        	//if(isPath(i, matrix[i].length - 1, matrix, stack, 0))
        	{
        		isPathFound = true;
        	}
        }
        
        for(int i = 0; i < matrix[i].length && !isPathFound; ++i)
        {
        	//if(isPath(matrix.length - 1, i, matrix, stack, 0))
        	{
        		isPathFound = true;
        	}
        }
        
        for(int i = 0; i < matrix.length && !isPathFound; ++i)
        {
        	//if(isPath(i, 0, matrix, stack, 0))
        	{
        		isPathFound = true;
        	}
        }
        
        System.out.println(stack);
        
        return null;
        
    }

	private boolean isPath(int startRow, int startColumn, int[][] matrix, Stack<int[]> stack, int directionNotGo, int mainDirection) 
	{
		/*****************************************
		 * Direction values not to go 
		 * o 1 -> Don't go top row of same column
		 * o 2 -> Don't go bottom row of same column
		 * o 3 -> Don't go left column of same row
		 * o 4 -> Don't go right column of same row
		 ******************************************/
		
		/*****************************************
		 * Main direction values 
		 * o 1 -> Going Downwards
		 * o 2 -> Going Upwards
		 * o 3 -> Going leftwards
		 * o 4 -> Going rightwards
		 ******************************************/
		
		boolean isPathFound = false;
		int maxRow    = matrix.length    - 1;
		int maxColumn = matrix[0].length - 1;
		
		if( (mainDirection == 1 && startRow == maxRow      ) ||
			(mainDirection == 2 && startRow == 0           ) ||
			(mainDirection == 3 && startColumn == 0        ) ||
			(mainDirection == 4 && startColumn == maxColumn)
		  )
		{			
			isPathFound = true;
		}
		else
		{						
			
			/* Going to left column of same row */
			if(startColumn - 1 >= 0 && matrix[startRow][startColumn] >= matrix[startRow][startColumn - 1])
			{
				//isPathFound = isPath(startRow, startColumn - 1, matrix, stack);							
			}
								
			
		}
		
		if(isPathFound)
		{
			int[] curPos = new int[2];
			
			curPos[0] = startRow;
			curPos[1] = startColumn;
			
			stack.push(curPos);
		}
		
		return isPathFound;
	}

	public static void main (String[] args)
	{
		int[][] matrix= {{2, 2}, {1, 1}};
		
		OceanFlow ocenaFlow = new OceanFlow();
		
		ocenaFlow.pacificAtlantic(matrix);
	}
}