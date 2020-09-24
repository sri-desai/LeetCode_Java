import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix 
{
	public List<Integer> spiralOrder(int[][] matrix) 
	{
		List<Integer> retList = new ArrayList<>();
		
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return retList;
		
		int topRow    = 0;
		int bottomRow = matrix.length - 1;
		int leftCol   = 0;
		int rightCol  = matrix[0].length - 1;
		
		while(topRow <= bottomRow && leftCol <= rightCol)
		{
			for(int curCol = leftCol; curCol <= rightCol && topRow <= bottomRow; ++curCol)
			{
				retList.add(matrix[topRow][curCol]);
			}
			
			++topRow;
			
			for(int curRow = topRow; curRow <= bottomRow && leftCol <= rightCol; ++curRow)
			{
				retList.add(matrix[curRow][rightCol]);
			}
			
			--rightCol;
			
			for(int curCol = rightCol; curCol >= leftCol && topRow <= bottomRow; --curCol)
			{
				retList.add(matrix[bottomRow][curCol]);
			}
			
			--bottomRow;
			
			for(int curRow = bottomRow; curRow >= topRow && leftCol <= rightCol; --curRow)
			{
				retList.add(matrix[curRow][leftCol]);
			}			
			
			++leftCol;
			
		}
				
		return retList;		
    }
	
	
	public static void main(String[] args)
	{
		int[][] matrix = {
							{1, 2, 3, 4, 5, 6, 7, 8, 9},
							{11, 12, 13, 14, 15, 16, 17, 18, 19}
						 };
		
		System.out.println(new SpiralMatrix().spiralOrder(matrix));
	}
}
