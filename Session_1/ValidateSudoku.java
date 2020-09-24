
public class ValidateSudoku 
{
	public boolean isValidSudoku(char[][] board) 
	{
		if(board == null || board.length < 9 || board[0].length < 9 || board.length > 9 || board[0].length > 9)
			return false;
			
		for(int row = 0; row < board.length; ++row)
		{
			boolean[] validity = new boolean[9];
			
			for(int col = 0; col < board[0].length; ++col)
			{
				if(board[row][col] != '.' && validity[board[row][col] - '1'])
				{
					return false;
				}
				else
				if(board[row][col] != '.')
				{
					validity[board[row][col] - '1'] = true;
				}
			}
		}
		
		for(int col = 0; col < board[0].length; ++col)
		{
			boolean[] validity = new boolean[9];
			
			for(int row = 0; row < board.length; ++row)
			{
				if(board[col][row] != '.' && validity[board[col][row] - '1'])
				{
					return false;
				}
				else
				if(board[col][row] != '.')
				{
					validity[board[col][row] - '1'] = true;
				}
			}
		}
		
		return true;
    }
}
