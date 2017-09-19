import java.util.HashMap;

class TreeLinkNode 
{
	 int val;
	 TreeLinkNode left, right, next;
	 TreeLinkNode(int x) { val = x; }
}

public class NextPointer 
{	
	public void connect(TreeLinkNode root) 
	{
		TreeLinkNode nextLevelPtr = root;
		TreeLinkNode beginNodePtr = null;
		TreeLinkNode curRoot      = null;
		
		if(root == null)
			return;
				
		do
		{
			curRoot      = nextLevelPtr;
			nextLevelPtr = null;
			beginNodePtr = null;
			
			for(TreeLinkNode curNode = curRoot; curNode != null; curNode = curNode.next)
			{
				/* set the beginPtr */
				beginNodePtr = beginNodePtr == null ? (curNode.left != null ? curNode.left : curNode.right) : beginNodePtr;
				
				/* set the nextLevelPtr */
				if(beginNodePtr == null)
					continue;
				else
					nextLevelPtr = nextLevelPtr == null ? beginNodePtr : nextLevelPtr;
				
				/* set the next of beginPtr */
				if(beginNodePtr == curNode.left)
				{
					beginNodePtr.next = curNode.right != null ? curNode.right : beginNodePtr.next;
				}
				else
				if(beginNodePtr == curNode.right)
				{
					;
				}
				else
				{
					beginNodePtr.next = curNode.left != null ? curNode.left : (curNode.right != null ? curNode.right : beginNodePtr.next);
				}
				
				/* Increment the beginNodePtr */
				beginNodePtr = beginNodePtr.next != null ? beginNodePtr.next : beginNodePtr;								
			}
						
		}while(nextLevelPtr != null);					
    }
	
	public static void main(String[] args)
	{
		TreeLinkNode root = new TreeLinkNode(1);
		/*
		root.left = new TreeLinkNode(2);
		root.right = new TreeLinkNode(3);
		
		root.left.left = new TreeLinkNode(4);
		root.left.right = new TreeLinkNode(5);
		
		root.right.right = new TreeLinkNode(7);
		*/
		
		root.right = new TreeLinkNode(2);
		
		
		new NextPointer().connect(root);
		
		return;
	}
}
