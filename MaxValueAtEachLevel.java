import java.util.ArrayList;
import java.util.List;

public class MaxValueAtEachLevel 
{
	public List<Integer> largestValues(TreeNode root) 
	{
		List<Integer> eachLevelMaxList = new ArrayList<>();
		
		getMaxValueAtEachLevel(root, 0, eachLevelMaxList);
		
		return eachLevelMaxList;
    }

	private void getMaxValueAtEachLevel(TreeNode root, int curLevel, List<Integer> eachLevelMaxList) 
	{
		if(root == null) return;
		
		if(curLevel == eachLevelMaxList.size())
		{
			eachLevelMaxList.add(root.val);
		}
		else
		{
			eachLevelMaxList.set(curLevel, Math.max(eachLevelMaxList.get(curLevel), root.val));
		}
			
		getMaxValueAtEachLevel(root.left,  curLevel + 1, eachLevelMaxList);
		getMaxValueAtEachLevel(root.right, curLevel + 1, eachLevelMaxList);
	}
}
