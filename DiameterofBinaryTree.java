import java.util.HashSet;

public class DiameterofBinaryTree
{
	int curMax = 0;
	
	public int diameterOfBinaryTree(TreeNode root) 
    {
		getDiameter(root);
		
		return curMax - 1;
    }

	private int getDiameter(TreeNode root) 
	{
		if(root == null) return 0;
		
		int leftPath  = getDiameter(root.left);
		int rightPath = getDiameter(root.right);
		
		curMax = Math.max(curMax, 1 + leftPath + rightPath);
		
		return 1 + Math.max(leftPath, rightPath);		
	}
	
	 public boolean isHappy(int n) 
	 {
		 HashSet<Integer> set = new HashSet<>();
		 
		 if(n < 0) n = n * -1;
		 
		 while(n > 1)
		 {
			 if(set.contains(n)) return false;
			 
			 set.add(n);
			 
			 int temp = n;
			 int sum = 0;
			 
			 while(temp != 0)
			 {
				 sum += ((temp % 10) * (temp % 10));
				 
				 temp = temp / 10;
			 }			
			 
			 n = sum;
		 }
		 
		 return n == 1 ? true : false;
	 }
	 
	 public static void main(String[] args)
	 {
		 System.out.println(new DiameterofBinaryTree().isHappy(19));
	 }
}
