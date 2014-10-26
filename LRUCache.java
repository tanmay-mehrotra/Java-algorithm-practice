package Random;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

	public static void main(String args[]){
		int data[]={1,2,3,4,5,6,7,8,9,10,11,4,5};
		LRUCache lru = new LRUCache();
		DoublyLinkList dll = new DoublyLinkList();
		Map<Integer,DLNode> map = new HashMap<Integer,DLNode>();
		for(int d : data){
			lru.updateCache(d,map,dll);
		}
		System.out.println(dll);
		System.out.println(map);
	}

	public void updateCache(int data, Map<Integer,DLNode> map, DoublyLinkList dll){
		if(map.containsKey(data)){
			DLNode updatedNodes[] = dll.moveToFront(map.get(data));
			if(updatedNodes !=null){
				map.put(updatedNodes[0].value, updatedNodes[0]);
				map.put(updatedNodes[1].value, updatedNodes[1]);
			}
		}else{
			if(dll.curr_size>=dll.MAX_SIZE)
				map.remove(dll.start.value);
			map.put(data, dll.add(data)); 
		}
	}
}
