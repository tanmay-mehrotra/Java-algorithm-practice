package Random;

public class SearchInBST {
	public boolean searchElement(Node_BST root, int element){
		if (root == null)
			return false;
		if(root.value == element)
			return true;
		else if (element > root.value)
			return searchElement(root.rchild, element);
		else
			return searchElement(root.lchild, element);
	}

	//to search an element if NOT a BST
	public boolean searchElementInANonBST(Node_BST root, int element){
		if(root == null)
			return false;
		boolean retV = searchElementInANonBST(root.lchild,element);
		if(retV == true)
			return true;	
		if(root.value == element)
			return true;
		boolean retV1 = searchElementInANonBST(root.rchild,element);
		if(retV1 == true)
			return true;
		return retV && retV1;
	}
}
