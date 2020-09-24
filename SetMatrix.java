import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SetMatrix 
{
	public void setZeroes(int[][] matrix) 
	{
		if(matrix == null)
		{
			return;
		}
		
		boolean firstRow = false;
		boolean firstCol = false;
		
		for(int row = 0; row < matrix.length; ++row)
		{
			for(int col = 0; col < matrix[0].length; ++col)
			{
				if(matrix[row][col] == 0)
				{
					matrix[0][col] = 0;
					matrix[row][0] = 0;
					
					firstRow = row == 0 ? true : firstRow;		
					firstCol = col == 0 ? true : firstCol;
				}
			}
		}
		
		for(int row = 1; row < matrix.length; ++row)
		{
			if(matrix[row][0] == 0)
			{
				for(int col = 1; col < matrix[row].length; ++col)
				{
					matrix[row][col] = 0;
				}
			}
		}
		
		for(int col = 1; col < matrix[0].length; ++col)
		{
			if(matrix[0][col] == 0)
			{
				for(int row = 1; row < matrix.length; ++row)
				{
					matrix[row][col] = 0;
				}
			}
		}
		
		if(firstCol)
		{
			for(int row = 0; row < matrix.length; ++row)
			{
				matrix[row][0] = 0;
			}
		}
		
		if(firstRow)
		{
			for(int col = 0; col < matrix[0].length; ++col)
			{
				matrix[0][col] = 0;
			}
		}
	}

	private void setToZero(int[][] matrix, int row, int column) 
	{
		matrix[row][column] = -1;
		
		for(int col = 0; col < matrix[row].length; ++col)
		{
			matrix[row][col] = matrix[row][col] == 0 ? matrix[row][col] : -2;
		}
		
		for(int curRow = 0; curRow < matrix.length; ++curRow)
		{
			matrix[curRow][column] = 0;
		}
	}
	
	public static void main(String[] args)
	{
		int[][] matrix = {
					      {1, 2},
					      {0, 4}
 				         };
		
		new SetMatrix().setZeroes(matrix);
		
		System.out.println(Arrays.deepToString(matrix));
		
		
	}
}
