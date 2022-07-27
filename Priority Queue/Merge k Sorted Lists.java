// 23. Merge k Sorted Lists

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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
          return null;
        }
        int k = lists.length;

        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(k, new MyComparator());

        // 无法决定头，所以使用dummy node
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        for (ListNode node : lists) {
          if (node != null) {
            minHeap.offer(node);
          }
        }

        while (!minHeap.isEmpty()) {
          cur.next = minHeap.poll();
          cur = cur.next;
          if (cur.next != null) {
            minHeap.offer(cur.next);
          }
        }

        return dummy.next;
    }

      static class MyComparator implements Comparator<ListNode> {
        @Override
        public int compare(ListNode l1, ListNode l2) {
          if (l1.val == l2.val) {
            return 0;
          }

          return l1.val < l2.val ? -1 : 1;
        }
      }
}