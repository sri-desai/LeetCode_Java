
public class ConvertANumberToHex 
{
	public String toHex(int num) 
	{
		if(num == 0) return "0";
		
		char[] mapping = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
		
		StringBuffer result = new StringBuffer();
		
		while(num != 0)
		{
			result.append(mapping[num & 15]);
			
			num >>>= 4;
		}
		
		return result.reverse().toString();
    }
	
	public static void main(String[] args)
	{
		System.out.println(new ConvertANumberToHex().toHex(-1));
	}
}
