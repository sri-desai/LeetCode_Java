import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView 
{
	public List<Integer> rightSideView(TreeNode root) 
	{
        List<Integer> rightNodeValues = new ArrayList<>();
        
        populateListValues(root, 0, rightNodeValues);
        
        return rightNodeValues;
    }

	private void populateListValues(TreeNode root, int curLevel, 
			                        List<Integer> rightNodeValues)
	{
		if(root == null) return;
		
		if(curLevel == rightNodeValues.size())
		{
			rightNodeValues.add(root.val);
		}
		
		populateListValues(root.right, curLevel + 1, rightNodeValues);
		populateListValues(root.left, curLevel + 1, rightNodeValues);		
	}
}
