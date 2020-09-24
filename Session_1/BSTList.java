import java.util.ArrayList;
import java.util.List;

public class BSTList 
{
	public List<List<Integer>> levelOrder(TreeNode root) 
	{
		List<List<Integer>> mainList = new ArrayList<>();
		
		if(root == null)
			return mainList;
		
		getList(root, mainList, 0);
		
		return mainList;
		
    }

	private void getList(TreeNode root, List<List<Integer>> mainList, int curLevel) 
	{		
		if(root == null)
			return;
		
		List<Integer> subList;
		
		if(curLevel == mainList.size())
		{
			subList = new ArrayList<>();
			
			mainList.add(subList);
		}
		else
		{
			subList = mainList.get(curLevel);
		}
		
		subList.add(root.val);
		
		getList(root.left, mainList, curLevel + 1);
		getList(root.right, mainList, curLevel + 1);
	}
	
	public static void main(String[] args)
	{
		TreeNode root = new TreeNode(3);
		
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.right = new TreeNode(7);
		root.right.left  = new TreeNode(15);
		
		System.out.println(new BSTList().levelOrder(root));
	}
}
