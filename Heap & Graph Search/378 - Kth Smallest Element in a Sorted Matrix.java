// 378. Kth Smallest Element in a Sorted Matrix

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int row = matrix.length;
        int col = matrix[0].length;

        // Best First Search, need a minheap on the value of each cell
        PriorityQueue<Cell> minHeap = new PriorityQueue<Cell> (k, new Comparator<Cell>() {
          @Override
          public int compare(Cell c1, Cell c2) {
            if (c1.value == c2.value) {
              return 0;
            } else if (c1.value < c2.value) {
              return -1;
            } else {
              return 1;
            }
          }
        });

        // all the generated cells will be mared true;
        // to avoid being generated more than once
        boolean[][] visited = new boolean[row][col];
        minHeap.offer(new Cell(0, 0, matrix[0][0]));
        visited[0][0] = true;

        // iterate k-1 rounds, and Best First Search the smallest k-1 cells
        for (int i = 0; i < k - 1; i++) {
          Cell cur = minHeap.poll();
          if (cur.row + 1 < row && !visited[cur.row + 1][cur.column]) {
            minHeap.offer(new Cell(cur.row + 1, cur.column, matrix[cur.row + 1][cur.column]));
            visited[cur.row + 1][cur.column] = true;
          }
          if (cur.column + 1 < col && !visited[cur.row][cur.column + 1]) {
            minHeap.offer(new Cell(cur.row, cur.column + 1, matrix[cur.row][cur.column + 1]));
            visited[cur.row][cur.column + 1] = true;
          }
        }

        return minHeap.poll().value;
    }
    
    static class Cell {
        int row;
        int column;
        int value;

        Cell(int row, int column, int value) {
          this.row = row;
          this.column = column;
          this.value = value;
        }
      }
}