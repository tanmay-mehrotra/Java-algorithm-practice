package Random;

import java.util.HashSet;
import java.util.Set;

public class FindAllWordsInAMatrix {
	static char jumble[][]={{'a','b','c'},{'d','e','f'},{'g','h','i'}};
	static Set<String> dict =  new HashSet<String>();

	public static void main(String args[]){
		for(int i  = 0 ; i < jumble.length;i++){
			for(int j = 0; i < jumble[i].length;j++){
				returnAllWordsWithStartPoint(i, j);
			}
		}
	}

	public static void returnAllWordsWithStartPoint(int r , int c){
		//check for all vertical words in upwards direction
		String word = "";
		for (int strptr = r; strptr >=0; strptr--){
			word = word + jumble[strptr][c];
			isPresentInDict(word);
		}

		//check for all vertical words in downwards direction
		word = "";
		for (int strptr = r; strptr <jumble.length; strptr++){
			word = word + jumble[strptr][c];
			isPresentInDict(word);	
		}

		//check for all horizontal words in right direction
		word = "";
		for (int strptr = c; strptr <jumble[r].length; strptr++){
			word = word + jumble[r][strptr];
			isPresentInDict(word);	
		}

		//check for all horizontal words in left direction
		word = "";
		for (int strptr = c; strptr >=0; strptr--){
			word = word + jumble[r][strptr];
			isPresentInDict(word);		
		}
	}

	public static void isPresentInDict(String word){
		if(dict.contains(word)){
			System.out.println(word);
		}
	}
}
