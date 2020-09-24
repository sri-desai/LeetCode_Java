import java.util.HashMap;
import java.util.Map;

class NODE
{
	char curChar;
	NODE nextNode;
	NODE prevNode;
}

public class AlienDictionary 
{
	public String alienOrder(String[] words) 
	{
		Map<Character, NODE> charNodeMap = new HashMap<>();
		
		NODE prevNode = null;
		
		for(int curWordIdx = 0; curWordIdx < words.length; ++curWordIdx)
		{
			char firstChar = words[curWordIdx].charAt(0); 
			
			if(charNodeMap.containsKey(firstChar))
			{
				return "";
			}
			
			NODE newNode = new NODE();
			
			charNodeMap.put(firstChar, newNode);
			
			newNode.curChar = firstChar;
			
			if(prevNode != null) 
			{
				prevNode.nextNode = newNode;
				newNode.prevNode  = prevNode;				
			}
			
			prevNode = newNode;
		}
		
		int prevWordIdx = 0;
		
		for(int curWordIdx = 1; curWordIdx < words.length; ++curWordIdx)
		{
			if(words[curWordIdx].charAt(0) != words[prevWordIdx].charAt(0))
			{
				rearrangeLetters(prevWordIdx, curWordIdx, words, charNodeMap);
				
				prevWordIdx = curWordIdx;
			}
		}
		
		rearrangeLetters(prevWordIdx, words.length - 1, words, charNodeMap);
		
		NODE randomNode = charNodeMap.get(words[prevWordIdx].charAt(0));
		
		while(randomNode.prevNode != null)
		{
			randomNode = randomNode.prevNode;
		}
		
		StringBuffer alphabets = new StringBuffer();
		
		while(randomNode != null)
		{
			alphabets.append(randomNode.curChar);
			
			randomNode = randomNode.nextNode;
		}
		
		return alphabets.toString();
    }

	private void rearrangeLetters(int prevWordIdx, int i, String[] words, Map<Character, NODE> charNodeMap) {
		// TODO Auto-generated method stub
		
	}
}
