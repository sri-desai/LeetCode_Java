public class CopyListwithRandomPointer 
{
	public RandomListNode copyRandomList(RandomListNode head) 
    {
		RandomListNode curNode = head;
		RandomListNode newHead = null;
		RandomListNode curDNode = null;
		
		if(head == null) return null;
		
		/* create duplicate nodes */
		while(curNode != null)
		{
			RandomListNode tempNode = new RandomListNode(curNode.label);
			
			tempNode.next = curNode.next;
			curNode.next  = tempNode;
			
			curNode = curNode.next.next;
		}
		
		/* create random pointers for duplicate nodes */
		curNode = head;		
		while(curNode != null)
		{
			curNode.next.random = curNode.random == null ? null : curNode.random.next;
			
			curNode = curNode.next.next;
		}
		
		/* bring back original list */
		curNode = head;
		newHead = curNode.next;
		curDNode = newHead;
		while(curNode != null)
		{
			curNode.next =  curNode.next == null ? null :  curNode.next.next;
			curNode = curNode.next;
			curDNode.next = curDNode.next == null ? null : curDNode.next.next;			
			curDNode = curDNode.next;
		}
		
		return newHead;		
    }

	
	public static void main(String[] args)
	{
		RandomListNode head = new RandomListNode(-1);
		head.next           = new RandomListNode(1);
		
		head = new CopyListwithRandomPointer().copyRandomList(head);
		
		while(head != null)
		{
			System.out.println(head.label);
			
			head = head.next;
		}
	}
}
