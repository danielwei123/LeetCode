// 143. Reorder List

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
    public void reorderList(ListNode head) {
      if (head == null) return;
      ListNode secondHead = findMiddleNode(head);
      ListNode newSecondHead = reverseLinkedList(secondHead);
      combineTwoLinekdList(head, newSecondHead);
      return;
    }
    
    // Divide linkedlist into two halves, return the head of the second half
    // 1 -> 2 -> 3 -> null return 3
    // 1 -> 2 -> 3 -> 4 -> null return 3
    private ListNode findMiddleNode(ListNode head) {
      ListNode slow = head;
      ListNode fast = head;
      while (fast.next != null && fast.next.next != null) {
        fast = fast.next.next;
        slow = slow.next;
      }
      ListNode secondHead = slow.next;
      slow.next = null;
      return secondHead;
    }

    // Reverse linkedlist recursively and return the new head
    private ListNode reverseLinkedList(ListNode head) {
      if (head == null || head.next == null) {
        return head;
      }

      ListNode cur = head;
      ListNode newHead = reverseLinkedList(head.next);
      cur.next.next = cur;
      cur.next = null;

      return newHead;
    }

    // Assuming ListNode one is always no shorter than two
    private ListNode combineTwoLinekdList(ListNode headOne, ListNode headTwo) {
      ListNode newHead = headOne;
      while (headTwo != null) {
        ListNode nextOne = headOne.next;
        ListNode nextTwo = headTwo.next;
        ListNode tmp = headTwo;
        headOne.next = tmp;
        tmp.next = nextOne;
        headOne = nextOne;
        headTwo = nextTwo;
      }
      return newHead;
    }
}