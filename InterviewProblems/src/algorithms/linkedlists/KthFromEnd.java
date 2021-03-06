package algorithms.linkedlists;
// find the element that is k links away from the end of the list.

public class KthFromEnd {
	
	public static Node kthFromEnd(Node head, int k) {
		Node pointer1, pointer2;
		pointer1 = pointer2 = head;
		
		int i = 1;
		while(i < k) {
			pointer1 = pointer1.next;
			i++;
		}
		
		while( pointer1.next!= null) {
			pointer2 = pointer2.next;
			pointer1 = pointer1.next;
		}
		
		return pointer2;
	}
	public static void main(String[] args) {
		Node head = LinkedList.createLinkedList();
		System.out.println("3rd element from last:" + kthFromEnd(head, 3).val);
	}

}
