
public class SmallestEnclosingRectangle 
{
	private int topLeftPoint[];
	private int bottomRightPoint[];
	
	
	public int minArea(char[][] image, int x, int y) 
	{
		if(image == null || image.length == 0 || image[0].length == 0) return 0;
		
		
		topLeftPoint = new int[2];
		bottomRightPoint = new int[2];
		
		topLeftPoint[0]     = Integer.MAX_VALUE;
		topLeftPoint[1]     = Integer.MAX_VALUE;
		bottomRightPoint[0] = Integer.MIN_VALUE;
		bottomRightPoint[1] = Integer.MIN_VALUE;
		
		int rowCount = 0;
		
		for(char[] curRow : image)
		{
			getRectanglePoints(rowCount, curRow);
			
			rowCount++;
		}
		
		return (bottomRightPoint[1] - topLeftPoint[1] + 1) * 
			   (bottomRightPoint[0] - topLeftPoint[0] + 1);
    }


	private void getRectanglePoints(int curRowCount, char[] curRow) 
	{
		for(int curCol = 0; curCol < curRow.length; ++curCol)
		{
			if(curRow[curCol] == '1')
			{
				topLeftPoint[0] = Math.min(topLeftPoint[0], curRowCount);
				topLeftPoint[1] = Math.min(topLeftPoint[1], curCol);
				
				bottomRightPoint[0] = Math.max(bottomRightPoint[0], curRowCount);
				bottomRightPoint[1] = Math.max(bottomRightPoint[1], curCol);
			}
		}		
	}
	
	public static void main(String[] args)
	{
		char[][] pattern = { {'0', '0', '1', '0'},
							 {'0', '1', '1', '0'},
							 {'0', '1', '0', '0'}
						   };
		
		System.out.println(new SmallestEnclosingRectangle().minArea(pattern, 0, 0));
	}
}
