// 147. Insertion Sort List

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        
        // dummyHead stores the list that has already been sorted
        // i.e. the boxed ones in the graph 
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
        
        ListNode prev = dummyHead;
        ListNode cur = head;
        ListNode next;
        while (cur != null) {
            while (prev.next != null && prev.next.val < cur.val) {
                prev = prev.next;
            }
            next = cur.next;
            cur.next = prev.next;
            prev.next = cur;
            prev = dummyHead;
            cur = next;
        }
        
        return dummyHead.next;
    }
}