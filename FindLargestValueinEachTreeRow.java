import java.util.ArrayList;
import java.util.List;

public class FindLargestValueinEachTreeRow 
{
	public List<Integer> largestValues(TreeNode root) 
	{
		List<Integer> list = new ArrayList<>();
		
		getLargestValues(root, 0, list);
		
		return list;
    }

	private void getLargestValues(TreeNode root, int curLevel, List<Integer> list) 
	{
		if(root == null)
		{
			return;
		}
		
		if(curLevel == list.size())
		{
			list.add(root.val);
		}
		else
		{
			list.add(curLevel, Math.max(list.remove(curLevel), root.val));
		}
		
		getLargestValues(root.left,  curLevel + 1, list);
		getLargestValues(root.right, curLevel + 1, list);
	}
	
	public static void main(String[] args)
	{
		TreeNode root = new TreeNode(10);
		root.left     = new TreeNode(20);
		root.right    = new TreeNode(30);
		
		System.out.println(new FindLargestValueinEachTreeRow().largestValues(root));
	}
}
