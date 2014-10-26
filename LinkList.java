package Random;

public class LinkList {
    public static void main(String args[]){
    	int data[]={1,2,3,4,5,6};
    	LNode head = null;
    	LNode start = null;
    	for(int i  = 0; i < data.length; i++){
    		head  = add(head,data[i]);
    		if(i==0){
    			start = head;
    		}
    	}
    	printList(start);
    }
    
    public static LNode add(LNode head, int data){
    	if(head == null){
    		return new LNode(data, null);
    	}else{
    		head.next = new LNode(data,null);
    		return head.next;
    	}
    }
    
    
    public static void printList(LNode start){
    	while(start!=null){
    		System.out.println(start.data);
    		start = start.next;
    	}
    }
}