// 1293. Shortest Path in a Grid with Obstacles Elimination

class Solution {
    public int shortestPath(int[][] grid, int k) {
        // BFS
        int m = grid.length;
        int n = grid[0].length;
        int[] res = new int[]{Integer.MAX_VALUE};
        // Use a 3D array to store visited cell and how many obstacles have been eliminated
        // visited[i][j][k]: whether grid[i][j] has been visited where there are k obstacles have been elimated so far
        boolean[][][] visited = new boolean[m][n][k + 1];
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0,0,0});
        visited[0][0][0] = true;
        int minStep = Integer.MAX_VALUE;
        int curStep = 0;
        
        while (!q.isEmpty()) {
            int curSize = q.size();
            for (int i = 0; i < curSize; i++) {
                int[] cur = q.poll();
                int curX= cur[0];
                int curY = cur[1];
                int curK = cur[2];
                if (curX == m - 1 && curY == n - 1 && curK <= k) {
                    minStep = Math.min(minStep, curStep);
                    continue;
                }
                for (int[] dir: dirs) {
                    int nextX = curX + dir[0];
                    int nextY = curY + dir[1];
                    if (isValidPoint(nextX, nextY, m, n)) {
                        if (grid[nextX][nextY] == 0 && !visited[nextX][nextY][curK]) {
                            visited[nextX][nextY][curK] = true;
                            q.offer(new int[]{nextX, nextY, curK});
                        } else if (grid[nextX][nextY] == 1 && curK + 1 <= k && !visited[nextX][nextY][curK + 1]) {
                            visited[nextX][nextY][curK + 1] = true;
                            q.offer(new int[]{nextX, nextY, curK + 1});
                        }
                    }
                }
            }
            curStep++;            
        }
        
        return minStep == Integer.MAX_VALUE ? -1 : minStep;
    }
    
    
    private boolean isValidPoint(int x, int y, int m, int n) {
        if (x >= 0 && x < m && y >= 0 && y < n) return true;
        return false;
    }
}