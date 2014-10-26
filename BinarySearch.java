package Random;

public class BinarySearch {
	static int data[] = {1,4,8,10,13,17,19,23,28,35,39,40,43,47,49}; 
	public static void main(String args[]){
		System.out.println(binarySearch(0,data.length-1,35));
	}
	
	public static boolean binarySearch(int s, int e,int value){
		if(s>e)
			return false;
		int mid = (s + e)/2;
	    if(data[mid]==value)
	    	return true;
	    else if(data[mid]>value)
	    	return binarySearch(s,mid-1,value);
	    else
	    	return binarySearch(mid+1,e,value);
	}
}
