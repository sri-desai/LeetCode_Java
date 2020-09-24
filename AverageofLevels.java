import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageofLevels 
{
	public List<Double> averageOfLevels(TreeNode root) 
	{
        double levelSum   = 0;
        int nodesCount = 0;
        Queue<TreeNode> nodes = new LinkedList<>();
        List<Double>    averages = new ArrayList<>();
        
        nodes.add(root);
        nodes.add(null);
        
        while(!nodes.isEmpty())
        {
        	TreeNode curNode = nodes.poll();
        	
        	if(curNode != null)
        	{
        		nodesCount++;
        		levelSum += curNode.val;
        		
        		if(curNode.left != null) nodes.add(curNode.left);
        		if(curNode.right != null) nodes.add(curNode.right);        		        		
        	}
        	else
        	{
        		if(!nodes.isEmpty()) nodes.add(null);
        		
        		averages.add(levelSum / nodesCount);
        		
        		levelSum = 0;
        		nodesCount = 0;
        	}
        }
        
        return averages;
    }
	
	public static void main(String[] args)
	{
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		
		System.out.println(new AverageofLevels().averageOfLevels(root));
	}
}
