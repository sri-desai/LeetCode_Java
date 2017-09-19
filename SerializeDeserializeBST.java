import java.util.LinkedList;

public class SerializeDeserializeBST
{
	public String serialize(TreeNode root) 
	{
		StringBuffer sbuff = new StringBuffer();
		
		getSerialize(root, sbuff);
		
		return sbuff.toString();
    }

    private void getSerialize(TreeNode root, StringBuffer sbuff) 
    {
		if(root == null)
		{
			sbuff.append("#!");
			
			return;
		}
		
		sbuff.append(root.val + "!");
		getSerialize(root.left, sbuff);
		getSerialize(root.right, sbuff);
	}

	// Decodes your encoded data to tree.
    public TreeNode deserialize(String data) 
    {
       String[] buffer = data.split("!");
       LinkedList<String> list = new LinkedList<>();
       
       for(String str : buffer)
       {
    	   list.add(str);
       }
       
       return getDeserialize(list);
    }

	private TreeNode getDeserialize(LinkedList<String> list) 
	{
		String value = list.poll();
		
		if(value.equals("#"))
		{
			return null;
		}
		else
		{
			TreeNode root = new TreeNode(Integer.parseInt(value));
			root.left     = getDeserialize(list);
			root.right    = getDeserialize(list);
			
			return root;
		}
	}

	public static void main(String[] args)
	{
		TreeNode root = new TreeNode(20);
		root.right    = new TreeNode(30);
		
		String  str = new SerializeDeserializeBST().serialize(root);
               root = new SerializeDeserializeBST().deserialize(str);
		
		return;
	}
}