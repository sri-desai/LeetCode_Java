
public class LicenseKeyFormatting 
{
	public String licenseKeyFormatting(String S, int K) 
	{
		if(S == null || S.length() == 0)
		{
			return S;
		}
		
		StringBuffer sbuffer = new StringBuffer();
		
		for(int i = 0; i < S.length(); ++i)
		{
			if(S.charAt(i) != '-')
			{
				if(S.charAt(i) >= 'a' && S.charAt(i) <= 'z')
				{
					sbuffer.append((char)(S.charAt(i) - 'a' + 'A'));
				}
				else
				{
					sbuffer.append(S.charAt(i));
				}
			}
		}
		
		int dashCount = K;
		
		for(int i = sbuffer.length() - 1; i > 0; --i)
		{
			if(dashCount == 1)
			{
				sbuffer.insert(i, '-');
				
				dashCount = K;
			}
			else
			{
				--dashCount;
			}
		}
		
		return sbuffer.toString();
    }
	
	public static void main(String[] args)
	{
		System.out.println(new LicenseKeyFormatting().licenseKeyFormatting("-----------", 100));
	}
}
