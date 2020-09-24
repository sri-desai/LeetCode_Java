
public class UniquePaths 
{
	public int uniquePaths(int m, int n) 
	{
		if(m == 0 || n == 0)
		{
			return 0;
		}
		else if(m == 1 && n == 1)
		        return 1;
		
		int[][] array = new int[m][n];
		
		populateData(array, m - 1, n - 1);
		
		return array[m - 1][n - 1];
    }
	
	private void populateData(int[][] array, int row, int col) 
	{
		if(row == 0 || col == 0)
		{
			array[row][col] = row == 0 && col == 0 ? 0 : 1;
		}
		else
		{
			if(array[row - 1][col] == 0)
			{
				populateData(array, row - 1, col);
			}
			
			if(array[row][col - 1] == 0)
			{
				populateData(array, row, col - 1);
			}
			
			array[row][col] = array[row - 1][col] + array[row][col - 1];
		}
	}
	
	public static void main(String[] args)
	{
		System.out.println(new UniquePaths().uniquePaths(1, 2));
	}
	
	
}
