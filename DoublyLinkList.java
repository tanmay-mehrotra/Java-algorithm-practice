package Random;

class DoublyLinkList{
	DLNode start;
	DLNode head;
    int MAX_SIZE = 10;
    int curr_size = 0; 
    
    public DoublyLinkList(){};
    
    public DoublyLinkList(int MAX_SIZE){
       this.MAX_SIZE = MAX_SIZE;	
    }
    
	public DLNode add(int data){
		if(curr_size == MAX_SIZE){
			remove(start);
			curr_size--;
			add(data);
			return start;
		}
		if(start==null){
			start = new DLNode(data, null, null);
			head = start;
		}else{
			DLNode newNode = new DLNode(data, head, null);
			head.right = newNode;
			head = newNode;
		}
		curr_size++;
		return head;
	}

	public void remove(DLNode node){
		if(node==start && start.right==null){
			start = head = null;
		}
		else if(node==start){
			start.right.left = null;
			start = start.right;
		}else if(node==head){
			head = head.left;
			head.right = null;
		}else{
			DLNode prev = node.left;
			DLNode next = node.right;
			prev.right = next;
			next.left = prev;
		}
	} 

	public DLNode[] moveToFront(DLNode node){
		//lets just swap the data
		if(node!=head){
			int temp = 0;
			temp = node.value;
			node.value = node.right.value;
			node.right.value = temp;
			return new DLNode[]{node, node.right};
		}else{
			return null;
		}
	}

	@Override
	public String toString(){
		DLNode temp = start;
		String s = "";
		while(temp!=null){
			s += temp.value + " ";
			temp = temp.right;
		}
		return s;
	}
}
