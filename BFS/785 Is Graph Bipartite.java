// 785. Is Graph Bipartite?

class Solution {
    public boolean isBipartite(int[][] graph) {
        // nodeCount: total number of nodes in the graph
        int nodeCount = graph.length;
        // each node needs to be assigned a color, 1 or -1
        int[] color = new int[nodeCount];
        
        /// Use BFS and a queue to iterate layer by layer
        int prev = 0;
        color[0] = 1;
        
        while (prev < nodeCount) {
            int size = graph[prev].length;
            
            for (int i = 0; i < size; i++) {
                int cur = graph[prev][i];
                if (cur <= prev) {
                    continue;
                }
                if (color[cur] != 1 && color[cur] != -1) {
                    color[cur] = color[prev] == 1 ? -1 : 1;
                } else {
                    if (color[cur] == color[prev]) {
                        return false;
                    } 
                }
            }
            
            prev++;
        }
        
        return true;
    }
}