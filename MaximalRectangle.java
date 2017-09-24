import java.util.HashMap;
import java.util.Map;

public class MaximalRectangle
{
	/* need to update the code */
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
		
		for(int col = 0; col < matrix[0].length; ++col)
		{
			int curRectangle = maxRectangleInsideCurCol(col, matrix);
			
			maxRectangle = Math.max(maxRectangle, curRectangle);
		}
		
		return maxRectangle;
    }

	private int maxRectangleInsideCurCol(int col, int[][] matrix) 
	{
		Map<Integer, Integer> map = new HashMap<>();
		
		int curArea = 0;
		
		for(int row = 0; row < matrix.length; ++row)
		{
			map.put(matrix[row][col], 1 + map.getOrDefault(matrix[row][col], 0));
		}
		
		for(Integer curWidth : map.keySet())
		{
			curArea = Math.max(curArea, curWidth * map.get(curWidth));
		}
		
		return curArea;
	}

	private void populateData(int row, int[][] matrix) 
	{
		
		for(int i = matrix[row].length - 2; i >= 0; --i)
		{
			if(matrix[row][i] == 1)
			{
				matrix[row][i] = 1 + matrix[row][i + 1];
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
