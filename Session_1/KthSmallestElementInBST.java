import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class KthSmallestElementInBST 
{
	int kValue;
	int value;
	
	private void getHeapPopulated(TreeNode root, PriorityQueue<Integer> minHeap)
	{
		if(root == null)
		{
			return;
		}
		else
		{
			minHeap.add(root.val);
			getHeapPopulated(root.left, minHeap);
			getHeapPopulated(root.right, minHeap);
		}
	}
	
	public int minHeap(TreeNode root, int kValue)
	{
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
			
		getHeapPopulated(root, minHeap);
		
		while(--kValue > 0)
		{
			minHeap.remove();
		}
		
		return minHeap.peek();
	}

	public int array(TreeNode root, int kValue)
	{
		List<Integer> list = new ArrayList<>();
		
		getInorder(root, list);
		
		return list.get(kValue - 1);
	}
	
	private void getInorder(TreeNode root, List<Integer> list) 
	{
		if(root == null)
		{
			return;
		}
		else
		{
			getInorder(root.left, list);
			list.add(root.val);
			getInorder(root.right, list);
		}
	}

	public int effecientSoln(TreeNode root, int kValue)
	{
		this.kValue = kValue;
		
		getPopulated(root);
		
		return value;
	}
	
	private void getPopulated(TreeNode root) 
	{
		if(root == null) return;
						
		getPopulated(root.left);
		
		if(this.kValue-- == 1)
		{
			value = root.val;
			
			return;
		}	
		getPopulated(root.right);
	}

	public static void main(String[] args)
	{
		TreeNode root = new TreeNode(20);
		root.left = new TreeNode(10);
		root.right = new TreeNode(30);
		
		System.out.println(new KthSmallestElementInBST().effecientSoln(root, 3));
	}
}
