import java.util.ArrayList;
import java.util.List;

public class RangeSumQuery2DImmutable 
{
	List<List<Long>> colList;
	
	public void NumMatrix(int[][] matrix) 
	{
		colList = new ArrayList<>();
		
		if(matrix == null || matrix.length == 0) return;
		
		for(int col = 0; col < matrix[0].length; ++col)
		{
			long sum = 0;
			
			List<Long> rowList = new ArrayList<>();
			
			for(int row = 0; row < matrix.length; ++row)
			{
				sum += matrix[row][col];
				rowList.add(sum);
			}
			
			colList.add(rowList);
		}
    }
	
	public int sumRegion(int row1, int col1, int row2, int col2) 
	{        
        long sum = 0;
    	
    	if( colList.size() == 0 		  || 
    		col1 >= colList.size()        || col2 >= colList.size()        || col1 < 0 || col2 < 0 ||
    	    row1 >= colList.get(0).size() || row2 >= colList.get(0).size() || row1 < 0 || row2 < 0
    	  )
    	{
    		return 0;
    	}
    	
    	for(int col = col1; col <= col2; ++col)
    	{
    		if(row1 == 0) sum += colList.get(col).get(row2);
    		else          sum += colList.get(col).get(row2) - colList.get(col).get(row1 - 1);
    	}
    	
    	return (int) sum;
    }
	
	public static void main(String[] args)
	{
		int[][] matrix = {	{3, 0, 1, 4, 2},
				{5, 6, 3, 2, 1},
				{1, 2, 0, 1, 5},
				{4, 1, 0, 1, 7},
				{1, 0, 3, 0, 5}
				};
		
		RangeSumQuery2DImmutable obj = new RangeSumQuery2DImmutable();
		
		obj.NumMatrix(matrix);
		
		System.out.println(obj.sumRegion(1, 2, 2, 4));
	}
}
