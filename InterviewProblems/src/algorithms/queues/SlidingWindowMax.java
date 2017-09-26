package algorithms.queues;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMax {
	 public static int[] maxSlidingWindow(int[] nums, int k) {
		 LinkedList<Integer> l1 = new LinkedList<Integer>();
		 Deque<Integer> dq = new LinkedList<Integer>(); 
		 int i;
		 for(i = 0; i < k; i++) {
			 while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i])
				 dq.removeLast();
			 dq.add(i);
		 }
		 for(; i < nums.length ; i++) {
			 l1.add(nums[dq.peek()]);
			 while(!dq.isEmpty() && dq.peek() < i-k+1)
				 dq.removeFirst();
			 while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i])
				 dq.removeLast();
			dq.add(i); 
		 }
		 
		 l1.add(nums[dq.peek()]);
		 int[] res = new int[l1.size()];
		 for(int j = 0; j< l1.size(); j++)
			 res[j] = l1.get(j);
		 return res;
	 }
	 
	 public static void main(String[] args) {
		 int[] nums = {1, 3, -1, 4, 5, 2, 4, 0, -5};
		 
		 for(int i : maxSlidingWindow(nums, 3)) 
			 System.out.print(" " +i);
		 
	 }
}
