
public class UTFValidation 
{
	public boolean validUtf8(int[] data) 
	{
		if(data == null || data.length == 0) return true;
		
		int totalCount = validateFirstByte((char)data[0]);
		
		if(totalCount < 0 || totalCount + 1 != data.length) return false;
		
		for(int i = 1; i < totalCount; ++i)
		{
			if(!checkValidPrefix((char)data[i])) return false;
		}
		
		return true;
		
    }

	private boolean checkValidPrefix(char curByte)
	{
		return (curByte & (1 << 7)) > 0 && (curByte & (1 << 6)) == 0;
	}

	private int validateFirstByte(char headerByte) 
	{
		int byteCount = 0;
		
		int bitPos = 7;
		
		while(bitPos >= 0 && (headerByte & (1 << bitPos)) > 0)
		{
			++byteCount;
			
			--bitPos;
		}
		
		return bitPos < 0 ? -1 : byteCount;
	}
	
	public static void main(String[] args)
	{
		int[] array = {230,136,145};
		
		System.out.println(new UTFValidation().validUtf8(array));
	}
}
