package year2021.leetCode;

public class LinkedListCycle {
	
	/**
	 * LeetCode 141. Linked List Cycle
	 * https://leetcode.com/problems/linked-list-cycle/
	 * 
	 * RunTime: 0 ms
	 * Memory: 39.9MB
	 * */
	public boolean hasCycle(ListNode head) {
		ListNode tmp = head;
		while(tmp != null) {
			if(tmp.val == 5000001) {
				return true;
			}
			tmp.val = 5000001;
			tmp = tmp.next;
		}
		
        return false;
    }
	
	
	public static void main(String[] args) {
		ListNode node = new ListNode(3, new ListNode(2, new ListNode(0, new ListNode(4))));
		new LinkedListCycle().hasCycle(node);
	}
	
	// 기본 제공 클래스 
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
		ListNode(int x, ListNode next){
			val =x ;
			this.next = next;
		}
	}
}
