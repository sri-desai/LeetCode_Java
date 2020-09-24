import java.util.Stack;

public class MinStack 
{
	private Stack<Integer> elemStack;
	private Stack<Integer> minStack;
	
	public MinStack() 
	{
        elemStack = new Stack<>();
        minStack  = new Stack<>();
    }
	
	public void push(int x) 
	{
		elemStack.push(x);
		
		if(minStack.isEmpty() || minStack.peek() >= x) minStack.push(x);
    }
	
	public void pop() 
	{
		if(minStack.peek().equals(elemStack.peek()))	minStack.pop();
		
		elemStack.pop();
    }
	
	public int top() 
	{
		return elemStack.peek();
    }
	
	public int getMin() 
	{
		return minStack.peek();
    }
	
	
	public static void main(String[] args)
	{
		MinStack obj = new MinStack();
		
		obj.push(512);
		obj.push(-1024);
		obj.push(-1024);
		obj.push(512);
		
		obj.pop();
		
		System.out.println(obj.getMin());
		
		obj.pop();
		
		System.out.println(obj.getMin());
		
		obj.pop();
		
		System.out.println(obj.getMin());
	}
}
