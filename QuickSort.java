package Random;

public class QuickSort {
	static int data[]={2,8,-6,7,-5,8,12,-6,4,7};

	public static void main(String args[]){
		quickSort(0,data.length-1);
		for (int d :data){
			System.out.print(d + " ");
		}
	}

	public static void quickSort(int s, int e){
		if(s>=e){
			return;
		}
		int index = partition(s, e);
		quickSort(s, index-1);
		quickSort(index+1,e);
	}

	public static int partition(int s, int e){
		int pivot = data[s];
		int index = s;
		for(int i=s+1;i<=e;i++){
			if(data[i]<pivot){
				swap(index+1,i);
				index++;
			}
		}
		swap(index,s);
		return index;
	}

	public static void swap(int a, int b){
		int tmp = data[a];
		data[a]=data[b];
		data[b]=tmp;
	}
}
