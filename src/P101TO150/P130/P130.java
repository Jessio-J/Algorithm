package P101TO150.P130;

public class P130 {
    public void solve(char[][] board) {
        if(board.length==0||board[0].length==0){
            return;
        }
        int m = board.length;
        int n = board[0].length;
        int[][] flag = new int[m][n];
        for(int i=0;i<m;i++){
            if(flag[i][0]!=1&&board[i][0]=='O'){
                mark(board,i,0,flag);
            }
            if(flag[i][n-1]!=1&&board[i][n-1]=='O'){
                mark(board,i,n-1,flag);
            }
        }
        for(int i=0;i<n;i++){
            if(flag[0][i]!=1&&board[0][i]=='O'){
                mark(board,0,i,flag);
            }
            if(flag[m-1][i]!=1&&board[m-1][i]=='O'){
                mark(board,m-1,i,flag);
            }
        }
        for(int i = 0;i<m;i++){
            for(int j =0;j<n;j++){
                if(flag[i][j]!=1){
                    board[i][j]='X';
                }
            }
        }
    }
    private void mark(char[][]board,int i,int j,int[][] flag){
        if(i<board.length&&j<board[0].length){
            flag[i][j]=1;
            if(i-1>=0&&flag[i-1][j]!=1&&board[i-1][j]=='O'){
                flag[i-1][j]=1;
                mark(board,i-1,j,flag);
            }
            if(j+1<board[0].length&&flag[i][j+1]!=1&&board[i][j+1]=='O'){
                flag[i][j+1]=1;
                mark(board,i,j+1,flag);
            }
            if(i+1<board.length&&flag[i+1][j]!=1&&board[i+1][j]=='O'){
                flag[i+1][j]=1;
                mark(board,i+1,j,flag);
            }
            if(j-1>=0&&flag[i][j-1]!=1&&board[i][j-1]=='O'){
                flag[i][j-1]=1;
                mark(board,i,j-1,flag);
            }
        }
    }
}
