import java.util.ArrayList;
import java.util.List;

public class BinaryTreeTraversal 
{
	List<List<Integer>> list;
	
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) 
	{
		list = new ArrayList<>();
		
		if(root == null)
		{
			return list;
		}
		
		generateList(root, 0);
		
		return list;
    }

	
	private void generateList(TreeNode root, int level)
	{
		if(root == null)
		{
			return;
		}
		
		if(list.size() <= level)
		{
			List<Integer> curLevel = new ArrayList<>();
			
			curLevel.add(root.val);
			
			list.add(curLevel);
		}
		else
		{
			List<Integer> curLevel = list.get(level);
			
			if((level & 1) == 0)
			{
				curLevel.add(root.val);
			}
			else
			{
				curLevel.add(0, root.val);
			}
		}
		
		generateList(root.left,  level + 1);
		generateList(root.right, level + 1);
				
	}
	
	public static void main(String[] args)
	{
		TreeNode root = new TreeNode(3);
		
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		
		System.out.println(new BinaryTreeTraversal().zigzagLevelOrder(root));
	}
}
