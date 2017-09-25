
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
}
