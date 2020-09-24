
public class ConstructStringfromBinaryTree
{
	public String tree2str(TreeNode t) 
	{
		if(t == null) return "()";
		
		StringBuilder stringRep = new StringBuilder();
		
		getStringFromTree(t, stringRep);
		
		return stringRep.toString().substring(1, stringRep.length() - 1);
    }
	
	private boolean isLeafNode(TreeNode rootNode)
	{
		return rootNode.left == null && rootNode.right == null;
	}

	private void getStringFromTree(TreeNode rootNode, StringBuilder stringRep)
	{
		if(isLeafNode(rootNode))
		{
			stringRep.append("(");
			
			stringRep.append(rootNode.val);
			
			stringRep.append(")");
			
			return;
		}
		else
		{
			stringRep.append("(");
			
			stringRep.append(rootNode.val);
			
			if(rootNode.right != null && rootNode.left == null)
			{
				stringRep.append("(");
				
				stringRep.append(")");
				
				getStringFromTree(rootNode.right, stringRep);
			}
			else
			if(rootNode.right == null && rootNode.left != null)
			{
				getStringFromTree(rootNode.left, stringRep);
			}
			else
			{
				getStringFromTree(rootNode.left, stringRep);
				
				getStringFromTree(rootNode.right, stringRep);
			}
			
			stringRep.append(")");
			
			return;			
		}
	}

	public static void main(String[] args)
	{
		
	}
}
