package Random;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Test {
   public static void main(String args[]){
	    Map<String,Set<String>> m = new HashMap<String, Set<String>>();
	    Set<String> s1 = new HashSet<String>();
	    s1.add("tanmay");s1.add("mehrotra");
	    Set<String> s2 = new HashSet<String>();
	    s2.add("tanmay1");s2.add("mehrotra1");
	    Set<String> s3 = new HashSet<String>();
	    m.put("t", s1);m.put("h", s2);m.put("d", s3);
	    for(String s : m.get("d")){
	    	System.out.println(s);
	    }
	    
   }
}