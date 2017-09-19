
public class CountIslands
{
	char[][] mainGrid;
	
	public int numIslands(char[][] grid) 
	{
		int islandsCount = 0;
		
		if(grid == null || grid.length == 0)
		{
			return 0;			
		}
		
		mainGrid = grid;
		
		for(int row = 0; row < grid.length; ++row)
		{
			for(int column = 0; column < grid[0].length; ++column)
			{				
				if(mainGrid[row][column] == '1')
				{
					markIsland(row, column);
					
					++islandsCount;
				}
												
			}
		}
		
		return islandsCount;
    }
	
	private void markIsland(int row, int column) 
	{
		if(row < 0 || row >= mainGrid.length || column < 0 || column >= mainGrid[0].length || mainGrid[row][column] == '0')
		{
			return;
		}
				
		mainGrid[row][column] = '0';
		
		markIsland(row + 1, column);
		markIsland(row - 1, column);
		markIsland(row, column + 1);
		markIsland(row, column - 1);		
	}

	public static void main(String[] args)
	{
		/* char[][] grid = {{'0', '1', '1', '1', '0'},
						 {'0', '1', '0', '1', '0'},
						 {'0', '1', '0', '0', '0'},
						 {'0', '0', '0', '0', '0'},
					   }; */
		
		char[][] grid = {{'0', '1', '1'},
						 {'0', '1', '0'},
						 {'1', '1', '1'}
			   		    };
					   
		
		System.out.println(new CountIslands().numIslands(grid));
	}
}
