import java.util.LinkedList;
import java.util.Queue;

public class Trie 
{
	boolean isAWord;
	
	Trie[] subNodes;
	
	public Trie()
	{
		isAWord  = false;
		subNodes = new Trie[26];		
	}
	
	public void insert(String word) 
	{
		String trimmed = word.trim();
		
		Trie curNode = this;
		
		for(int i = 0; i < trimmed.length(); ++i)
		{
			if(curNode.subNodes[trimmed.charAt(i) - 'a'] == null) 
				curNode.subNodes[trimmed.charAt(i) - 'a'] = new Trie();
					
			curNode = curNode.subNodes[trimmed.charAt(i) - 'a'];
		}
			
		curNode.isAWord = true;
    }
	
	/** Returns if the word is in the trie. */
    public boolean search(String word) 
    {
    	String trimmed = word.trim();
    	
    	Trie curNode = this;
    	
    	for(int i = 0; i < trimmed.length(); ++i)
		{
			if(curNode.subNodes[trimmed.charAt(i) - 'a'] == null)
				return false;
			
			curNode = curNode.subNodes[trimmed.charAt(i) - 'a'];
		}
    	
    	return curNode.isAWord;
    }
    
    public boolean startsWith(String prefix) 
    {
    	String trimmed = prefix.trim();
    	Queue<Trie> queue = new LinkedList<>();
    	
    	Trie curNode = this;
    	
    	for(int i = 0; i < trimmed.length(); ++i)
		{
			if(curNode.subNodes[trimmed.charAt(i) - 'a'] == null)
				return false;
			
			curNode = curNode.subNodes[trimmed.charAt(i) - 'a'];
		}
    	
    	queue.add(curNode);
    	
    	while(!queue.isEmpty())
    	{
    		Trie node = queue.remove();
    		
    		if(node.isAWord) return true;
    		
    		for(int i = 0; i < 26; ++i)
        	{
        		if(node.subNodes[i] != null) queue.add(node.subNodes[i]);        		
        	}    		    		
    	}
    	
    	return false;
    	
    }
	
	public static void main(String[] args)
	{
		Trie node = new Trie();
		
		node.insert("hello");
		
		System.out.println(node.search("hello"));
		
		System.out.println(node.startsWith("hell"));
	}
}


