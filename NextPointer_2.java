
public class NextPointer_2 
{
	public void connect(TreeLinkNode root) 
	 {
		 TreeLinkNode curNode;
		 TreeLinkNode nextCurNode;
		 
		 curNode = root;
		 nextCurNode = null;
		 
		 while(curNode != null)
		 {
			 nextCurNode = getNextCurNode_chld(curNode);
			 
			 while(curNode != null)
			 {
				 if(curNode.left != null)
				 {
					 curNode.left.next = getNextNode_chld(curNode);
				 }
				 
				 if(curNode.right != null)
				 {
					 curNode.right.next = getNextCurNode_chld(curNode.next);
				 }
				
				 curNode = curNode.next;					 
			 }
			 
			 curNode = nextCurNode;
		 }
	 }

	private TreeLinkNode getNextNode_chld(TreeLinkNode curNode)
	{
		if(curNode == null) return null;
		
		if(curNode.right != null) return curNode.right;
		
		return getNextCurNode_chld(curNode.next);
	}

	private TreeLinkNode getNextCurNode_chld(TreeLinkNode curNode) 
	{
		while(curNode != null)
		{
			if(curNode.left  != null) return curNode.left;
			if(curNode.right != null) return curNode.right;
			
			curNode = curNode.next;
		}
		
		return curNode;
	}

	public static void main(String[] args)
	{
		TreeLinkNode root = new TreeLinkNode(1);
		
		root.left = new TreeLinkNode(2);
		root.right = new TreeLinkNode(2);	
		
		root.left.left = new TreeLinkNode(3);
		root.left.right = new TreeLinkNode(3);
		root.right.left = new TreeLinkNode(3);
		root.right.right = new TreeLinkNode(3);
		
		new NextPointer_2().connect(root);
		
		System.out.println(root);
	}
}
