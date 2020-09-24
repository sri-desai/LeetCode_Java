import java.util.Stack;

public class SimplifyPath
{
	 public String simplifyPath(String path)
	 {
		 if(path == null) return null;
		 String replaced = path.trim().replace("//", "/");
		 
		 if(replaced.equals("/../")) return "/";
		 
		 Stack<String> dir_struct = new Stack<>();
		 String[] stripped = replaced.split("/");
		 
		 for(int i = 0; i < stripped.length; ++i)
		 {
			 if(stripped[i].length() == 0) continue;
			 else if(stripped[i].equals(".")) continue;
			 else if(stripped[i].equals("..") && !dir_struct.isEmpty()) dir_struct.pop();
			 else if(!stripped[i].equals("..")) dir_struct.push(stripped[i]);
		 }
		 
		 
		 StringBuffer sbuf = new StringBuffer();
		 
		 while(!dir_struct.isEmpty())
		 {
			 sbuf.insert(0, dir_struct.pop() + "/");
		 }
		 
		 if(sbuf.length() > 0)            sbuf.deleteCharAt(sbuf.length() - 1);
		 if(path.trim().charAt(0) == '/') sbuf.insert(0, "/");
		 
		 return sbuf.toString();
	 }
	 
	 public static void main(String[] args)
	 {
		 System.out.println(new SimplifyPath().simplifyPath("/home//foo/"));
	 }
}
