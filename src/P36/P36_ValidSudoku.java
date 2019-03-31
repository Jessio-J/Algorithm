package P36;
//判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
//
//        数字 1-9 在每一行只能出现一次。
//        数字 1-9 在每一列只能出现一次。
//        数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
public class P36_ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int[] flag = null;
        for(int i=0;i<9;i++){
            flag = new int[10];
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'){
                    if(flag[board[i][j]-48]==0){
                        flag[board[i][j]-48]=1;
                    }else {
                        return false;
                    }
                }
            }
        }
        for(int i=0;i<9;i++){
            flag = new int[10];
            for(int j=0;j<9;j++){
                if(board[j][i]!='.'){
                    if(flag[board[j][i]-48]==0){
                        flag[board[j][i]-48]=1;
                    }else {
                        return false;
                    }
                }
            }
        }
        for(int k=0;k<=6;k+=3){
            for (int v=0;v<=6;v+=3){
                flag = new int[10];
                for(int i=0;i<3;i++){
                    for(int j=0;j<3;j++){
                        if(board[i+k][j+v]!='.'){
                            if(flag[board[i+k][j+v]-48]==0){
                                flag[board[i+k][j+v]-48]=1;
                            }else {
                                return false;
                            }
                        }
                    }
                }
            }
        }
       return true;
    }
}
