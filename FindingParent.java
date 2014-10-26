package Random;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

//{"Ann": ["Betty", "Clare"], "Betty": ["Donna", "Elizabeth", "Flora"], "Clare": ["Gloria", "Hazel"]}

public class FindingParent {
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		String res;
		String _tree_str;
		_tree_str = in.nextLine();
          
		String _name1;
       _name1 = in.nextLine();

       String _name2;
       _name2 = in.nextLine();

       res = common(_tree_str, _name1, _name2);
       System.out.println(res);
	}

	static String common(String tree_str, String name1, String name2) {
		HashMap<String, Set<String>> parentChild = parseToHashMap(tree_str);
		return findNames(parentChild, name1, name2);
	}
	
	static String findNames(HashMap<String, Set<String>> parentChild, String name1, String name2){
		//check for direct parent child relationship and this is also the base case
		if(parentChild.containsKey(name1)){
			if(parentChild.get(name1).contains(name2)){
				return name1;
			}
		}
		
		if(parentChild.containsKey(name2)){
			if(parentChild.get(name2).contains(name1)){
				return name2;
			}
		}
		
		String parent1 = null;String parent2 = null;
		parent1 = searchforParent(name1, parentChild);
		parent2 = searchforParent(name2, parentChild);
		if(parent1.equals(parent2)){
			return parent1;
		}else{
			return findNames(parentChild, parent1, parent2);
		}
	}
	
	static String searchforParent(String child, HashMap<String, Set<String>> parentChild){
		for (Map.Entry<String, Set<String>> entry : parentChild.entrySet()){
		     if(entry.getValue().contains(child)){
		    	 return entry.getKey();
		     }
		}
		return child;
	}

	static HashMap<String, Set<String>> parseToHashMap(String a){
		String arr[] = a.substring(1,a.length()-1).split("], ");
		for (int i = 0 ; i < arr.length; i++){
			if(i!=arr.length-1){
				arr[i] = arr[i] + "]";
			}
		}
		HashMap<String, Set<String>> parentChild = new HashMap<String, Set<String>>(); 
		for (String s2: arr){
			String array1[] = s2.split(": ");
			String child1 = array1[1].substring(1,array1[1].length()-1);
			String childs[] = child1.split(", ");
			for(int i = 0; i < childs.length; i++){
				childs[i] = childs[i].substring(1,childs[i].length()-1);
			}
			Set<String> childSet = new HashSet<String>(Arrays.asList(childs));
			parentChild.put(array1[0].substring(1,array1[0].length()-1), childSet);
		}
		return parentChild;
	}

}
