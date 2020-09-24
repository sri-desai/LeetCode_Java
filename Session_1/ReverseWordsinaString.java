
public class ReverseWordsinaString
{
	public String reverseWords(String s) 
	{
		if(s == null || s.trim().length() == 0) return "";
		
		StringBuffer sbuff = new StringBuffer();		
		s = s.trim();
		String[] str = s.split(" ");
		
		for(int i = str.length - 1; i > 0; --i)
		{
			if(str[i].equals("")) continue;
			sbuff.append(str[i]);
			sbuff.append(' ');
		}
		
		if(str.length > 0) sbuff.append(str[0]);
		
		return sbuff.toString();
    }
	
	public static void main(String[] args)
	{
		System.out.println(new ReverseWordsinaString().reverseWords("the    sky"));
	}
}
