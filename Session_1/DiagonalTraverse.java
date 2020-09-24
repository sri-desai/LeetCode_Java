import java.util.ArrayList;

public class DiagonalTraverse 
{
	public int[] findDiagonalOrder(int[][] matrix) 
	{
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return new int[0];
		
		ArrayList<Integer> list = new ArrayList<>();
		
		populateData(0, 0, matrix, list, true);
		
		int[] result = new int[list.size()];
		
		int i = 0;
		
		for(int num : list)
		{
			result[i++] = num;
		}
		
		return result;
    }
	
	private boolean isIdxValid(int row, int col, int[][] matrix)
	{
		return row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length;
	}

	private void populateData(int row, int col, int[][] matrix, ArrayList<Integer> list, 
			                  boolean isUpDir) 
	{		
		
		int res = 0;
		
		while(res >=0)
		{
			list.add(matrix[row][col]);
			
			int[] nextIdx = new int[2];
			
			res = getNextIdx(row, col, nextIdx, isUpDir, matrix);
			
			if(res == 1)  isUpDir = !isUpDir;
			
			row = nextIdx[0];
			
			col = nextIdx[1];			
		}
		
	}

	private int getNextIdx(int row, int col, int[] nextIdx, boolean isUpDir, 
			               int[][] matrix) 
	{
		if(isUpDir)
		{
			if(isIdxValid(row - 1, col + 1, matrix))
			{
				nextIdx[0] = row - 1;
				nextIdx[1] = col + 1;
				
				return 0;
			}
			else
			if(isIdxValid(row, col + 1, matrix))
			{
				nextIdx[0] = row;
				nextIdx[1] = col + 1;
				
				return 1;
			}
			else
			if(isIdxValid(row + 1, col, matrix))
			{
				nextIdx[0] = row + 1;
				nextIdx[1] = col;
				
				return 1;
			}
			else
			{
				return -1;
			}
		}
		else
		{
			if(isIdxValid(row + 1, col - 1, matrix))
			{
				nextIdx[0] = row + 1;
				nextIdx[1] = col - 1;
				
				return 0;
			}
			else
			if(isIdxValid(row + 1, col, matrix))
			{
				nextIdx[0] = row + 1;
				nextIdx[1] = col;
				
				return 1;
			}
			else
			if(isIdxValid(row, col + 1, matrix))
			{
				nextIdx[0] = row;
				nextIdx[1] = col + 1;
				
				return 1;
			}
			else
			{
				return -1;
			}
		}
	}

	public static void main(String[] args)
	{
		int[][] matrix = {
		                  {1, 2, 3}		               
						};
		
		System.out.println(new DiagonalTraverse().findDiagonalOrder(matrix));
	}
}
