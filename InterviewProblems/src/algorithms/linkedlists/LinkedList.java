package algorithms.linkedlists;

import algorithms.arrays.Shuffle;

public class LinkedList {
	
	public static Node createLinkedList() {
		int[] arr = new int[10];
		for(int i=0;i<10;i++) {
			arr[i] = i;
		}
		
		Shuffle.shuffle(arr);
		Node temp = new Node();
		Node dummy = temp;
		System.out.println("Created linkedlist is:");
		for(int i=0; i< arr.length; i++) {
			Node n1 = new Node(arr[i]);
			temp.next = n1;
			temp = n1;
			System.out.print(n1.val + " ");
		}
		System.out.println();
		return dummy.next;
		
	}
	
	public static void printlist(Node head) {
		while(head != null) {
			System.out.print(head.val + " " );
			head = head.next;
		}
		System.out.println();
	}
}
