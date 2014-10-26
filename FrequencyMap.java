package Random;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class FrequencyMap {
	public static void main(String args[]){
		Map<Integer, Integer> map = new HashMap<Integer,Integer>();
		map.put(1, 20);
	   for(Entry<Integer,Integer> entry : map.entrySet()){
		   entry.setValue(12);
	   }
	   System.out.println(map);
	}
}
