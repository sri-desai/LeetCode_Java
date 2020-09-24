
public class UniquePathsII
{
	boolean[][] visited;
	
	public int uniquePathsWithObstacles(int[][] obstacleGrid) 
	{
		if(obstacleGrid == null) return 0;	
		
		visited = new boolean[obstacleGrid.length][obstacleGrid[0].length];
		
		return computePath(obstacleGrid.length - 1, obstacleGrid[0].length - 1, obstacleGrid);
    }
	
	private boolean isValid(int curRow, int curCol, int[][] obstacleGrid)
	{
		return curRow >= 0 && curRow < obstacleGrid.length && curCol >= 0 && curCol < obstacleGrid[0].length;
	}

	private int computePath(int curRow, int curCol, int[][] obstacleGrid) 
	{
		if(!isValid(curRow, curCol, obstacleGrid))
		{
			return 0;
		}		
		else
		if(visited[curRow][curCol])
		{
			return obstacleGrid[curRow][curCol];
		}
		else
		{
			visited[curRow][curCol] = true;
			
			if(obstacleGrid[curRow][curCol] == 1)
			{
				obstacleGrid[curRow][curCol] = 0;				
			}
			else
			if(curRow == 0 && curCol == 0)
			{
				obstacleGrid[curRow][curCol] = 1;
			}
			else
			{
				obstacleGrid[curRow][curCol] = computePath(curRow - 1, curCol, obstacleGrid) +  
											   computePath(curRow,     curCol - 1, obstacleGrid);
			}
			
			return obstacleGrid[curRow][curCol];
		}
	}
	
	public static void main(String[] args)
	{
		int[][] array = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
		
		System.out.println(new UniquePathsII().uniquePathsWithObstacles(array));
	}
}
