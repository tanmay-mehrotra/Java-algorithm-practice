package Random;

public class HeapSort{
	static int data[] = {-5,10,8,-10,12,14,-6,7,20};
	static int endIndex = data.length-1;
	
	public static void main(String args[]){
		buildHeap((data.length-2)/2);
		for (int i: data){
			System.out.print(i + " ");
		}
		System.out.println("\nmax number " + extraxtMax());
		for (int i: data){
			System.out.print(i + " ");
		}
		System.out.println("\nmax number " + extraxtMax());
	}

	public static void buildHeap(int st){
		for (int i=st; i>=0; i--){
			startRecursion(i,data.length-1);
		}
	}

	public static void startRecursion(int i, int arrayLength){
		if(i>arrayLength){
			return;
		}
		if(2*i+1<=arrayLength){
			if(data[i]<data[2*i+1]){
				swap(i,2*i+1);
				startRecursion(2*i+1,arrayLength);
			}
		}else{
			return;
		}
		if(2*i+2<=arrayLength){
			if(data[i]<data[2*i+2]){
				swap(i,2*i+2);
				startRecursion(2*i+2,arrayLength);
			}
		}else{
			return;
		}
	}

	public static void swap(int i, int j){
		int temp = data[i];data[i]=data[j];data[j]=temp;
	}
	
	public static int extraxtMax(){
		int max = data[0];
		data[0]=data[endIndex];
		endIndex--;
		heapify(endIndex);
		return max;
	}
	
	public static void heapify(int endIndex){
		startRecursion(0, endIndex);
	} 
}


