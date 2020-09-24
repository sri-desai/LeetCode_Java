import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class SentenceSimilarity 
{
	public boolean areSentencesSimilarTwo(String[] words1, String[] words2, 
			                              String[][] pairs) 
	{
		if(words1 == null && words2 == null) 
			return true;
		
		if(words1 == null || words2 == null || words1.length != words2.length)
			return false;
		
		Map<String, List<String>> similarWordsMap = new HashMap<>();
		
		for(String[] curPair : pairs)
		{
			if(!similarWordsMap.containsKey(curPair[0]))
			{
				similarWordsMap.put(curPair[0], new ArrayList<>());
			}
			
			if(!similarWordsMap.containsKey(curPair[1]))
			{
				similarWordsMap.put(curPair[1], new ArrayList<>());
			}
			
			similarWordsMap.get(curPair[0]).add(curPair[1]);
			similarWordsMap.get(curPair[1]).add(curPair[0]);
		}
		
		for(int wordIdx = 0; wordIdx < words1.length; ++wordIdx)
		{
			if(!isSimilarWord(words1[wordIdx], words2[wordIdx], similarWordsMap))
				return false;
		}
		
		return true;
    }

	private boolean isSimilarWord(String firstWord, String secondWord, 
			                      Map<String, List<String>> similarWordsMap) {

		if(firstWord.equals(secondWord)) return true;
		
		Set<String>   visitedWords = new HashSet<>();
		Queue<String> wordsToVisit = new LinkedList<>();
		
		wordsToVisit.offer(firstWord);
		
		while(!wordsToVisit.isEmpty())
		{
			String curWord = wordsToVisit.poll();
			
			visitedWords.add(curWord);
			
			if(curWord.equals(secondWord)) return true;
			
			if(similarWordsMap.containsKey(curWord))
			{
				for(String similarWord : similarWordsMap.get(curWord))
				{
					if(!visitedWords.contains(similarWord))
						wordsToVisit.add(similarWord);
				}
			}	
		}		
		
		return false;
	}
	
	public static void main(String[] args)
	{
		String[][] pairs = {
							{"great", "good"},
							{"fine", "good"},
							{"acting", "drama"},
							{"skills", "talent"},
						   };
		
		String[] words1 = {"great", "acting", "skills"};
		String[] words2 = {"fine", "drama1", "talent"};
		
		boolean areSimilar = new SentenceSimilarity().areSentencesSimilarTwo(words1, words2, pairs);
		
		System.out.println(areSimilar);
	}
}
