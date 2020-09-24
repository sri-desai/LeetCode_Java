import java.util.LinkedList;
import java.util.Queue;

public class WordDictionary 
{
	boolean isAWord;
	
	WordDictionary[] subNodes;
	
	public WordDictionary()
	{
		isAWord  = false;
		subNodes = new WordDictionary[26];		
	}
	
	public void addWord(String word) 
	{
		if(word == null || word.trim().length() == 0) return;
		String trimmed = word.trim();
		
		WordDictionary curNode = this;
		
		for(int i = 0; i < trimmed.length(); ++i)
		{
			if(curNode.subNodes[trimmed.charAt(i) - 'a'] == null) 
				curNode.subNodes[trimmed.charAt(i) - 'a'] = new WordDictionary();
					
			curNode = curNode.subNodes[trimmed.charAt(i) - 'a'];
		}
			
		curNode.isAWord = true;
    }
	
	/** Returns if the word is in the trie. */
    public boolean search(String word) 
    {
    	if(word == null || word.trim().length() == 0) return false;
    	String trimmed = word.trim();
    	Queue<WordDictionary> queue = new LinkedList<>();    	
    	queue.add(this);
    	
    	for(int i = 0; i < trimmed.length(); ++i)
		{
			if(trimmed.charAt(i) == '.')
			{
				queue = addAllSubNodes(queue);
			}
			else
			{
				queue = addNodesWithChar(queue, trimmed.charAt(i));
			}
		}
    	    	
    	return checkword(queue);
    }

	private boolean checkword(Queue<WordDictionary> queue) 
	{
		while(!queue.isEmpty())
		{
			WordDictionary node = queue.poll();
			
			if(node.isAWord) return true;
		}		
		return false;
	}

	private Queue<WordDictionary> addNodesWithChar(Queue<WordDictionary> queue, char curChar) 
	{
		Queue<WordDictionary> retQueue = new LinkedList<>();
		
		while(!queue.isEmpty())
		{
			WordDictionary node = queue.poll();
			
			if(node.subNodes[curChar - 'a'] != null) retQueue.add(node.subNodes[curChar - 'a']);
		}		
		return retQueue;
	}

	private Queue<WordDictionary> addAllSubNodes(Queue<WordDictionary> queue) 
	{
		Queue<WordDictionary> retQueue = new LinkedList<>();
		
		while(!queue.isEmpty())
		{
			WordDictionary node = queue.poll();
			
			for(int i = 0; i < 25; ++i)
			{
				if(node.subNodes[i] != null) retQueue.add(node.subNodes[i]);
			}
		}		
		return retQueue;
	}

	public static void main(String[] args)
	{
		WordDictionary dict = new WordDictionary();
		
		dict.addWord("bad");
		dict.addWord("dad");
		dict.addWord("mad");
		
		System.out.println(dict.search("b.."));
	}
}
