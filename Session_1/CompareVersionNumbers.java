
public class CompareVersionNumbers 
{
	public int compareVersion(String version1, String version2) 
	{
		String versionV1[] = version1.split("\\.");
		String versionV2[] = version2.split("\\.");
		
		for(int i = 0; i < Math.max(versionV1.length, versionV2.length); ++i)
		{
			Integer v1 = i < versionV1.length ? Integer.parseInt(versionV1[i]) : 0;
			Integer v2 = i < versionV2.length ? Integer.parseInt(versionV2[i]) : 0;
			
			int diff;
			if((diff = v1.compareTo(v2)) != 0) return diff;
		}
		
		return 0;
    }
	
	public static void main(String[] args)
	{
		System.out.println(new CompareVersionNumbers().compareVersion("0.1", "000.1"));
	}
}
