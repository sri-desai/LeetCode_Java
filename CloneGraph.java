import java.util.HashMap;

public class CloneGraph
{
	private HashMap<Integer, UndirectedGraphNode> hashMap;
	
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) 
	{
        hashMap = new HashMap<>();
        
        return getNewNode(node);
    }

	private UndirectedGraphNode getNewNode(UndirectedGraphNode node) 
	{
		if(node == null) return null;
		
		UndirectedGraphNode retNode;
		
		if(hashMap.containsKey(node.label))
		{
			retNode = hashMap.get(node.label);
			
			return retNode;
		}
			
		retNode = new UndirectedGraphNode(node.label);
		
		hashMap.put(node.label, retNode);
		
		for(UndirectedGraphNode neighbor : node.neighbors)
		{
			retNode.neighbors.add(getNewNode(neighbor));
		}
				
		return retNode;
	}
}
