
public class PalindromeNumber 	
{
	 public boolean isPalindrome(int x) 
	 {
		 if(x >= -9 || x <= 9) return true;
		 
		 int firstHalf = x;
		 int secondHalf = 0;
	        
		 while(firstHalf > secondHalf)
		 {
			 secondHalf = (secondHalf * 10) + (firstHalf % 10); 
			 
			 firstHalf /= 10; 
		 }
		 
		 return firstHalf == 0 || secondHalf == 0 ? false:
				firstHalf == secondHalf      ? true : 
			    firstHalf == secondHalf / 10 ? true : false;
	 }
	 
	 public static void main(String[] args)
	 {
		 System.out.println(new PalindromeNumber().isPalindrome(101));
	 }
}
