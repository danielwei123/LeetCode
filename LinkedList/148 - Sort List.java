// 148. Sort List

// Given the head of a linked list, return the list after sorting it in ascending order.

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
    public ListNode sortList(ListNode head) {
        // Use Merge Sort
        if (head == null || head.next == null)  return head;
        // Split
        ListNode middle = findMiddle(head);
        ListNode middleNext = middle.next;
        middle.next = null;

        // Sort each part
        ListNode n1 = sortList(head);
        ListNode n2 = sortList(middleNext);

        // Merge
        return merge(n1, n2);
    }
    
      private ListNode findMiddle(ListNode head) {
        if (head == null || head.next == null)  return head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
          fast = fast.next.next;
          slow = slow.next;
        }
        return slow;
      }

      private ListNode merge(ListNode n1, ListNode n2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (n1 != null && n2 != null) {
          if (n1.val <= n2.val) {
            cur.next = n1;
            n1 = n1.next;
          } else {
            cur.next = n2;
            n2 = n2.next;
          }
          cur = cur.next;
        }

        if (n1 == null) {
          while (n2 != null) {
            cur.next = n2;
            cur = cur.next;
            n2 = n2.next;
          }
        }

        if (n2 == null) {
          while (n1 != null) {
            cur.next = n1;
            cur = cur.next;
            n1 = n1.next;
          }
        }

        return dummy.next;
      }
}