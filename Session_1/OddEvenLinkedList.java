
public class OddEvenLinkedList 
{
	public ListNode oddEvenList(ListNode head) 
	{
       if(head == null || head.next == null || head.next.next == null)
       {
    	   return head;
       }
       
       boolean isOdd     = true;
       ListNode oddHead  = head;
       ListNode oddTail  = oddHead;
       ListNode evenHead = head.next;
       ListNode evenTail = evenHead;
       ListNode curNode  = evenTail.next;
       ListNode prevTail = null;
       
       oddTail.next  = null;
       evenTail.next = null;
       
       while(curNode != null)
       {
    	   if(isOdd)
    	   {
    		   oddTail = appendNode(curNode, oddTail);
    		   
    		   prevTail = oddTail;
    	   }
    	   else
    	   {
    		   evenTail = appendNode(curNode, evenTail);
    		   
    		   prevTail = evenTail;
    	   }    	   
    	   
    	   curNode = curNode.next;
    	   
    	   prevTail.next = null;
    	   
    	   isOdd = !isOdd;
    	   
       }
       
       oddTail.next = evenHead;
       
       return oddHead;
       
    }
	
	private ListNode appendNode (ListNode nodeToAppend, ListNode tailNode)
	{
		tailNode.next = nodeToAppend;
		tailNode = tailNode.next;
		return tailNode;
	}
	
	public static void main(String[] args)
	{
		ListNode head  = new ListNode(10);
		head.next      = new ListNode(20);
		head.next.next = new ListNode(30);
		head.next.next.next = new ListNode(40);
		
		head = new OddEvenLinkedList().oddEvenList(head);
		
		return;
	}
}
