
public class ReverseNodesinkGroup
{
	private ListNode newHead;
	
	 public ListNode reverseKGroup(ListNode head, int k) 
	 {
		 if(head == null || k <= 1) return head;
		 
		 int count = countNodes(head);
		 
		 if(count < k) return head;
		 
		 newHead = null;
		 
		 reverseGroup(head, 0, count, k);
		 
		 return newHead;
	 }

	private ListNode reverseGroup(ListNode head, int curCount, int totalCount, int groupCount) 
	{
		if(curCount == totalCount || head == null) return null;
		if(totalCount - curCount < groupCount) return head;
		
		ListNode tailNode = head;
		
		ListNode curNode = head;
		ListNode prevNode = null;
		ListNode nextNode = curNode.next;
		int count = groupCount;
		
		while(count-- > 0)
		{
			curNode.next = prevNode;
			prevNode = curNode;
			curNode = nextNode;
			nextNode = nextNode != null ? nextNode.next : null;
		}
		
		if(newHead == null) newHead = prevNode;
		
		tailNode.next = reverseGroup(curNode, curCount + groupCount, totalCount, groupCount);		
		
		 return prevNode;
	}

	private int countNodes(ListNode head) 
	{
		int count = 0;
		
		while(head != null)
		{
			++count;
			
			head = head.next;			
		}
		
		return count;
	}

	public static void printNodes (ListNode head)
	{
		while(head != null)
		{
			System.out.println(head.val);
			
			head = head.next;
		}
	}
	
	public static void main(String[] args)
	{
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		
		printNodes(new ReverseNodesinkGroup().reverseKGroup(head, 2));
	}
}
