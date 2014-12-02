package Random;

class TreeNode{
	char data;
	TreeNode left,right;

	public TreeNode(char data, TreeNode left, TreeNode right){
		this.data = data;
		this.left = left;
		this.right = right;
	}
}

public class BinaryTreeFromTraversals {
	static char inorder[] = {'d','b','e','a','f','c'};
	static char preorder[] = {'a','b','d','e','c','f'};
    static int preOrderIndex = -1;
    
	public static TreeNode constructBinaryTree(int st, int end){
		System.out.println("st" + st + "end" + end);
		if(end < st)
			return null;
		preOrderIndex++;
		int i=0;
		for(i=st; i<=end; i++){
			System.out.println("preorder" + preOrderIndex);
			if(preorder[preOrderIndex] == inorder[i]){
				break;
			}
		}
		System.out.println("inorder[i]" + inorder[i]);
		TreeNode localRootNode = new TreeNode(inorder[i],null,null);
		localRootNode.left = constructBinaryTree(st, i-1);
		localRootNode.right = constructBinaryTree(i+1, end);
		return localRootNode;
	}

	public static void inOrderTraversal(TreeNode root){
		if(root != null){
			inOrderTraversal(root.left);
			System.out.println(root.data);
			inOrderTraversal(root.right);
		}
	}

	public static void main(String args[]){
		TreeNode root = BinaryTreeFromTraversals.constructBinaryTree(0,inorder.length-1);
		BinaryTreeFromTraversals.inOrderTraversal(root);
	}
}
