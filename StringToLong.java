package Random;

public class StringToLong {
	//function converts string to a long. This function can work only till the point
	//when string is small enough to accomodate a long type
	public static long stringToLong(String s) throws NumberFormatException{
		long sum = 0;
		int negativeOffset = 0;
		if(s.charAt(0)=='-')
			negativeOffset=1;
		for(int i = s.length()-1;i>=negativeOffset;i--){
			char ch = s.charAt(i);
			if(ch-'0'<0 || ch-'0'>9){
			    throw new NumberFormatException("invalid String");
			}else{
				sum+=(ch-'0')*Math.pow(10, (s.length()-1)-i);
			}
		}
		if(negativeOffset==1)
		    return sum*-1;
		else
			return sum;
	}
	
	public static void main(String args[]){
    	try {
    		System.out.println(stringToLong("12.34"));
    	}
    	catch(NumberFormatException nfe){
    		System.out.println(nfe.getMessage());
    	}
    }
}
