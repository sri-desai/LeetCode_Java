
public class GenerateBST
{
	public TreeNode sortedListToBST(ListNode head) 
	{
		if(head == null)
		{
			return null;
		}
		
		return populateTree(head, null);
    }

	private TreeNode populateTree(ListNode head, ListNode tail) 
	{
		if(head == tail)
		{
			return null;
		}
		
		ListNode fastPtr = head;
		ListNode slowPtr = head;
		
		while(fastPtr != tail && fastPtr.next != tail)
		{
			fastPtr = fastPtr.next.next;
			
			slowPtr = slowPtr.next;
		}
		
		TreeNode root = new TreeNode(slowPtr.val);
		root.left     = populateTree(head, slowPtr);
		root.right    = populateTree(slowPtr.next, tail);
		
		return root;		
	}
	
	
}
