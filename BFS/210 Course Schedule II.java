// 210. Course Schedule II

// Topological Sort

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // https://zhuanlan.zhihu.com/p/135094687
        // Topological Sort (BFS)
        // indegree[i]: how many prerequisites does course i have
        int[] indegree = new int[numCourses];
        int[] res = new int[numCourses];
        for (int[] pre: prerequisites) {
            indegree[pre[0]]++;
        }
        
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        
        int count = 0;
        // Execute 
        while (!q.isEmpty()) {
            int cur = q.poll();
            res[count++] = cur;
            for (int[] pre: prerequisites) {
                if (pre[1] == cur) {
                   indegree[pre[0]]--;
                    if (indegree[pre[0]] == 0) {
                        q.offer(pre[0]);
                    }
                }
            }
        }
        
        return count == numCourses ? res : new int[0];        
    }
}
