
public class PermutationinString
{	
	public boolean checkInclusion(String s1, String s2) 
	{
		if(s1.length() > s2.length()) return false;
		
		boolean isPermutation = false;
		int[] firstStringCount = new int[26];
		int[] secondStringCount = new int[26];
				
		for(int i = 0; i < s1.length(); ++i)
		{
			++firstStringCount[s1.charAt(i) - 'a'];
			++secondStringCount[s2.charAt(i) - 'a'];
		}
		
		isPermutation = checkPermuation(firstStringCount, secondStringCount);
		
		for(int windowEnd = s1.length(); windowEnd < s2.length() && !isPermutation; ++windowEnd)
		{
			++secondStringCount[s2.charAt(windowEnd) - 'a'];
			--secondStringCount[s2.charAt(windowEnd - s1.length()) - 'a'];
			
			isPermutation = checkPermuation(firstStringCount, secondStringCount);
		}
		
		return isPermutation;
    }

	private boolean checkPermuation(int[] firstStringCount, int[] secondStringCount)
	{
		for(int i = 0; i < 26; ++i)
		{
			if(firstStringCount[i] != secondStringCount[i]) return false;
		}
		
		return true;
	}
	
	public static void main(String[] args)
	{
		System.out.println(new PermutationinString().checkInclusion("ab", "eidbaooo"));
	}
}
