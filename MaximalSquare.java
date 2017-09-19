
public class MaximalSquare 
{
	int area = -1;
	char[][] globalMatrix;
	
	public int maximalSquare(char[][] matrix) 
	{
		if(matrix == null || matrix.length == 0) return 0;
		
		globalMatrix = matrix;
		int startRow = 0;
		int endRow   = matrix.length;
		int startCol = 0;
		int endcol   = matrix[0].length;
		
		for(int curRowStart = startRow; curRowStart < endRow; ++curRowStart)
		{
			for(int curRowEnd = curRowStart; curRowEnd < endRow; ++curRowEnd)
			{								
				for(int curcolStart = startCol; curcolStart < endcol; ++curcolStart)
				{
					int curColEnd = curcolStart + (curRowEnd - curRowStart);					 													
					if(curColEnd - curcolStart <  curRowEnd - curRowStart)    
						continue;
					if(curColEnd - curcolStart >  curRowEnd - curRowStart)    
						break;
					if(curColEnd - curcolStart == 0 && area >= 1)             
						break;
					if(area > 0 && (curRowEnd - curRowStart + 1) *  (curRowEnd - curRowStart + 1) <= area) 
						break;
					if(area > 0 && area == curRowEnd - curRowStart + 1)       
						break;
					
					validateMatrix(curRowStart, curRowEnd, curcolStart, curColEnd);
				}
			}
		}
		
		return area == -1 ? 0 : area;
    }

	private void validateMatrix(int rowStart, int rowEnd, int colStart, int colEnd) 
	{
		if(colEnd >= globalMatrix[0].length) return;
		
		boolean isValid = true;
		
		for(int row = rowStart; row <= rowEnd && isValid; ++row)
		{
			for(int col = colStart; col <= colEnd && isValid; ++col)
			{
				if(globalMatrix[row][col] == '0') isValid = false;
			}
		}
		
		if(isValid) area = (rowEnd - rowStart + 1) * (colEnd - colStart + 1);
	}
	
	public static void main(String[] args)
	{
		char[][] matrix = {
				{'1', '1', '1', '0', '0'},
				{'1', '1', '1', '0', '0'},
				{'1', '1', '1', '1', '1'},
				{'0', '1', '1', '1', '1'},
				{'0', '1', '1', '1', '1'},
				{'0', '1', '1', '1', '1'}

		                  };
		
		System.out.println(new MaximalSquare().maximalSquare(matrix));
	}
}
