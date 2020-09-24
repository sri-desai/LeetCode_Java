import java.util.ArrayList;
import java.util.List;

public class PathSumIII 
{
	int totalCount = 0;
	
	public int pathSum(TreeNode root, int sum) 
	{
		List<Integer> list = new ArrayList<>();
		
		populatePaths(root, sum, list);
		
		return totalCount;
		
    }

	private void populatePaths(TreeNode root, int sum, List<Integer> list) 
	{
		if(root == null) return;
		
		list.add(root.val);
		
		int curSum = 0;
		
		for(int i = list.size() - 1; i >= 0; --i)
		{
			curSum += list.get(i);
			
			if(curSum == sum) ++totalCount;
		}
		
		populatePaths(root.left, sum, list);
		populatePaths(root.right, sum, list);
		
		list.remove(list.size() - 1);
	}
	
	public static void main(String[] args)
	{
		TreeNode root = new TreeNode(10);
		root.left     = new TreeNode(5);
		root.right    = new TreeNode(-3);
		root.left.left = new TreeNode(3);
		
		System.out.println(new PathSumIII().pathSum(root, 8));
	}
}
