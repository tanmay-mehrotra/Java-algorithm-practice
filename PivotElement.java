package Random;

public class PivotElement {
	public static void main(String args[]){
		int array[] = {1,2,-2,3,-4};
		System.out.println(findPivot(array));
	}
	
	public static int findPivot(int array[]){
		int sum=0,left_sum=0;
		for(int element: array){
			sum +=element;
		}
		for(int i=0; i<array.length; i++){
			if(left_sum == (sum - left_sum - array[i])){
				return i;
			}else{
				left_sum += array[i];
			}
		}
		return -1;
	}
}
