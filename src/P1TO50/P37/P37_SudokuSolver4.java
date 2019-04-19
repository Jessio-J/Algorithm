package P1TO50.P37;

import java.util.HashMap;
//exception：解正确，堆栈溢出
public class P37_SudokuSolver4 {
    HashMap<Integer, Integer> [] rows = new HashMap[9];
    HashMap<Integer, Integer>[] columns = new HashMap[9];
    HashMap<Integer, Integer> [] boxes = new HashMap[9];
    char[][] solve = new char[9][9];
    public void solveSudoku(char[][] board) {
        initMap(board);
        backtrack(board,0,0,1);
        for(int a = 0;a<9;a++){
            for(int b = 0;b<9;b++){
                if(board[a][b]=='.'){
                    board[a][b] = solve[a][b];
                }
            }
        }
    }
    private void initMap(char[][] board){
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<Integer, Integer>();
            columns[i] = new HashMap<Integer, Integer>();
            boxes[i] = new HashMap<Integer, Integer>();
        }

        // validate a board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int n = (int)num;
                    int box_index = (i / 3 ) * 3 + j / 3;

                    // keep the current cell value
                    rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
                    columns[j].put(n, columns[j].getOrDefault(n, 0) + 1);
                    boxes[box_index].put(n, boxes[box_index].getOrDefault(n, 0) + 1);

                    // check if this value has been already seen before
                    if (rows[i].get(n) > 1 || columns[j].get(n) > 1 || boxes[box_index].get(n) > 1)
                        return;
                }
            }
        }
    }
    //回溯算法
    private void backtrack(char[][] board,int i,int j,int M){
        int box_index = (i / 3 ) * 3 + j / 3;
        if(board[i][j]=='.'){
            while(M<=9){
                if(!rows[i].containsKey(M+48)&&!columns[j].containsKey(M+48)&&!boxes[box_index].containsKey(M+48)){
                    solve[i][j] = (char)(M+48);
                    rows[i].put(M+48, 1);
                    columns[j].put(M+48, 1);
                    boxes[box_index].put(M+48, 1);
                    if(i==8&&j==8){
                        return;
                    }else if(j==8){
                        backtrack(board,i+1,0,1);
                    }else {
                        backtrack(board,i,j+1,1);
                    }
                    return;
                }
                M++;
            }
            int a= i;
            while(a>=0){
                int b;
                if(a==i){
                    b=j-1;
                }else {
                    b=8;
                }
                while(b>=0){
                    int last_box = (a/3)*3+b/3;
                    if(solve[a][b]>='1'&&solve[a][b]<='9'){
                        rows[a].remove((int)solve[a][b]);
                        columns[b].remove((int)solve[a][b]);
                        boxes[last_box].remove((int)solve[a][b]);
                        backtrack(board,a,b,solve[a][b]-47);
                        return;
                    }
                    b--;
                }
                a--;
            }
        }else {
            if(i==8&&j==8){
                return;
            }else if(j==8){
                backtrack(board,i+1,0,1);
            }else {
                backtrack(board,i,j+1,1);
            }
        }
    }

}
