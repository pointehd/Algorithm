package year2021.leetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode 160. Intersection of Two Linked Lists
 * 
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 * */
public class IntersectionOfTwoLinkedLists {
	
	/**
	 * RunTime: 1 ms
	 * Memory: 41.6 MB
	 * */
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//		ListNode a =  headA + headB
//		ListNode b =  headB + headA
		
		ListNode tmpA = headA;
		ListNode tmpB = headB;
		
		while(tmpA != tmpB) {
			tmpA = tmpA == null ? headB : tmpA.next;
			tmpB = tmpB == null ? headA : tmpB.next;
		}
		
        return tmpA;
    }
	/**
	 * RunTime: 7ms
	 * Memory: 43.2 MB
	 * */
	public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
		Set<ListNode> nodeSet = new HashSet<IntersectionOfTwoLinkedLists.ListNode>();
		while(headA != null) {
			nodeSet.add(headA);
			headA = headA.next;
		}
		while(headB != null) {
			if(nodeSet.contains(headB))
				return headB;
			headB = headB.next;
		}
		return null;
	}
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x){
			val = x;
			next = null;
		}
	}
}
