import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreeLevelOrder 
{
	List<List<Integer>> mainList;
	
	public List<List<Integer>> levelOrderBottom(TreeNode root) 
	{
		mainList = new ArrayList<>();
		
		/*
		getPopulate(root, 0);
		
		Collections.reverse(mainList);
		*/
		
		alt_populate(root, 0);
		
		return mainList;
    }

	private void alt_populate(TreeNode root, int curLevel) 
	{
		if(root == null) return;
		
		List<Integer> curList;
		
		if(mainList.size() > curLevel)
		{
			curList = mainList.get(mainList.size() - curLevel - 1);
		}
		else
		{
			curList = new ArrayList<>();
			
			mainList.add(0, curList);
		}
		
		curList.add(root.val);
		
		alt_populate(root.left, curLevel + 1);
		alt_populate(root.right, curLevel + 1);		
	}

	private void getPopulate(TreeNode root, int curlevel) 
	{
		List<Integer> curList;
		
		if(root == null) return;
		
		if(mainList.size() == curlevel)
		{
			curList = new ArrayList<>();	
			
			mainList.add(curList);
		}
		else
		{
			curList = mainList.get(curlevel);
		}
		
		curList.add(root.val);
		
		getPopulate(root.left, curlevel + 1);
		getPopulate(root.right, curlevel + 1);
	}

	
	
	public static void main(String[] args)
	{
		TreeNode root = new TreeNode(3);
		
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		
		System.out.println(new BinaryTreeLevelOrder().levelOrderBottom(root));
	}
}
