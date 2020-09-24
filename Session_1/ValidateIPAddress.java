
public class ValidateIPAddress 
{
	public String validIPAddress(String IP) 
	{
		String[] ipAddress = IP.split("\\.");
		
		if(ipAddress.length == 4 && IP.charAt(0) != '.' && IP.charAt(IP.length() - 1) != '.')
		{
			boolean isValid = true;
			
			for(int i = 0; i < ipAddress.length && isValid; ++i)
			{
				isValid &= validateIpv4(ipAddress[i]);
			}
			
			return isValid ? "IPv4" : "Neither";
		}
		
		ipAddress = IP.split(":");
		if(ipAddress.length == 8 && IP.charAt(0) != ':' && IP.charAt(IP.length() - 1) != ':')
		{
			boolean isValid = true;
			
			for(int i = 0; i < ipAddress.length && isValid; ++i)
			{
				isValid &= validateIpv6(ipAddress[i]);
			}
			
			return isValid ? "IPv6" : "Neither";
		}
		else
		{
			return "Neither";
		}
		
		
    }

	private boolean validateIpv6(String string) 
	{
		if(string.trim().length() == 0 || string.trim().length() > 4) return false;
		
		string = string.trim().toLowerCase();
		
		for(int i = 0; i < string.length(); ++i)
			if((string.charAt(i) < '0' || string.charAt(i) > '9') && (string.charAt(i) <'a'  || string.charAt(i) > 'f')) return false;
		
		return true;
	}

	private boolean validateIpv4(String string) 
	{
		if(string.trim().length() == 0 || string.trim().length() > 3) return false;
				
		int number = 0;
		for(int i = 0; i < string.length(); ++i)
		{
			if(string.charAt(i) == '0' && i == 0 && string.length() > 1) return false;
			if(string.charAt(i) < '0' || string.charAt(i) > '9') return false;
			number = number * 10 + string.charAt(i) - '0';
		}
		
		return number >= 0 && number <= 255 ? true : false; 
	}

	public static void main(String[] args)
	{
		System.out.println(new ValidateIPAddress().validIPAddress("00.0.0.0"));
	}
}
