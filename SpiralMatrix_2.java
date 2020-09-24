
public class SpiralMatrix_2 
{
	public int[][] generateMatrix(int n)
    {
        if(n == 0 || n < 0) return null;
        
        int[][] resultMatrix = new int[n][n];
        
        int topRow = 0;
        int bottomRow = n - 1;
        int leftCol = 0;
        int rightCol = n - 1;
        int numberToInsert = 1;
        
        while(topRow <= bottomRow && leftCol <= rightCol)
        {
        	for(int curCol = leftCol; curCol <= rightCol; ++curCol)
        	{
        		resultMatrix[topRow][curCol] = numberToInsert++;
        	}
        	
        	++topRow;
        	
        	for(int curRow = topRow; curRow <= bottomRow; ++curRow)
        	{
        		resultMatrix[curRow][rightCol] = numberToInsert++;
        	}
        	
        	--rightCol;
        	
        	for(int curCol = rightCol; curCol >= leftCol; --curCol)
        	{
        		resultMatrix[bottomRow][curCol] = numberToInsert++;
        	}
        	
        	--bottomRow;
        	
        	for(int curRow = bottomRow; curRow >= topRow; --curRow)
        	{
        		resultMatrix[curRow][leftCol] = numberToInsert++;
        	}
        	
        	++leftCol;
        }
        
        return resultMatrix;
    }

	public static void main(String[] args)
	{
		System.out.println(new SpiralMatrix_2().generateMatrix(6));
	}
}
