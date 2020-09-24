
public class ReconstructOriginalDigitsfromEnglish 
{
	String[] digits = { "zero", "one", "two",   "three", "four", 
					    "five", "six", "seven", "eight", "nine"};
	
	int lastMaxCount = 0;
	
	public String originalDigits(String s) 
	{
		int[] frequencyCount = new int[26];		
		
		for(int i = 0; i < s.length(); ++i)
		{
			frequencyCount[s.charAt(i) - 'a']++;
		}
				
		return validate(frequencyCount, 0);
    }
	
	private String validate(int[] frequencyCount, int startPos)
	{
		StringBuffer sbuff = new StringBuffer();
		
		int lastCount = -1;
		
		for(int i = startPos; i < 10; ++i)
		{
			if(isPossible(frequencyCount, i))
			{
				sbuff.append(Integer.toString(i));
				
				sbuff.append(validate(frequencyCount, i));
				
				lastCount = i;
			}
		}
		
		lastMaxCount = lastMaxCount < lastCount ? lastCount : lastMaxCount;
		
		return sbuff.toString();
	}

	private boolean isPossible(int[] frequencyCount, int count) 
	{
		boolean isPossible = true;
		
		for(int i = 0; i < digits[count].length() && isPossible; ++i)
		{
			if(frequencyCount[digits[count].charAt(i) - 'a'] == 0)
			{
				isPossible = false;
			}
		}
		
		if(!isPossible)
		{
			return isPossible;
		}
		
		for(int i = 0; i < digits[count].length(); ++i)
		{
			frequencyCount[digits[count].charAt(i) - 'a']--;
		}
		
		return true;
	}

	public static void main(String[] args)
	{
		System.out.println(new ReconstructOriginalDigitsfromEnglish().originalDigits("threezeroonetwo"));
	}
}
