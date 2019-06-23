package jianzhiOffer.P47;

public class P47 {
    public int maxValue(int[][] board){
        if(board.length==0||board[0].length==0){
            return 0;
        }
        int m = board.length;
        int n = board[0].length;
        int[][] tmp = new int[m][n];
        tmp[0][0] = board[0][0];
        for(int i = 1;i<m;i++){
            tmp[i][0] = tmp[i-1][0]+board[i][0];
        }
        for(int i = 1;i<n;i++){
            tmp[0][i] = tmp[0][i-1]+board[0][i];
        }
        for(int i= 1;i<m;i++){
            for (int j=1;j<n;j++){
                tmp[i][j] = Math.max(tmp[i-1][j],tmp[i][j-1])+board[i][j];
            }
        }
        return tmp[m-1][n-1];
    }
}
