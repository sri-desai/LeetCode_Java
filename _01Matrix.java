import java.util.LinkedList;
import java.util.Queue;

public class _01Matrix 
{
	
	public int[][] updateMatrix(int[][] matrix) 
	{
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return matrix;
		
		Queue<int[]> queue = new LinkedList<>();
		
		for(int i = 0; i < matrix.length; ++i)
		{
			for(int j = 0; j < matrix[0].length; ++j)
			{
				if(matrix[i][j] == 0)
				{
					queue.offer(new int[] {i, j});
				}
				else
				{
					matrix[i][j] = Integer.MAX_VALUE;
				}
			}
		}
		
		populateMatrix(queue, matrix);
		
		return matrix;
    }

	private void populateMatrix(Queue<int[]> queue, int[][] matrix) 
	{
		int[][] directions = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
		
		while(!queue.isEmpty())
		{
			int[] smallerValuePos = queue.poll();
			
			for(int i = 0; i < directions.length; ++i)
			{
				int newRow = smallerValuePos[0] + directions[i][0];
				int newCol = smallerValuePos[1] + directions[i][1];
				
				if(!isValid(newRow, newCol, matrix)) continue;
				if(matrix[newRow][newCol] <= 1 + matrix[smallerValuePos[0]][smallerValuePos[1]]) continue;
				
				matrix[newRow][newCol] = 1 + matrix[smallerValuePos[0]][smallerValuePos[1]];
				
				queue.offer(new int[] {newRow, newCol});
			}
		}
	}

	private boolean isValid(int i, int j, int[][] matrix)
	{
		return i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length;
	}
	
	
}
