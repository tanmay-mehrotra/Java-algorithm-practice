package Random;

public class LinkedList {

	private static LLNode head = null;	
	private static LLNode tail = null;

	public static void main(String args[]){
		for(int i = 0; i < 15; i++){
			if(i%3==0)
			  addNodeToList(5);
			else
				addNodeToList(i);
		}
		printList(head);
		LLNode newHead = deleteAllNodes(head, 5);
		printList(newHead);
	}

	public static void addNodeToList(int data){
		if(head == null){
			head = new LLNode(data,null);
			tail =  head;
		}
		else{
			tail.next = new LLNode(data,null);
			tail = tail.next;
		}
	}

	public static void addNodeToListNew(int data){
		head = new LLNode(data,head);
		if(tail == null){
			tail  = head;
		}
	} 

	public static LLNode deleteAllNodes(LLNode head, int data){
        if(head == null){
        	return head;
        }
        head.next = deleteAllNodes(head.next, data);
        if (head.data == data)
        	return head.next;
        else
        	return head;
	}

	public static void printList(LLNode head){
		LLNode tempHead = head;
		while(tempHead!=null){
			System.out.print(tempHead.data + " ");
			tempHead = tempHead.next;
		}
		System.out.println();
	}
}