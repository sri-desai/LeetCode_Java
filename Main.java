import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main 
{
    
    static List<String> tokenize(String text, String regex)
    {
        Pattern p = Pattern.compile( regex , Pattern.DOTALL);
        Matcher m = p.matcher( text );
        List<String> l = new ArrayList<>();
        while ( m.find() ){
            l.add(m.group());
        }
        return l;
    }
    
    static String keyString( List l, String sep)
    {
        StringBuffer buf = new StringBuffer();
        for ( Object o : l ){
            buf.append( o ).append(sep);
        }
        String s = buf.toString();
        return s.substring(0,s.length());
    }
    
   static void divideString( String[] s )
   {
        String previousKey = "" ;
        String previousValue = "" ;
        for ( String item : s ){
            List words = tokenize( item.toLowerCase() , "[a-z0-9]+");
            String key = keyString( words , " " );
            if ( key.indexOf( previousKey ) < 0 ||
            ( previousKey.equals(key) &&  item.length() > previousValue.length() ) ){
                continue;
            }
            previousKey = key ;
            previousValue = item ;
        }
        System.out.println(previousValue);
    }    
    
  public static void main(String[] args) throws IOException 
  {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String s;
    while ((s = in.readLine()) != null)
    {
        String[] str = s.split("\\|");
        
        divideString(str);
    }
    
  }
}