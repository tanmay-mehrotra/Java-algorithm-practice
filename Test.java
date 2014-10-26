package Random;

import java.util.ArrayList;
import java.util.Collections;

public class Test {
   public static void main(String args[]){
	   System.out.println(Character.codePointAt("テ", 0));
	   System.out.println("thit".substring(3,4));
	   ArrayList<Integer> tmp = new ArrayList<Integer>();
	   tmp.add(1);
	   System.out.println(Collections.max(tmp));
   }
}
