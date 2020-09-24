import java.util.HashSet;

public class WordSearch 
{
	char[][] test_board;
	String   word_to_check;
	boolean[][] visited; 
	
	public boolean exist(char[][] board, String word) 
	{
		/* Need to validate the input */
		
		if(word == null || word.length() == 0) return false;
		if(board.length == 0 || board[0].length == 0) return false;
		if(word.length() > board.length * board[0].length) return false;
		
		test_board   = board;
		word_to_check = word;
		visited = new boolean[board.length][board[0].length];
		
		for(int row = 0; row < board.length; ++row)
		{
			for(int col = 0; col < board[0].length; ++col)
			{
				if(board[row][col] == word.charAt(0))
				{
					if(searchWord(row, col, 0)) return true;
				}
			}
		}		
		return false;
    }

	private boolean isValid(int row, int col)
	{
		return row >= 0 && row < test_board.length && col >= 0 && col < test_board[0].length;
	}
	
	private boolean searchWord(int row, int col, int startPos) 
	{	
		if(startPos >= word_to_check.length()) return true;
		if(!isValid(row, col))                 return false;
		if(visited[row][col])                  return false;
		
		if(test_board[row][col] == word_to_check.charAt(startPos))
		{
			visited[row][col] = true;
			
			boolean result = searchWord(row, col - 1, startPos + 1) || searchWord(row, col + 1, startPos + 1) ||
							 searchWord(row + 1, col, startPos + 1) || searchWord(row - 1, col, startPos + 1);
			
			visited[row][col] = false;
			
			return result;
		}
		else
		{
			return false;
		}
	}
	
	public static void main(String[] args)
	{
		char[][] board = {{'A'}
				         };
		
		System.out.println(new WordSearch().exist(board, "A"));
	}
}
