// 146. LRU Cache

class LRUCache {

    // Hashmap + double linked list
  
    static class Node {
      Node next;
      Node prev;
      int key;
      int value;

      Node(int key, int value) {
        this.key = key;
        this.value = value;
      }

      void update(int key, int value) {
        this.key = key;
        this.value = value;
      }
    }

    private final int capacity;
    private Node head;
    private Node tail;
    private Map<Integer, Node> map;
    
    public LRUCache(int capacity) {
      this.capacity = capacity;
      this.map = new HashMap<Integer, Node>();
    }
    
    public int get(int key) {
      Node node = map.get(key);
      if (node == null) {
        return -1;
      } else {
        remove(node);
        append(node);
        return node.value;
      }
    }
    
    public void put(int key, int value) {
      Node node = null;
      if (map.containsKey(key)) {
        node = map.get(key);
        remove(node);
        node.update(key, value);
        append(node);
      } else if (map.size() < capacity) {
        node = new Node(key, value);
        append(node);
      } else {
        remove(tail);
        node = new Node(key, value);
        append(node);
      }
    }
  
    private Node remove(Node node) {
      map.remove(node.key);
      if (node.prev != null) {
        node.prev.next = node.next;
      }
      if (node.next != null) {
        node.next.prev = node.prev;
      }
      if (node == head) {
        head = head.next;
      }
      if (node == tail) {
        tail = tail.prev;
      }
      node.next = null;
      node.prev = null;
      return node;
    }

    private Node append(Node node) {
      map.put(node.key, node);
      if (head == null) {
        head = node;
        tail = node;
      } else {
        node.next = head;
        head.prev = node;
        head = node;
      }
      return node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */