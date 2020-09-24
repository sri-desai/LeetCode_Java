
public class NumMatrix 
{
	private  long[][] matrix;
	private  int[][]  org_matrix;
	private  boolean  emptyMatrix;
	
	public NumMatrix(int[][] matrix) 
	{
		if(isEmptyMatrix(matrix))
		{
			emptyMatrix = true;
			
			return;
		}
		
		this.matrix = new long[matrix.length][matrix[0].length];
		
		org_matrix = matrix;
		
		for(int curRow = 0; curRow < matrix.length; ++curRow)
		{
			for(int curCol = 0; curCol < matrix[curRow].length; ++curCol)
			{
				this.matrix[curRow][curCol] = matrix[curRow][curCol];
			}
		}
        
        for(int curRow = 0; curRow < matrix.length; ++curRow)
        {
        	addRowElements(curRow);
        }
    }
	
	private boolean isEmptyMatrix(int[][] matrix)
	{
		return matrix == null || matrix.length == 0 || matrix[0].length == 0;
	}
    
	private void addRowElements (int row)
	{		
		for(int curCol = matrix[row].length - 2; curCol >= 0; --curCol)
		{
			matrix[row][curCol] += matrix[row][curCol + 1];						
		}
	}
	

	private void addValToRow (int row, int col, int val)
	{		
		for(int curCol = col; curCol >= 0; --curCol)
		{
			matrix[row][curCol] += val;						
		}
	}
	
	private boolean isValidIdx (int row, int col)
	{
		return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
	}
	
	public void update(int row, int col, int val) 
	{
		if(emptyMatrix || !isValidIdx(row, col)) return;
		
		int diff = val - org_matrix[row][col];
		
		org_matrix[row][col] = val;
		
		addValToRow(row, col, diff);
    }
	
	public int sumRegion(int row1, int col1, int row2, int col2) 
	{
		long sumValue = 0;
		
		if(emptyMatrix || !(isValidIdx(row1, col1) && isValidIdx(row2, col2)) ) return -1;
		
		for(int curRow = row1; curRow <= row2; ++curRow)
		{
			sumValue += matrix[curRow][col1];
			
			if(isValidIdx(curRow, col2 + 1))
			{
				sumValue -= matrix[curRow][col2 + 1];
			}
		}
		
		return (int)sumValue;
    }
	
	public static void main(String[] args)
	{
		int[][] testMatirx = {
								{3, 0, 1, 4, 2},
								{5, 6, 3, 2, 1},
								{1, 2, 0, 1, 5},
								{4, 1, 0, 1, 7},
								{1, 0, 3, 0, 5}								
		};
		
		NumMatrix testObj = new NumMatrix(testMatirx);
		
		System.out.println(testObj.sumRegion(2, 1, 4, 3));
		
		testObj.update(3, 2, 2);
		
		System.out.println(testObj.sumRegion(2, 1, 4, 3));
		
		
	}
}
