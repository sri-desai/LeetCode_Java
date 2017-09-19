import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class DuplicateFile
{
	public List<List<String>> findDuplicate(String[] paths) 
	{
		HashMap<String, List<String>> map = new HashMap<>();
		
		for(String path : paths)
		{
			String[] tokens = path.split(" ");
			
			for(int i = 1; i < tokens.length; ++i)
			{
				String file    = tokens[i].substring(0, tokens[i].indexOf('('));
				String content = tokens[i].substring(file.length(), tokens[i].length() - 1);
				
				if(map.containsKey(content))
				{
					map.get(content).add(tokens[0] + "/" + file);
				}
				else
				{
					List<String> filePath= new ArrayList<>();
					
					filePath.add(tokens[0] + "/" + file);
					
					map.put(content, filePath);
				}
			}
		}
		
		return map.values().stream().filter(e -> e.size() > 1).collect(Collectors.toList());
    }
	
	public static void main(String[] args)
	{
		String[] paths = {"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"};
		
		System.out.println(new DuplicateFile().findDuplicate(paths));
	}
}
