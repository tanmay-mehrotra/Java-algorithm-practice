package Random;

import java.util.LinkedList;
import java.util.Queue;

class QNode{
	int value;
	public QNode(int value){
		this.value = value;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof QNode && this.value == ((QNode) obj).value){
			return true;
		}
		return false;
	}
	
}


public class ObjectQueue {
	public static void main(String args[]){
        Queue<QNode> q = new LinkedList<>();
        QNode n1 = new QNode(1);QNode n2 = new QNode(5);QNode n3 = new QNode(3);
        QNode n4 = new QNode(2);QNode n5 = new QNode(-10);QNode n6 = new QNode(4);
        q.add(n1);q.add(n2);q.add(n3);q.add(n4);q.add(n5);q.add(n6);q.add(n6);
        
        if(q.contains(new QNode(-10))){
        	System.out.println("it contains");
        }else{
        	System.out.println("it does not contains");
        }
	}
}
