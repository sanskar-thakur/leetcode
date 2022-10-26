import java.util.*;
import java.lang.Math;
class BT{

	//class variables
	private static Integer[] bTree;
	private static TreeNode root = null;
	private static List<TreeNode> nodeList = new ArrayList<TreeNode>();

	public static class TreeNode {
		Integer val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(Integer val) { this.val = val; }
		TreeNode(Integer val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	
	//class methods
	
	//print
	public static void printBTreeFromArray(){
		for(Integer node : bTree) System.out.println(node);
	}
	
	public static void printBTreeFromList(){
		System.out.print("[ ");
		for(TreeNode node : nodeList) System.out.print(node.val + " ");
		System.out.print("]");
		System.out.println("");
	}
	
	//construct tree	
	public static void constructBTreeFromArray(){
		int parentSize = (int)Math.floor(bTree.length/2);
		int size = bTree.length;
		if(size > 0)
		{
			root = new TreeNode(bTree[0]);					
			nodeList.add(root);	
			for(int i = 0; i < parentSize; i++){
				TreeNode cur = nodeList.get(i);	
				if(cur != null){							
					int lcIndx = 2 * i + 1;
					int rcIndx = 2 * i + 2;
					if(lcIndx < size){
						cur.left = new TreeNode(bTree[lcIndx]);
						nodeList.add(cur.left);
					}
					if(rcIndx < size){
						cur.right = new TreeNode(bTree[rcIndx]);
						nodeList.add(cur.right);
					}
				}
			}
		}		
	}
	
	//print in order
	public static void inorderTraversal(TreeNode root){
		if(root != null){
			inorderTraversal(root.left);
			System.out.println(root.val);
			inorderTraversal(root.right);
		}
	}
	
	//print pre order
	public static void preorderTraversal(TreeNode root){
		if(root != null){
			System.out.println(root.val);
			preorderTraversal(root.left);			
			preorderTraversal(root.right);
		}
	}
	
	//delete a node from tree
	public static TreeNode findNode(TreeNode cur, int val){
        if(cur == null || cur.val == val) return cur;
        return cur.val > val ? findNode(cur.left, val) : findNode(cur.right, val);
    }        
    
    public static void delete(TreeNode cur, int val){
        if(cur.left == null && cur.right == null) cur = null;
        else if(cur.left == null){
            cur.val = cur.right.val;
            cur.right = null;
        }
        else if(cur.right == null){
            cur.val = cur.left.val;
            cur.left = null;
        }
        else{            
            TreeNode temp = cur.right;
            TreeNode prev = cur;
            while(temp.left != null){
                prev = temp;
                temp = temp.left;
            }
            cur.val = temp.val;
            if(temp == cur.right) prev.right = temp.right;
            else prev.left = null;
        }
    }
	
	//main
	public static void main(String[] args){
		System.out.println("Binary Tree:");
		bTree = new Integer[]{5,3,6,2,4,null,7};
		//printBTreeFromArray();
		//System.out.println("Inorder Traversal:");
		constructBTreeFromArray();
		//inorderTraversal(root);		
		//preorderTraversal(root);	
		//System.out.println(nodeList);	
		printBTreeFromList();
		TreeNode target = findNode(root, 3);
        if(target != null) delete(target,3);
		inorderTraversal(root);		
	}
}
