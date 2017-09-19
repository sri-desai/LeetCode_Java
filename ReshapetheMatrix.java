import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class ReshapetheMatrix
{
	public int[][] matrixReshape(int[][] nums, int r, int c)
    {
		if( r * c != nums.length * nums[0].length) return nums;   
		
		int[][] resultMatrix = new int[r][c];
		
		int cols = nums[0].length;
		
		for(int i = 0; i < r * c; ++i)
		{
			resultMatrix[i / c][i % c] = nums[i / cols][i % cols];
		}
		
		return resultMatrix;
    }

	
	
	public static void main(String[] args)
	{
		int[][] array = {{1,2},
		                 {3,4}};
		
		System.out.println(Arrays.deepToString(new ReshapetheMatrix().matrixReshape(array, 1, 4)));
	}
	
}
