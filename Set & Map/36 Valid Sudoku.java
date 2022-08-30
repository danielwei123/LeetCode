// 36. Valid Sudoku

class Solution {
    public boolean isValidSudoku(char[][] board) {
        // HashSet
        // set.add(i) return false if i is already in set
        Set<String> set = new HashSet<>();
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++) {
                char cur = board[i][j];
                if (cur != '.') {
                    if (!set.add(cur + " in row " + i) ||
                        !set.add(cur + " in col " + j) ||
                        !set.add(cur + " in cube " + i /3 + "-" + j / 3)
                       ) {
                        return false;
                    }                    
                }
            }
        }
        return true;
    }
}