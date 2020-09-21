package month2009.week3;

public class MergeTwoSortedLists {
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
		ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
		
		MergeTwoSortedLists mtsl = new MergeTwoSortedLists();
		ListNode list1= mtsl.mergeTwoLists(l1, l2);
		while(list1 != null) {
			System.out.println(list1.val);
			list1 = list1.next;
		}
	}
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		LinkedList result = new LinkedList();
        while (l1 != null && l2 != null){
            if (l1.val > l2.val){
            	result.insertNode(l2.val);
            	l2 = l2.next;
            } else {
            	result.insertNode(l1.val);
            	l1 = l1.next;
            }
        }
        while (l1 != null){
        	result.insertNode(l1.val);
        	l1 = l1.next;
        }
        while (l2 != null){
        	result.insertNode(l2.val);
        	l2 = l2.next;
        }
        return result.listNode;
    }
    
	/**
	 * 기본제공 클래스 
	 * */
    static class ListNode {
    	int val;
    	 ListNode next;
    	 ListNode() {}
    	 ListNode(int val) { this.val = val; }
    	 ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
    
    /**
     * 내가만든 클래스
     * */
    static class LinkedList {
    	public ListNode listNode;
    	public ListNode lastNode;
    	public void insertNode(int num) {
    		ListNode node = new ListNode(num);
    		if (listNode == null) {
    			listNode = node;
    			lastNode = listNode;
    		} else {
    			lastNode.next = node;
    			lastNode = lastNode.next;
    		}
    	}
    }
}
