import java.util.ArrayList;
import java.util.List;

public class PathSum 
{
	List<List<TreeNode>> mainList;	
	
	public List<List<Integer>> pathSum(TreeNode root, int sum) 
	{	
		mainList = new ArrayList<>();
		List<List<Integer>> retList = new ArrayList<>();
		
		calculateSum(root, sum);
				
		for(List<TreeNode> subList : mainList)
		{
			List<Integer> subInteger = new ArrayList<>();
			
			for(TreeNode node : subList)
			{
				subInteger.add(node.val);
			}
			
			retList.add(subInteger);
		}
		        
		return retList;
    }
	
	private void calculateSum(TreeNode root, int sum) 
	{
		if(root == null)
		{
			;
		}
		else
		if(root.left == null && root.right == null)
		{
			if(root.val == sum)
			{
				List<TreeNode> subList = new ArrayList<>();
				
				subList.add(root);
				
				mainList.add(subList);				
			}
									
		}
		else
		{
			calculateSum(root.left, sum - root.val);
			
			calculateSum(root.right, sum - root.val);
			
			if(mainList.size() > 0)
			{
				for(List<TreeNode> subList : mainList)
				{
					if( subList.size() > 0 && 
					    (subList.get(0) == root.left) || 
					    (subList.get(0) == root.right)
					  )
					{
						subList.add(0, root);
					}
				}
			}
			
		}
		
		return;
	}
	
	public static void main(String[] args)
	{
		/*
		TreeNode root = new TreeNode(5);
				
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		
		root.left.left = new TreeNode(11);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		root.right.right.left = new TreeNode(5);
		root.right.right.right = new TreeNode(1);
		*/
		
		TreeNode root = new TreeNode(-2);
		root.right = new TreeNode(-3);
		
		System.out.println(new PathSum().pathSum(root, -5));
	}
}
