package Random;
//Exception to denote when number to be found is not present in the tree
class NumberNotFound extends Exception{
	private static final long serialVersionUID = 1L;
	public NumberNotFound(String message){
		super(message);
	}
}

//Exception to denote when tree is not initialsed
class TreeNotInitialised extends Exception{
	private static final long serialVersionUID = 1L;
	public TreeNotInitialised(String message){
		super(message);
	}
}

//class to represent a Node in the tree
class Node{
	private int data;
	private Node lchild,rchild,mchild=null;

	public Node(int data, Node lchild, Node mchild, Node rchild){
		this.data = data;
		this.lchild = lchild;
		this.mchild = mchild;
		this.rchild = rchild;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getLchild() {
		return lchild;
	}

	public void setLchild(Node lchild) {
		this.lchild = lchild;
	}

	public Node getRchild() {
		return rchild;
	}

	public void setRchild(Node rchild) {
		this.rchild = rchild;
	}

	public Node getMchild() {
		return mchild;
	}

	public void setMchild(Node mchild) {
		this.mchild = mchild;
	}

}


//class containing operations on tree such as insert, delete or print
public class TrinaryTree {
	//insert a node into the tree
	private Node insert(Node root,int data){
		if(root == null){
			root = new Node(data, null, null, null);
		}
		else{
			Node temp = root;
			while(temp!=null){
				//look for the location where node can be placed in the tree 
				//insert the node over there and then break out of the loop.
				if(temp.getData()>data){
					if(temp.getLchild() == null){
						temp.setLchild(new Node(data, null, null, null));
						break;
					}
					temp = temp.getLchild();
				}
				else if(temp.getData()<data){
					if(temp.getRchild() == null){
						temp.setRchild(new Node(data, null, null, null));
						break;
					}
					temp = temp.getRchild();
				}
				else{
					if(temp.getMchild() == null){
						temp.setMchild(new Node(data, null, null, null));
						break;
					}
					temp = temp.getMchild();
				}
			}
		}
		return root;
	}

	//delete method helps in deleting the given element from the tree
    private Node delete(Node root,int data) throws TreeNotInitialised, NumberNotFound{
    	if(root==null){
    		throw new TreeNotInitialised("tree not initialised");
    	}else{
    		return deleteNode(root,data);
    	}
    }
    
    
	private Node deleteNode(Node root, int data) throws NumberNotFound{
		if(root == null)
			throw new NumberNotFound("number not found");
		//locate the location of the node which needs to be deleted
		if(data<root.getData()){
			root.setLchild(deleteNode(root.getLchild(), data));
		}
		else if(data > root.getData()){
			root.setRchild(deleteNode(root.getRchild(), data));
		}
		else{
			//we will reach here only when correct position of node to be deleted is determined
			// once we are on that node then we need to delete it . There are three cases possible in such a scenario
			root.setMchild(null);
			//case 1: when left child is not present
			if(root.getLchild() == null){
				return root.getRchild();
			}
			//case 2: when right child is not present
			else if(root.getRchild()==null){
				return root.getLchild();
			}
			//case 3: when both the child are present,then find the inorder successor and replace
			//the date with the node to be deleted and then then delete the inorder successor
			Node temp = root.getRchild();
			//finding inorder successor
			while(temp.getLchild() != null){
				temp=temp.getLchild();
			}
			root.setData(temp.getData());
			root.setMchild(temp.getMchild());
			//delete inorder successor
			root.setRchild(deleteNode(root.getRchild(), temp.getData()));	
		}
		return root;
	}

	private void print(Node root){
		if(root!=null){
			print(root.getLchild());
			Node tmp = root;
			while(tmp!=null){
				System.out.println(tmp.getData());
				tmp = tmp.getMchild();
			}
			print(root.getRchild());
		}
	}


	public static void main(String args[]){
		TrinaryTree tree = new TrinaryTree();
		int data[]= {50,20,-10,40,30,70,90,58,70,40,45,45,70,70};
		Node root = null;
		for (int element : data)
			root = tree.insert(root, element);
		System.out.println("tree after insertion");
		tree.print(root);
		System.out.println("tree after deletion");
		try{
			Node afterDeletion = tree.delete(root, 50);
			tree.print(afterDeletion);
		}
		catch(TreeNotInitialised tni){
			System.out.println(tni.getMessage());
		}
		catch(NumberNotFound nnf){
			System.out.println(nnf.getMessage());
		}
	}
}
