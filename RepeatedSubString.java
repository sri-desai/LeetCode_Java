
public class RepeatedSubString
{
	 public boolean repeatedSubstringPattern(String s) 
	 {
		 return s == null || s.length() == 0 ? true : s.length() == 1 ? false : (s + s).substring(1, s.length() * 2 - 1).contains(s);
	 }
	 
	 public static void main(String[] args)
	 {
		 System.out.println(new RepeatedSubString().repeatedSubstringPattern("abab"));
	 }
}
