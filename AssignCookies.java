import java.util.Arrays;

public class AssignCookies 
{
	public int findContentChildren(int[] g, int[] s) 
	{		
		Arrays.sort(g);
		Arrays.sort(s);
		
		int childIdx = 0;
		
		for(int i = 0; i < s.length && childIdx < g.length; ++i)
		{
			if(g[childIdx] <= s[i]) ++childIdx;
		}
		
		return childIdx;
    }
}
