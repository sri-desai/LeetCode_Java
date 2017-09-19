
public class FriendCircles 
{
	public int findCircleNum(int[][] M) 
	{
		int friendCircleCount = 0;
		boolean[] visited = new boolean[M.length];
		
		for(int i = 0; i < M.length; ++i)
		{
			if(!visited[i])
			{
				populateAllFriends(i, M, visited);
				
				++friendCircleCount;
			}
			
		}
		
		return friendCircleCount;
    }

	private void populateAllFriends(int curRow, int[][] friendMatrix, boolean[] visited) 
	{
		if(visited[curRow]) return;
		
		visited[curRow] = true;
		
		for(int col = 0; col < friendMatrix[curRow].length; ++col)
		{
			if(friendMatrix[curRow][col] == 1)
			{
				friendMatrix[curRow][col] = 0;
				
				populateAllFriends(col, friendMatrix, visited);
			}
		}
	}
	
	public static void main(String[] args)
	{
		int matrix[][] = {{1,1,0},
		                  {1,1,1},
		                  {0,1,1}};
		
		System.out.println(new FriendCircles().findCircleNum(matrix));
	}
}
