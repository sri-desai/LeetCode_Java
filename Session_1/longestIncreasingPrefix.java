
public class longestIncreasingPrefix 
{
	public int longestIncreasingPath(int[][] matrix) 
	{
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
		
		int[][] visited = new int[matrix.length][matrix[0].length];
		
		for(int i = 0; i < matrix.length; ++i)
		{
			for(int j = 0; j < matrix[0].length; ++j)
			{
				visited[i][j] = -1;
			}
		}
		
		int maxValue = Integer.MIN_VALUE;
		
		for(int i = 0; i < matrix.length; ++i)
		{
			for(int j = 0; j < matrix[0].length; ++j)
			{
				getMaxLength(i, j, matrix, visited);
				
				maxValue = Math.max(maxValue, visited[i][j]);
			}
		}
		
		return maxValue;
    }

	private boolean isIdxValid(int row, int col, int[][] matrix)
	{
		return row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length;
	}
	
	private int getMaxLength(int i, int j, int[][] matrix, int[][] visited) 
	{
		if(visited[i][j] != -1) return visited[i][j];
		
		int maxValue = 0;
		
		if(isIdxValid(i + 1, j, matrix) && matrix[i + 1][j] > matrix[i][j])
		{
			maxValue = Math.max(maxValue, getMaxLength(i + 1, j, matrix, visited));
		}
		if(isIdxValid(i - 1, j, matrix) && matrix[i - 1][j] > matrix[i][j])
		{
			maxValue = Math.max(maxValue, getMaxLength(i - 1, j, matrix, visited));
		}
		if(isIdxValid(i, j - 1, matrix) && matrix[i][j - 1] > matrix[i][j])
		{
			maxValue = Math.max(maxValue, getMaxLength(i, j - 1, matrix, visited));
		}
		if(isIdxValid(i, j + 1, matrix) && matrix[i][j + 1] > matrix[i][j])
		{
			maxValue = Math.max(maxValue, getMaxLength(i, j + 1, matrix, visited));
		}
		
		visited[i][j] = 1 + maxValue;
		
		return visited[i][j];
	}

	public static void main(String[] args)
	{
		int[][] nums = {
		                {9, 9, 4},
		                {6, 6 ,8},
		                {2, 1, 1}
		               };
		
		System.out.println(new longestIncreasingPrefix().longestIncreasingPath(nums));
	}
}
