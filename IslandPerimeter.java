
public class IslandPerimeter 
{
	int maxPerimter = 0;
	
	public int islandPerimeter(int[][] grid) 
	{
		for(int i = 0; i < grid.length; ++i)
		{
			for(int j = 0; j < grid[0].length; ++j)
			{
				if(grid[i][j] == 1)
				{
					getParameter(grid, i, j);
					
					return maxPerimter;
				}
			}
		}
		
		return 0;
    }
	
	public boolean isValid(int[][] grid, int startRow, int startCol)
	{
		return startRow >= 0 && startRow < grid.length && startCol >= 0 && startCol < grid[0].length; 
	}
	
	
	private int getParameter(int[][] grid, int startRow, int startCol) 
	{
		if(!isValid(grid, startRow, startCol)) return 0;
		if(grid[startRow][startCol] == 0) 	   return 0;
		if(grid[startRow][startCol] == 2) 	   return 2;
		
		
		grid[startRow][startCol] = 2;
		
		int top = getParameter(grid, startRow - 1, startCol);
		int left = getParameter(grid, startRow, startCol - 1);
		int right = getParameter(grid, startRow, startCol + 1);
		int down = getParameter(grid, startRow + 1, startCol);
		
		if(top == 0) ++this.maxPerimter;
		if(left == 0)++this.maxPerimter;
		if(right == 0) ++this.maxPerimter;
		if(down == 0) ++this.maxPerimter;		
		
		return 2;
	}
}
