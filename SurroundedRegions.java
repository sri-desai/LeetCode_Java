
public class SurroundedRegions 
{
	public void solve(char[][] board) 
	{
		for(int i = 1; i < board.length - 1; ++i)
		{
			for(int j = 1; j < board[0].length - 1; ++j)
			{
				if(board[i][j] == 'O')
				{
					board[i][j] = 'X';
					
					if(isValid(board, i + 1, j + 0) && isValid(board, i - 1, j + 0) &&
					   isValid(board, i + 0, j + 1) && isValid(board, i + 0, j - 1))
					{
						;
					}
					else
					{
						board[i][j] = 'O';
					}
				}
			}
		}
    }

	private boolean isValid(char[][] board, int i, int j) 
	{
		if(i < 0 || i >= board.length)    return false;
		if(j < 0 || j >= board[0].length) return false;
		
		if(board[i][j] == 'X') return true;
		else
		{
			board[i][j] = 'X';
			
			if(isValid(board, i + 1, j + 0) && isValid(board, i - 1, j + 0) &&
			   isValid(board, i + 0, j + 1) && isValid(board, i + 0, j - 1))
			{
				return true;
			}
			else
			{
				board[i][j] = 'O';
				
				return false;
			}
		}
	}
	
	public static void main(String[] args)
	{
		char[][] array = {
				{'X', 'X', 'X', 'X'},
				{'X', 'O', 'O', 'X'},
				{'X', 'O', 'O', 'X'},
				{'X', 'X', 'X', 'X'},

				};
		
		new SurroundedRegions().solve(array);
		
		return;
	}
}
