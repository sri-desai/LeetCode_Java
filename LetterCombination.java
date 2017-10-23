import java.util.ArrayList;
import java.util.List;

public class LetterCombination 
{
	String[] letters = {" ", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	
	List<String> mainList;
	
	public List<String> letterCombinations(String digits) 
	{
		mainList = new ArrayList<>();
		
		digits = digits.trim();
		
		if(digits == null || digits.trim().length() == 0)
		{
			return mainList;
		}
		
		String str = "";
		
		populate(str, digits, 0);
		
		return mainList;
    }

	private void populate(String appendStr, String digits, int curPos) 
	{
		if(curPos == digits.length())
		{
			mainList.add(appendStr);
			
			return;
		}
		
		int curIdx = Integer.parseInt(Character.toString(digits.charAt(curPos)));
		
		for(int i = 0; i < letters[curIdx].length(); ++i)
		{
			populate(appendStr + letters[curIdx].charAt(i), digits, curPos + 1);
		}		
	}
	
	public static void main(String[] args)
	{
		System.out.println(new LetterCombination().letterCombinations("27"));
	}
}
