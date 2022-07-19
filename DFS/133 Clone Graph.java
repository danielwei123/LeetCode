// 133. Clone Graph

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        Map<Node,Node> oldToNew = new HashMap<Node,Node>();
        return DFS(node, oldToNew);
    }
    
    private Node DFS(Node n, Map<Node,Node> oldToNew) {
        if (n == null) return n;
        if (oldToNew.containsKey(n)) {
            return oldToNew.get(n);
        }
        
        Node copyNode = new Node(n.val);
        oldToNew.put(n, copyNode);
        
        for (Node gn: n.neighbors) {
          oldToNew.get(n).neighbors.add(DFS(gn, oldToNew));
        }
        return copyNode;
      }
}