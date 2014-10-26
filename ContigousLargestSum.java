package Random;

public class ContigousLargestSum {
  public static void main(String args[]){
	  int data[] = {2,3,-8,-1,2,4,-2,3};
	  int sum = 0;int sum1 = 0;
	  for(int i = 0 ; i < data.length; i++){
		  sum+=data[i];
		  if(sum > sum1){
			  sum1 = sum;
		  }
		  if(sum < 0){
			  sum = 0;
		  }
	  }
	  System.out.println(sum1);
  }
}
