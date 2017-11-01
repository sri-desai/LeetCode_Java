import java.util.HashMap;
import java.util.Map;

public class CloneGraph
{
	private Map<Integer, UndirectedGraphNode> visitedNodsCloneMap;
	
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) 
	{
		visitedNodsCloneMap = new HashMap<>();
        
        return getClonedGraph(node);
    }

	private UndirectedGraphNode getClonedGraph(UndirectedGraphNode node) 
	{
		if(node == null) return null;
		
		UndirectedGraphNode retNode;
		
		if(visitedNodsCloneMap.containsKey(node.label))
		{
			retNode = visitedNodsCloneMap.get(node.label);
			
			return retNode;
		}
			
		retNode = new UndirectedGraphNode(node.label);
		
		visitedNodsCloneMap.put(retNode.label, retNode);
		
		for(UndirectedGraphNode neighbor : node.neighbors)
		{
			retNode.neighbors.add(getClonedGraph(neighbor));
		}
				
		return retNode;
	}
}
