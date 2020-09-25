
public class Search2D 
{
	public boolean searchMatrix(int[][] matrix, int target) 
	{		
		if(matrix == null || matrix.length == 0)
			return false;
		
		int row = 0;
		int col = matrix[0].length - 1;
		
		
		
		while(col >= 0 && row <= matrix.length - 1)
		{
			if(matrix[row][col] == target)
			{
				return true;
			}
			else
			if(matrix[row][col] < target)
			{
				++row;
			}
			else
			{
				--col;
			}
		}
		
		return false;
    }
}