package algorithms.trees;

//  find the maximum amount  that can be invested. children and parent cannot invest together

import java.util.LinkedList;
import java.util.Queue;

public class Portfolio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "3 2 3 # 3 # 1";
		System.out.println(findMax(s));
	}
	
	 static long findMax(String tree) {
	        
	        String[] tree1 = tree.split(" ");
	        int[] arr = new int[tree1.length];
	        int i = 0;
	        for(String c : tree1) {
	            if(c.equals("#"))
	                arr[i] = -1;
	            else arr[i] = Integer.parseInt(c);
	            i++;
	        }
	        
	        Node root = buildTree(arr);
	        long rootCount = getValue(root);
	       
	        long rootExlLeftCount = getValue(root.left);
	        
	        long rootExlRightCount = getValue(root.right);
	        
	        return Math.max(rootCount, rootExlLeftCount + rootExlRightCount);

	    }
	static long getValue(Node root)  {
		if(root == null)
			return 0;
	    long res = 0;
	    res += root.val;
	    
	    if(root.left == null || root.right == null)
	    	return res;
	    if(root.left.left != null)
	    	res += getValue(root.left.left);
	    if(root.left.right != null)
	    	res += getValue(root.left.right);
	    if(root.right.right != null)
	    	res += getValue(root.right.right);
	    if(root.right.left != null)
	    	res += getValue(root.right.left);
	    
	    
	    return res;
	}
	
	
	static Node buildTree(int[] arr) {
		Queue<Node> q = new LinkedList<Node>();
		Portfolio.Node n = new Node(arr[0]);
		q.add(n);
		int i = 1;
		while(!q.isEmpty()) {
			Node root = q.remove();
			if(i > arr.length -1)
				break;
			if(arr[i] != -1) {
				root.left = new Node(arr[i]);
				q.add(root.left);
			}
			i++;
			if(arr[i] != -1) {
				root.right = new Node(arr[i]);
				q.add(root.right);
			}
			i++;
		}
		return n;
	}
	
	public static class Node {
		int val;
		Node left;
		Node right;
		
		Node(int x) {
			this.val = x;
		}
		
	}

}
