// 22. Generate Parentheses

// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

class Solution {
    public List<String> generateParenthesis(int n) {
        // DFS
        // Recursion tree has 2n level; each level represents a position of the string
        List<String> list = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        return getResult(n, 0, 0, sb, list);
    }
    
      //  l: the number of '(' that has been added in the stringBuilder
      //  r: the number of ')' that has been added in the stringBuilder
    private List<String> getResult(int n, int l, int r, StringBuilder sb, List<String> list) {
        if (l == n && r == n) {
          list.add(sb.toString());
          return list;
        }

        if (l < n) {
          sb.append('(');
          getResult(n, l+1, r, sb, list);
          sb.deleteCharAt(sb.length() - 1);
        }

        if (l > r) {
          sb.append(')');
          getResult(n, l, r+1, sb, list);
          sb.deleteCharAt(sb.length() - 1);
        }

        return list;
    }
}