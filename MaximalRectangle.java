
public class MaximalRectangle
{
	/* Need to correct the code */
	public int maximalRectangle(char[][] matrix1) 
	{
		if(matrix1 == null || matrix1.length == 0 || matrix1[0].length == 0) return 0;
		
		int[][] matrix = new int[matrix1.length][matrix1[0].length];
		
		for(int i = 0; i < matrix.length; ++i)
		{
			for(int j = 0; j < matrix[0].length; ++j)
			{
				matrix[i][j] = matrix1[i][j] - '0';
			}
		}
		
		for(int i = 0; i < matrix.length; ++i)
		{
			populateData(i, matrix);
		}
		
		int maxRectangle = Integer.MIN_VALUE;
		
		for(int i = 0; i < matrix.length; ++i)
		{
			for(int j = 0; j < matrix[0].length; ++j)
			{
				maxRectangle = Math.max(maxRectangle, getMaxRectangle(i, j, matrix));
			}
		}
		
		return maxRectangle;
    }

	private int getMaxRectangle(int row, int col, int[][] matrix) 
	{
		int maxValue = 0;
		
		for(int i = row; i < matrix.length; ++i)
		{
			/* it's ok if current value is more than last one */
			if(matrix[i][col] == 0 || matrix[row][col] > matrix[i][col]) break;
			
			else maxValue += matrix[row][col];
		}
		
		return maxValue;
	}

	private void populateData(int row, int[][] matrix) 
	{
		
		for(int i = matrix[0].length - 2; i >= 0; --i)
		{
			if(matrix[row][i] == 1)
			{
				matrix[row][i] = 1 + matrix[row][i + 1];
			}
			else
			{
				matrix[row][i] = 0;
			}
		}
	}

	public static void main(String[] args)
	{
		char[][] matrix = {{'1', '0', '1', '0', '0'},
				  {'1', '0', '1', '1', '1'},
				  {'1', '1', '1', '1', '1'},
				  {'1', '0', '0', '1', '0'}
                };
		
		System.out.println(new MaximalRectangle().maximalRectangle(matrix));
	}
}
