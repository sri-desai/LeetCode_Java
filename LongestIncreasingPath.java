import java.util.Arrays;

public class LongestIncreasingPath 
{
	public int longestIncreasingPath(int[][] matrix) 
	{
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
		
		int maxCount = Integer.MIN_VALUE;
		int[][] visitedMatrix = new int[matrix.length][matrix[0].length];
		
		for(int curRow = 0; curRow < matrix.length; ++curRow)
		{
			Arrays.fill(visitedMatrix[curRow], -1);
		}
		
		for(int row = 0; row < matrix.length; ++row)
		{
			for(int col = 0; col < matrix[0].length; ++col)
			{
				maxCount = Math.max(getPathLen(matrix, row, col, visitedMatrix, matrix[row][col] - 1L), maxCount);
			}
		}
		
		return maxCount;
    }

	

	private int getPathLen(int[][] matrix, int row, int col, int[][] visitedMatrix, long prevValue) 
	{
		if(!isValidIdx(matrix, row, col) || prevValue >= matrix[row][col]) return 0;
		if(visitedMatrix[row][col] != -1) return visitedMatrix[row][col];
		
		int curMaxPath1 = getPathLen(matrix, row - 1, col, visitedMatrix, matrix[row][col]);
		int curMaxPath2 = getPathLen(matrix, row + 1, col, visitedMatrix, matrix[row][col]);
		int curMaxPath3 = getPathLen(matrix, row, col - 1, visitedMatrix, matrix[row][col]);
		int curMaxPath4 = getPathLen(matrix, row, col + 1, visitedMatrix, matrix[row][col]);
		
		visitedMatrix[row][col] = 1 + Math.max(curMaxPath1, Math.max(curMaxPath2, Math.max(curMaxPath3, curMaxPath4)));
		
		return visitedMatrix[row][col];
	}

	private boolean isValidIdx(int[][] matrix, int row, int col) 
	{
		return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length; 
	}

	public static void main(String[] args)
	{
		//int[][] matrix = {{0,1,2,3,4,5,6,7,8,9},{19,18,17,16,15,14,13,12,11,10},{20,21,22,23,24,25,26,27,28,29},{39,38,37,36,35,34,33,32,31,30},{40,41,42,43,44,45,46,47,48,49},{59,58,57,56,55,54,53,52,51,50},{60,61,62,63,64,65,66,67,68,69},{79,78,77,76,75,74,73,72,71,70},{80,81,82,83,84,85,86,87,88,89},{99,98,97,96,95,94,93,92,91,90},{100,101,102,103,104,105,106,107,108,109},{119,118,117,116,115,114,113,112,111,110},{120,121,122,123,124,125,126,127,128,129},{139,138,137,136,135,134,133,132,131,130},{0,0,0,0,0,0,0,0,0,0}};
		
		int[][] matrix = {{9,9,4}, {6,6,8}, {2,1,1}};
		
		System.out.println(new LongestIncreasingPath().longestIncreasingPath(matrix));
	}
}
