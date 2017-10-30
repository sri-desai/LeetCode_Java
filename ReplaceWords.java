import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReplaceWords 
{
	 public String replaceWords(List<String> dict, String sentence)
	 {
		 Set<String> dictSet = new HashSet<>(dict);
		 StringBuffer resultString = new StringBuffer();
		 
		 String[] words = sentence.split("\\s+");
		 
		 for(String word : words)
		 {
			 String root = getRootOfWord(word, dictSet);
			 
			 if(root != null) resultString.append(root + " ");
	     }
		 
		 while(resultString.length() > 0 && 
			   Character.isSpaceChar(resultString.charAt(resultString.length() - 1)))
		 {
			 resultString.deleteCharAt(resultString.length() - 1);
		 }
			 
	        
		 return resultString.toString();
	 }

	private String getRootOfWord(String word, Set<String> dictSet)
	{
		String resultRoot = "";
		
		for(int curIdx = 0; curIdx <= word.length(); ++curIdx)
		{
			String curWord = word.substring(0, curIdx);
			
			if(dictSet.contains(curWord))
			{
				resultRoot = curWord;
				
				break;
			}
		}
		
		return resultRoot == "" ? word : resultRoot;
	}
	
	public static void main(String[] args)
	{

	}
	
}
