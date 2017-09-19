
public class NumMatrix 
{
	int[][] matrix;
	
	public NumMatrix(int[][] matrix) 
	{
        this.matrix = matrix;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) 
    {
    	long sum = 0;
    	
    	if(row1 >= matrix.length || row2 >= matrix.length || row1 < 0 || row2 < 0 ||
    	   col1 >= matrix.length || col2 >= matrix.length || col1 < 0 || col2 < 0)
    	{
    		return 0;
    	}
    	
    	for(int i = row1; i <= row2; ++i)
    	{
    		for(int j = col1; j <= col1; ++j)
    		{
    			sum += this.matrix[i][j];
    		}
    	}
    	
    	return (int) sum;
    }
}
