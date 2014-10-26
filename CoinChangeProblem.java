package Random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CoinChangeProblem {
	public static void main(String args[]){
		int sum = 20;
		Integer denomenations[] = {1,2,4,5,6,7};
		List<Integer> deno_list = Arrays.asList(denomenations);
		int a[] = new int[sum+1];
		for(int i = 1; i <= sum; i++){
			if(deno_list.contains(i)){
				a[i] = 1;
			}else{
				ArrayList<Integer> al = new ArrayList<Integer>(); 
				for(int j=i-1;j>=i/2;j--){
					if(a[j]==0 || a[i-j]==0)
						continue;
					al.add(a[j] + a[i-j]);
				}
				if(al.size()!=0)
					a[i]=Collections.min(al);
				else
					a[i]=0;
			}
		}
		System.out.println(a[sum]);
	}
}