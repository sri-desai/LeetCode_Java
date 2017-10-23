import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestWordDistance 
{
	/* Effecient code */
	public int shortestWordDistanceEffecient(String[] words, String word1, String word2) 
	{
		long minDistance = Integer.MAX_VALUE;
		long word1Index  = Integer.MIN_VALUE;
		long word2Index  = Integer.MAX_VALUE;
		
		for(int curIdx = 0; curIdx < words.length; ++curIdx)
		{
			if(words[curIdx].equals(word1))
			{
				word1Index = curIdx;
			}
			
			if(words[curIdx].equals(word2))
			{
				if(word1.equals(word2))
				{
					word1Index = word2Index;
				}
				
				word2Index = curIdx;
			}
			
			minDistance = Math.min(minDistance, word2Index - word1Index);
		}
		
		return (int)minDistance;
    }
	
	/* ineffecient code */
	public int shortestWordDistance(String[] words, String word1, String word2) 
	{
		Map<String, List<Integer>> stringCount = new HashMap<>();
		
		for(int curIdx = 0; curIdx < words.length; ++curIdx)
		{
			if(!stringCount.containsKey(words[curIdx]))
			{
				stringCount.put(words[curIdx], new ArrayList<>());
			}
			
			stringCount.get(words[curIdx]).add(curIdx);
		}
		
		return getShortestDistance(stringCount.get(word1), stringCount.get(word2),
				                   word1.equals(word2));
    }

	private int getShortestDistance(List<Integer> word1List, List<Integer> word2List, 
			                        boolean isSameWord) 
	{
		if(word1List == null || word2List == null) return -1;
		
		int curMinDistance = Integer.MAX_VALUE;
		
		for(int word1ListIdx = 0; word1ListIdx < word1List.size(); ++word1ListIdx)
		{
			for(int word2ListIdx = 0; word2ListIdx < word2List.size(); ++word2ListIdx)
			{
				if(isSameWord && word1ListIdx == word2ListIdx) continue;
				
				curMinDistance = Math.min(curMinDistance, 
						        Math.abs(word1List.get(word1ListIdx) - word2List.get(word2ListIdx))
						                 );
			}
		}
		
		return curMinDistance;
	}
	
	public static void main(String[] args)
	{
		String[] words = {"practice", "makes", "perfect", "coding", "makes"};
		
		System.out.println(new ShortestWordDistance().shortestWordDistanceEffecient(words, "makes", "makes"));
	}
}
