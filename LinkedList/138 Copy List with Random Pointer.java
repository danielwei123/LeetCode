// 138. Copy List with Random Pointer

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> oldToNew = new HashMap<Node, Node>();
        if (head == null) return head;

        Node newHead = new Node(head.val);
        oldToNew.put(head, newHead);
        while (head != null) {
          if (head.next != null) {
            if (oldToNew.containsKey(head.next)) {
              oldToNew.get(head).next = oldToNew.get(head.next);
            } else {
              Node newNext = new Node(head.next.val);
              oldToNew.put(head.next, newNext);
              oldToNew.get(head).next = newNext;
            }
          }
          if (head.random != null) {
            if (oldToNew.containsKey(head.random)) {
              oldToNew.get(head).random = oldToNew.get(head.random);
            } else {
              Node newRandom = new Node(head.random.val);
              oldToNew.put(head.random, newRandom);
              oldToNew.get(head).random = newRandom;
            }
          }
          head = head.next;
        }

    return newHead;
    }
}