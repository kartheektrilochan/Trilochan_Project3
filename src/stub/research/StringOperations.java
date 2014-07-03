package stub.research;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringOperations {
	public static void main(String[] args) {
		String a="getAddress1";
		String b="Address";
		String c="getAddress2";
		//System.out.println(a.compareToIgnoreCase(b));
		System.out.println(a.length());
		System.out.println(b.length());
		System.out.println(a.length()-b.length());
		System.out.println(c.length()-b.length());
		Pattern p=Pattern.compile("Address");
		Matcher  matcher = p.matcher("getAddress");
		//System.out.println(matcher.find());
		int count = 0;
        while (matcher.find())
        {
            count++;
        }
            System.out.println(count);
	}
	

}
