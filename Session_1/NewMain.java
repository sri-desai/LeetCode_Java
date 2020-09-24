
import java.awt.List;
import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class EmployeeNode 
{
     String val;
     EmployeeNode manager;
     EmployeeNode(String x) { val = x; }
}

public class NewMain 
{
	public static void main(String[] args) throws IOException 
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	    String s;
	    while ((s = in.readLine()) != null)
	    {
	      String[] array = s.split(",");
	      
	      HashMap<String, EmployeeNode> employees = constructSet(array);	
	      
	      System.out.println(getCommonManager(employees, array[array.length - 2], array[array.length - 1]));
	    }
	}

	private static String getCommonManager(HashMap<String, EmployeeNode> employeesList, 
			                               String firstPerson, String secondPerson)
	{
		
		String commonManager = null;
		
		Queue<String> firstQueue = getList(employeesList, firstPerson);
		Queue<String> secondQueue = getList(employeesList, secondPerson);
		
		while(!firstQueue.isEmpty())
		{
			String head = firstQueue.poll();
			
			if(secondQueue.contains(head))
			{
				commonManager = head;
				
				break;
			}
		}
		
		return commonManager;
	}
	
	public static Queue<String> getList(HashMap<String, EmployeeNode> employeesList, String person)
	{
		Queue<String> queue = new LinkedList<>();
		
		String personToGet = person;
		
		while(employeesList.containsKey(personToGet))
		{
			queue.add(personToGet);
			
			personToGet = employeesList.get(personToGet).manager == null ? null : employeesList.get(personToGet).manager.val;
		}
		
		return queue;
		
	}
	

	private static HashMap<String, EmployeeNode> constructSet(String[] employees) 
	{
	
		HashMap<String, EmployeeNode> map = new HashMap();
		
		for(int i = 0; i < employees.length - 2; ++i)
		{
			String[] relation = employees[i].split("->");
			String manager = relation[0];
			String person = relation[1];
			
			EmployeeNode managerNode = new EmployeeNode(manager);
			EmployeeNode personNode = new EmployeeNode(person);
			
			if(map.containsKey(manager))
			{
				personNode.manager = map.get(manager);
				map.put(person, personNode);
			}
			else
			{
				personNode.manager = managerNode;
				map.put(manager, managerNode);
				map.put(person, personNode);
			}
			
		}
				
		return map;
	}
}
