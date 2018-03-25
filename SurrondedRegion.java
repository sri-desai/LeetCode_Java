import java.util.Arrays;

public class SurrondedRegion 
{
	 public void solve(char[][] board) 
	 {
		 if(board == null || board.length == 0 || board[0].length == 0) 
			 return;		 
		 
		 for(int curCol = 0; curCol < board[0].length; ++curCol)
		 {
			 changeBoarderElems(0, curCol, board);
		 }
		 for(int curCol = 0; curCol < board[0].length; ++curCol)
		 {
			 changeBoarderElems(board.length - 1, curCol, board);
		 }
		 for(int curRow = 0; curRow < board.length; ++curRow)
		 {
			 changeBoarderElems(curRow, 0, board);
		 }
		 for(int curRow = 0; curRow < board.length; ++curRow)
		 {
			 changeBoarderElems(curRow, board[0].length - 1, board);
		 }
		 
		 
		 for(int curRow = 0; curRow < board.length; ++curRow)
		 {
			 for(int curCol = 0; curCol < board[0].length; ++curCol)
			 {
				 if(board[curRow][curCol] == 'O') 
					 board[curRow][curCol] = 'X';
				 
				 if(board[curRow][curCol] == '1') 
					 board[curRow][curCol] = 'O';
			 }
		 }		 		
	 }
	 
	private void changeBoarderElems(int curRow, int curCol, char[][] board) 
	{
		if(!isValidIndex(curRow, curCol, board)) return;
		if(board[curRow][curCol] != 'O')		 return;
		
		board[curRow][curCol] = '1';
		
		changeBoarderElems(curRow + 1, curCol	 , board);
		changeBoarderElems(curRow - 1, curCol	 , board);
		changeBoarderElems(curRow    , curCol + 1, board);
		changeBoarderElems(curRow    , curCol - 1, board);
	}

	private boolean isValidIndex(int curRow, int curCol, char[][] board)
	{
		return board != null && curRow >= 0 && curRow < board.length &&
			   curCol >= 0 && curCol < board[0].length; 
	}
	
	
	public static void main(String[] args)
	{
		char[][] board = {	{'X', 'X', 'X', 'X'},
							{'X', 'O', 'O', 'X'},
							{'X', 'X', 'O', 'X'},
							{'X', 'O', 'X', 'X'}							
					     };
		
		new SurrondedRegion().solve(board);
		
		System.out.println(Arrays.deepToString(board));
	}
}
