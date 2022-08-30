// 208. Implement Trie (Prefix Tree)

class Trie {

    TrieNode root;
    
    public Trie() {
        root = new TrieNode(' ');
    }
    
    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            if (!cur.children.containsKey(word.charAt(i))) {
                TrieNode next = new TrieNode(word.charAt(i));
                cur.children.put(word.charAt(i), next);
                cur = next;
            } else {
                cur = cur.children.get(word.charAt(i));
            }
        }
        cur.isWord = true;
    }
    
    public boolean search(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            if (!cur.children.containsKey(word.charAt(i))) {
                return false;
            } else {
                cur = cur.children.get(word.charAt(i));
            }
        }
        if (!cur.isWord) return false;
        return true;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (!cur.children.containsKey(prefix.charAt(i))) {
                return false;
            } else {
                cur = cur.children.get(prefix.charAt(i));
            }
        }
        return true;
    }
}

class TrieNode {
    Map<Character, TrieNode> children;
    char c;
    boolean isWord;
    TrieNode(char c) {
        this.c = c;
        this.children = new HashMap<>();
    }
}
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */