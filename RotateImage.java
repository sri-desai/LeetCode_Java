
public class RotateImage
{
	public void rotate(int[][] matrix) 
    {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
		
		
        for(int i = 0; i < matrix.length / 2; ++i)
        {
        	int[] tempRow = matrix[i];
        	matrix[i]     = matrix[matrix.length - i];
        	matrix[matrix.length - i] = tempRow;
        }
        
        for(int i = 0; i < matrix.length; ++i)
        {
        	for(int j = i + 1; j < matrix[i].length; ++j)
        	{
        		int temp = matrix[i][j];
        		matrix[i][j] = matrix[j][i];
        		matrix[j][i] = temp;
        	}
        }
    }
	
	public void rotate_Alt (int[][] matrix)
	{
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
		
		for(int curRow = 0; curRow < matrix.length; ++curRow)
		{
			for(int curCol = curRow; curCol < matrix[curRow].length; ++curCol)
			{
				int temp = matrix[curRow][curCol];
				matrix[curRow][curCol] = matrix[curCol][curRow];
				matrix[curCol][curRow] = temp;
			}
		}
		
		for(int[] curRow : matrix)
		{
			int startCol = 0;
			int endCol   = curRow.length - 1;
			
			while(startCol < endCol)
			{
				int temp = curRow[startCol];
				curRow[startCol] = curRow[endCol];
				curRow[endCol] = temp;
				
				++startCol;
				--endCol;
			}
		}
	}
	
	public static void main(String[] args)
	{
		int[][] matrix = {
		                  {1,2,3},
		                  {4,5,6},
		                  {7,8,9}
						 };
		
		new RotateImage().rotate_Alt(matrix);
		
		return;
	}
}
