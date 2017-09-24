import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrder 
{		
	public List<List<Integer>> levelOrder(TreeNode root) 
	{
		List<List<Integer>> mainList = new ArrayList<>();
		
		populateList(root, 0, mainList);
		
		return mainList;
    }
	
	private void populateList(TreeNode root, int curLevel, 
			                  List<List<Integer>> mainList)
	{
		if(root == null) return;
		
		if(curLevel == mainList.size())
		{
			mainList.add(new ArrayList<>());
		}
		
		mainList.get(curLevel).add(root.val);
		
		populateList(root.left,  curLevel + 1, mainList);
		populateList(root.right, curLevel + 1, mainList);
		
	}





	public static void main(String[] args)
	{
		TreeNode root = new TreeNode(3);
		
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		
		System.out.println(new BinaryTreeLevelOrder().levelOrder(root));
	}
}
