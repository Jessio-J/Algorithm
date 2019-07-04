package jianzhiOffer.P47;

public class P47_2 {
    //
    public int maxValue(int[][] board){
        if(board.length==0||board[0].length==0){
            return 0;
        }
        int[] maxValus = new int[board[0].length];
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                int left = 0;
                int up = 0;
                if(i>0){
                    up = maxValus[j];
                }
                if(j>0){
                    left = maxValus[j-1];
                }
                maxValus[j] = Math.max(left,up)+board[i][j];
            }
        }
        return  maxValus[board[0].length-1];
    }
}
