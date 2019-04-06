package P37;

import java.util.ArrayList;
import java.util.List;

public class P37_SudokuSolver2 {
    public void solveSudoku(char[][] board) {
        List<int[]> blanks = new ArrayList<>(72);
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][][] grid = new boolean[3][3][9];
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j] == '.'){
                    blanks.add(new int[]{i,j});
                    continue;
                }
                int n = board[i][j] - 49;
                row[i][n] = true;
                col[j][n] = true;
                grid[i/3][j/3][n] = true;
            }
        }
        recursion(board,blanks,0,row,col,grid);
    }

    private boolean recursion(char[][] board, List<int[]> blanks, int level, boolean[][] row, boolean[][] col, boolean[][][] grid){
        if(level == blanks.size()) return true;

        int i = blanks.get(level)[0];
        int j = blanks.get(level)[1];

        for(int n=0; n<9; n++){
            if(row[i][n] || col[j][n] || grid[i/3][j/3][n]) continue;

            boolean row_copy = row[i][n];
            boolean col_copy = col[j][n];
            boolean grid_copy = grid[i/3][j/3][n];

            row[i][n] = true;
            col[j][n] = true;
            grid[i/3][j/3][n] = true;
            board[i][j] = (char) (n+49);

            if (recursion(board,blanks,level+1,row,col,grid)) return true;

            row[i][n] = row_copy;
            col[j][n] = col_copy;
            grid[i/3][j/3][n] = grid_copy;
        }
        return false;
    }
}
