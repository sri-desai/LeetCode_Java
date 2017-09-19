import java.util.ArrayList;
import java.util.List;

public class LonestFilePath 
{
	/* need to correct the code */
	public int lengthLongestPath(String input) 
	{
		if(input == null || input.trim().length() == 0) return 0;
		
		String[] paths = input.split("\n");
		
		List<Integer> list = new ArrayList<>();
		int len = 0;
		
		for(String fileOrDir : paths)
		{					
			int level = fileOrDir.lastIndexOf("\t") + 1;
			
			if(list.size() == 0)
			{
				list.add(fileOrDir.length() + 1);
			}
			else
			if(list.size() == level)
			{
				list.add(list.get(level - 1) + fileOrDir.length() - level + 1);
			}
			else
			{
				list.set(level, list.get(level - 1) + fileOrDir.length() - level + 1);
			}
			
			if(fileOrDir.contains("."))
			{
				len = Math.max(len, list.get(level) - 1);
			}
		}
		
		return len;
    }

	
	public static void main(String[] args)
	{
		System.out.println(new LonestFilePath().lengthLongestPath("dir\nfile.ext"));
	}
}
