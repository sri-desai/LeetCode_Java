import java.util.Arrays;

public class ConstructtheRectangle
{
	public int findContentChildren(int[] g, int[] s) 
	{
		int contentChildren = 0;
		
		Arrays.sort(g);
		Arrays.sort(s);
		
		int childIdx = g.length - 1;
		
		for(int i = s.length - 1; i >= 0; --i)
		{
			if(g[childIdx] <= s[i]) ++contentChildren;
		}
		
		return contentChildren;
    }
	
	public static void main(String[] args)
	{
		
	}
}
