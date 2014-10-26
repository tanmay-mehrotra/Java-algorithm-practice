package Random;

import java.util.ArrayList;
import java.util.Collections;


public class LongestIncreasingSubsequence {
	public static void main(String args[]){
		longestIncreasingSubsequence(new int[]{10,22,9,33,21,50,41,60,80});
	}

	public static void longestIncreasingSubsequence(int data[]){
		int answer[] = new int[data.length];
		answer[0]=1;
		for(int i=1; i<data.length; i++){
			ArrayList<Integer> tmp = new ArrayList<Integer>();
			for(int j=i-1; j>=0;j--){
				if(data[j]<data[i]){
					tmp.add(answer[j]);
				}
			}
			if(tmp.size()!=0)
				answer[i] = 1 + Collections.max(tmp);
			else
				answer[i] = 1;
		}
		for(int d : answer){
			System.out.print(d + " ");
		}
	}
}
