import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ReconstructItinerary
{
	public List<String> findItinerary(String[][] tickets) {
	    for (String[] ticket : tickets)
	        targets.computeIfAbsent(ticket[0], k -> new PriorityQueue()).add(ticket[1]);
	    visit("JFK");
	    return route;
	}

	Map<String, PriorityQueue<String>> targets = new HashMap<>();
	List<String> route = new LinkedList<String>();

	void visit(String airport) {
	    while(targets.containsKey(airport) && !targets.get(airport).isEmpty())
	        visit(targets.get(airport).poll());
	    route.add(0, airport);
	}
	
	public static void main(String[] args)
	{
		String[][] tickets = {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}
		                     };
		
		System.out.println(new ReconstructItinerary().findItinerary(tickets));
	}
}
