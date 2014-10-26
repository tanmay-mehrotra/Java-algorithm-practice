package Random;

public class StringTest {
   public static void main(String args[]){
	   
	   StringBuffer a = new StringBuffer("tanmay");
	   StringBuffer b = new StringBuffer("mehrotra");
	   concatStr(a,b);
	   System.out.println(a);
	   int r = 2/3 *3;
	   System.out.println(r);
   }
   
   public static void concatStr(StringBuffer s1, StringBuffer s2){
	   s1 = s1.append(s2);
   }
}
