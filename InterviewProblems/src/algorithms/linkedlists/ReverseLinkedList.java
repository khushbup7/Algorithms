package algorithms.linkedlists;

public class ReverseLinkedList {
	public static Node reverseIterative(Node head) {
		  Node prev = null;
		  while(head != null) {
			  Node next = head.next;
			  head.next = prev;
			  prev = head;
			  head = next;
		  }
		  
		  return prev;
	}
	
	public static Node reverseRecursive(Node head) {
		Node prev = null;
		head = reverseUtil(head, prev);
		return head;
	}
	
	private static Node reverseUtil(Node head, Node prev) {
		if(head == null) 
			return null;
		if(head.next == null) {
			head.next = prev;
			return head;
		}
		Node temp = reverseUtil(head.next, head);
		head.next = prev;
		return temp;
	}

	public static void main(String[] args) {
		Node head = LinkedList.createLinkedList();
		head = reverseIterative(head);
		LinkedList.printlist(head);
		head = reverseRecursive(head);
		LinkedList.printlist(head);
	}
 }
