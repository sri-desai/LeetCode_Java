
public class NextRightPointer
{
	public void connect(TreeLinkNode root) 
	{
		TreeLinkNode nextLevelStart;
		
		nextLevelStart = root;
		
		while(nextLevelStart != null)
		{
			TreeLinkNode curNode = nextLevelStart;
			
			nextLevelStart = getNextLevelStartNode(curNode);
			
			while(curNode != null)
			{
				if(curNode.left != null)
				{
					curNode.left.next = curNode.right != null ? curNode.right : 
						                getNextLevelStartNode(curNode.next);
				}
				
				if(curNode.right != null)
				{
					curNode.right.next = getNextLevelStartNode(curNode.next);
				}
				
				curNode = curNode.next;
			}
		}
    }

	private TreeLinkNode getNextLevelStartNode(TreeLinkNode curNode) 
	{
		while(curNode != null)
		{
			if(curNode.left != null) return curNode.left;
			if(curNode.right != null) return curNode.right;
			
			curNode = curNode.next;
		}
		
		return null;
	}
}
