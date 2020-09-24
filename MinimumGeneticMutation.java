import java.util.HashSet;
import java.util.Set;

public class MinimumGeneticMutation 
{
	public int minMutation(String start, String end, String[] bank) 
	{
		if(start == null || end == null) return -1;
		if(start.equals(end))            return 0;
		
		Set<Integer> visitedIndexes = new HashSet<>();
		
		int minMutationVal = minChangesToGenes(start, end, bank, 0, visitedIndexes);
		
		return minMutationVal == Integer.MAX_VALUE ? -1 : minMutationVal;
    }

	private int minChangesToGenes(String startGene, String endGene, String[] bank, 
			                      int curMutations, Set<Integer> visitedIndexes) 
	{
		if(startGene.equals(endGene)) return curMutations;
		
		int minMutation = Integer.MAX_VALUE;
		
		for(int curBankGeneIdx = 0; curBankGeneIdx < bank.length; ++curBankGeneIdx)
		{
			if(!visitedIndexes.contains(curBankGeneIdx) && 
				isOneMutation(startGene, bank[curBankGeneIdx])
			  )
			{
				visitedIndexes.add(curBankGeneIdx);
				
				minMutation = Math.min(minMutation, 
						               minChangesToGenes(bank[curBankGeneIdx], endGene, bank, 
						            		             curMutations + 1, visitedIndexes
						            		            )
						              );		
				
				visitedIndexes.remove(curBankGeneIdx);
			}
		}
		
		return minMutation;
	}

	private boolean isOneMutation(String startGene, String endGene) 
	{
		int   curChanges = 0;
		
		for(int curGeneIdx = 0; curGeneIdx < startGene.length(); ++curGeneIdx)
		{
			if(startGene.charAt(curGeneIdx) != endGene.charAt(curGeneIdx)) ++curChanges;
			
			if(curChanges > 1) return false;
		}
		
		return true;
	}

	public static void main(String[] args)
	{
		String[] bank = {"AAAACCCC", "AAACCCCC", "AACCCCCC"};
		
		System.out.println(new MinimumGeneticMutation().minMutation("AAAAACCC", "AACCCCCC", bank));
	}
}
