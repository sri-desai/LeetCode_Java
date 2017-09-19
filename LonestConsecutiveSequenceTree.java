
public class LonestConsecutiveSequenceTree 
{
	private int maxLen = 0;
	
	public int longestConsecutive(TreeNode root) 
	{		
		if(root != null)
		populateMaxLen(root, root.val, 1);
		
		return maxLen;
    }

	private void populateMaxLen(TreeNode root, int val, int curMax) 
	{
		maxLen = Math.max(maxLen, curMax);
		if(root == null) return;
		
		curMax = root.val == val + 1 ? curMax + 1 : 1;
		
		populateMaxLen(root.left, root.val, curMax);
		populateMaxLen(root.right, root.val, curMax);		
	}
}
