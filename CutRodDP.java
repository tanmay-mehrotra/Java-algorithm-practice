package Random;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CutRodDP {
	static int data[]={0,1,5,8,9,10,17,17,20};
	static int maxPriceOfLength[]={0,1,5,8,9,10,17,17,20};
	public static void main(String args[]){
		int len = data.length;
		for(int i=2;i<len;i++){
			List<Integer> ls = new ArrayList<Integer>();
			for(int j=i;j>=1;j--){
				ls.add(maxPriceOfLength[j]+maxPriceOfLength[i-j]);
			}
			maxPriceOfLength[i] = Collections.max(ls);
		}
		for(int d : maxPriceOfLength){
			System.out.print(d + " ");
		}
	}
}