package Random;

public class MergeSort {
	static int data[]={2,8,-6,7,-5,8,12,-6,4,7};
	
	public static void main(String args[]){
		//merge(0,data.length-1);
		mergeSort(0, data.length-1);
		for(int d : data){
			System.out.print(d + " ");
		}
	}
	
	public static void mergeSort(int s, int e){
		if(s>=e)
			return;
		int mid = (s + e)/2;
		mergeSort(s, mid);
		mergeSort(mid+1,e);
		merge(s,e);
	}
	
	public static void merge(int s, int e){
	    int a[]=new int[(e-s)+1];
		int mid = (s + e)/2;
		int i = s;int j = mid+1;int k=0; 
		
		while(i< mid+1 && j < e+1){
			if(data[i]<data[j]){
				a[k++] = data[i++];
			}else if(data[j]<data[i]){
				a[k++] = data[j++];
			}else{
				a[k++]=data[i++];
				a[k++]=data[j++];
			}
		}
		
		while(i<mid+1)
			a[k++]=data[i++];
		while(j < e+1)
			a[k++]=data[j++];
		
		for(int l=s; l<=e ; l++)
			data[l]=a[l-s];
	}
}