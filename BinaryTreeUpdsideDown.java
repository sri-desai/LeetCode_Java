import java.util.ArrayList;
import java.util.List;

public class BinaryTreeUpdsideDown 
{
	public TreeNode upsideDownBinaryTree(TreeNode root) 
	{
		List<List<TreeNode>> nodesLevelList = new ArrayList<>();
		
		getLevelOrder(root, 0, nodesLevelList);
		
		return createNewUpsideDownTree(nodesLevelList, nodesLevelList.size() - 1);
    }

	private TreeNode createNewUpsideDownTree(List<List<TreeNode>> nodesLevelList, int curLevel) 
	{
		if(curLevel < 0) return null;
		
		TreeNode newParentNode = nodesLevelList.get(curLevel).get(0);
		
		newParentNode.left = nodesLevelList.get(curLevel).size() == 1 ? null : 
							 nodesLevelList.get(curLevel).get(1);
		
		newParentNode.right = createNewUpsideDownTree(nodesLevelList, curLevel - 1);
		
		return newParentNode;
	}

	private void getLevelOrder(TreeNode root, int curLevel, List<List<TreeNode>> nodesLevelList)
	{
		if(root == null) return;
		
		if(curLevel == nodesLevelList.size())
		{
			nodesLevelList.add(new ArrayList<>());
		}
		
		nodesLevelList.get(curLevel).add(root);
		
		getLevelOrder(root.left,  curLevel + 1, nodesLevelList);
		getLevelOrder(root.right, curLevel + 1, nodesLevelList);		
	}

	
}
