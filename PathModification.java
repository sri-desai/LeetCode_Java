
public class PathModification 
{
	private int getLastSlash(String path)
	{
		if(path == null || path.length() == 0)
		{
			return -1;
		}
				
		int pos = -1;
		
		for(int i = path.length() - 1; i >= 0; --i)
		{
			if(path.charAt(i) == '/')
			{
				pos = i;
				
				break;
			}
		}
		
		return pos;
	}
	
	public String simplifyPath(String path) 
	{
		if(path == null || path.length() == 0)
		{
			return null;
		}
		
		if(path.length() == 1)
		{
			return path;
		}
				
		
		String sb = path;
		StringBuffer ret = new StringBuffer("/");
		int pos;		
		
		while((pos = getLastSlash(sb.toString())) == sb.length() - 1)
		{
			if(pos == 0)
			{
				break;
			}
			
			sb = sb.substring(0, pos);
		}
		
		if(pos >= 0 && sb.length() > 0)
		{
			ret.append(sb.substring(pos + 1));
		}
		
		while(ret.charAt(ret.length() - 1) == '.')
		{
			ret.deleteCharAt(ret.length() - 1);
		}
		
		return ret.toString();		
    }
	
	public static void main(String[] args)
	{
		PathModification pathObj = new PathModification();
		
		System.out.println(pathObj.simplifyPath("/abc/fgh//"));
	}
}
