package Random;

public class Stack {
	public static void main(String args[]){
		int data[] = {1,2,3,4,5,6};
		LNode head = null;
		for(int d : data){
			head = push(head,d);
		}
		printStack(head);
		head = pop(head);
		printStack(head);
	}
	
	public static LNode push(LNode head, int data){
	   	LNode node = new LNode(data, null);
	   	node.next = head;
	   	return node;
	}
	
	public static LNode pop(LNode head){
		int data = head.data;
		System.out.println("popping " + data);
		return head.next;
	}
	
	public static void printStack(LNode head){
		while(head!=null){
			System.out.println(head.data);
			head = head.next;
		}
	}
}
