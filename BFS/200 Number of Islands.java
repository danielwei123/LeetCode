// 200. Number of Islands

class Solution {
    public int numIslands(char[][] grid) {
        // Iterate the whole grids
        // whenever find '1', find all the grids connected to it (BFS), i.e. find the island it belongs to
        // then mark as '2' and countIsland++
        // return countIsland
        int countIsland = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    BFS(grid, i, j, m , n);
                    countIsland++;
                }
            }
        }
        return countIsland;
    }
    
    private void BFS(char[][] grid, int x, int y, int m, int n) {
        // Use x * n + y to represent the 2D index, 
        // so that Queue only needs to store Integer rather than a 2D array
        Queue<Integer> queue = new ArrayDeque<Integer>();
        queue.offer(x * n + y);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int cur_x = cur / n;
            int cur_y = cur % n;
            if (isValid(cur_x, cur_y + 1, m, n) && grid[cur_x][cur_y + 1] == '1') {
                queue.offer(cur_x * n + cur_y + 1);
                grid[cur_x][cur_y + 1] = '2';
            }
            if (isValid(cur_x + 1, cur_y, m, n) && grid[cur_x + 1][cur_y] == '1') {
                queue.offer((cur_x + 1) * n + cur_y);
                grid[cur_x + 1][cur_y] = '2';
            }
            if (isValid(cur_x - 1, cur_y, m, n) && grid[cur_x - 1][cur_y] == '1') {
                queue.offer((cur_x - 1) * n + cur_y);
                grid[cur_x - 1][cur_y] = '2';
            }
            if (isValid(cur_x, cur_y - 1, m, n) && grid[cur_x][cur_y- 1] == '1') {
                queue.offer(cur_x * n + cur_y - 1);
                grid[cur_x][cur_y - 1] = '2';
            }
        }
        return;
    }
    
    // check whether [x,y] is a valid coordinate of grid
    private boolean isValid(int x, int y, int m, int n) {
        if (x >= 0 && x < m && y >= 0 && y < n) return true;
        return false;
    }
}