package Random;

import java.util.HashMap;


class TrieNode{
	HashMap<Character, TrieNode> data = new HashMap<Character, TrieNode>();
}

public class Trie {
	static String s = "roaoack";
	public static void main(String args[]){
		TrieNode root = new TrieNode();
		for(int j = 0; j < s.length(); j++){
			putInTrie(root,s.substring(j));
		}
		System.out.println(search(root, "ck"));
	}

	public static void putInTrie(TrieNode root, String str){
        if(str.length()==0)
        	return;
		if(root.data.containsKey(str.charAt(0))){
			putInTrie(root.data.get(str.charAt(0)),str.substring(1));
		}else{
			TrieNode newNode = new TrieNode();
			root.data.put(str.charAt(0), newNode);
			putInTrie(newNode,str.substring(1));
		}
	}
	
	public static boolean search(TrieNode root, String target){
		for(int i=0;i<target.length();i++){
			char ch = target.charAt(i);
			if(root.data.containsKey(ch)){
				root = root.data.get(ch);
			}else{
				return false;
			}
		}
		return true;
	}
}
