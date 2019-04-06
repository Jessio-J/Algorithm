package P37;

import java.util.HashMap;
//exception：解正确，堆栈溢出
public class P37_SudokuSolver3 {
    char[][] solve = new char[9][9];
    public void solveSudoku(char[][] board) {

        backtrack(board,0,0,1);
        for(int a = 0;a<9;a++){
            for(int b = 0;b<9;b++){
                if(board[a][b]=='.'){
                    board[a][b] = solve[a][b];
                }
            }
        }
    }

    //回溯算法
    private void backtrack(char[][] board,int i,int j,int M){
        int box_index = (i / 3 ) * 3 + j / 3;
        if(board[i][j]=='.'){
            while(M<=9){
                if(check(board,i,j,(char)(M+48))){
                    solve[i][j] = (char)(M+48);
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
    private boolean check(char[][] board,int i,int j,char cur){

        for(int k = 0;k<9;k++){
            if(cur==board[i][k]||cur==solve[i][k]){
                return false;
            }
            if(cur==board[k][j]||cur==solve[k][j]){
                return false;
            }
        }
        int a=i/3*3;
        int b=j/3*3;
        for(int m = a;m<a+3;m++){
            for(int n = b;n<b+3;n++){
                if(cur==board[a][b]){
                    return false;
                }
                if(cur==solve[a][b]){
                    return false;
                }
            }
        }
        return true;
    }
}
