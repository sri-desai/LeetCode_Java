
public class MinPathSum 
{
	public int minPathSum(int[][] grid) 
    {
		if(grid == null || grid.length == 0)
		{
			return 0;
		}
		
		int[][] matrix = new int[grid.length][grid[0].length];
		
		for(int i = 0; i < matrix.length; ++i)
		{
			for(int j = 0; j < matrix[0].length; ++j)
			{
				matrix[i][j] = -1;
			}
		}
		
		computeMatrix(matrix, grid, grid.length - 1, grid[0].length - 1);
		
		return matrix[grid.length - 1][grid[0].length - 1];
    }

	private void computeMatrix(int[][] matrix, int[][] grid, int row, int col) 
	{
		if(row < 0 || col < 0)
			return;
		
		if(row == 0 && col == 0)
		{
			matrix[row][col] = grid[row][col];
			
			return;
		}
		else
		{
			if(row == 0)
			{
				if(matrix[row][col - 1] == -1)
				{
					computeMatrix(matrix, grid, row, col - 1);
				}
				
				matrix[row][col] = matrix[row][col - 1] + grid[row][col];
			}
			else
			if(col == 0)
			{
				if(matrix[row - 1][col] == -1)
				{
					computeMatrix(matrix, grid, row - 1, col);
				}
				
				matrix[row][col] = matrix[row - 1][col] + grid[row][col];
			}
			else
			{
				if(matrix[row][col - 1] == -1)
				{
					computeMatrix(matrix, grid, row, col - 1);
				}
				if(matrix[row - 1][col] == -1)
				{
					computeMatrix(matrix, grid, row - 1, col);
				}
				
				matrix[row][col] = grid[row][col] + Math.min(matrix[row - 1][col], matrix[row][col - 1]);
			}
		}
		
	}

	public static void main(String[] args)
	{
		int[][] array = {
							{1, 2},
							{3, 4}
						};
		
		System.out.println(new MinPathSum().minPathSum(array));
	}
}
