package P51TO100.P79;
//给定一个二维网格和一个单词，找出该单词是否存在于网格中。
//
//        单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
//
//        示例:
//
//        board =
//        [
//        ['A','B','C','E'],
//        ['S','F','C','S'],
//        ['A','D','E','E']
//        ]
//
//        给定 word = "ABCCED", 返回 true.
//        给定 word = "SEE", 返回 true.
//        给定 word = "ABCB", 返回 false.
public class P79 {
    boolean found = false;
    public boolean exist(char[][] board, String word) {
        if(board.length==0||board[0].length==0){
            return false;
        }
        boolean[][] flag = new boolean[board.length][board[0].length];
        for(int i = 0;i<board.length&&!found;i++){
            for(int j = 0;j<board[0].length&&!found;j++){
                search(board,i,j,flag,word,0);
            }
        }
        return found;
    }
    private void search(char[][] board,int i,int j,boolean[][] flag,String word,int index){
        if(board[i][j]==word.charAt(index)&&!found){
            flag[i][j] = true;
            if(index==word.length()-1){
                found = true;
                return;
            }else {
                if(i>0&&!flag[i-1][j]){
                    search(board,i-1,j,flag,word,index+1);
                }
                if(j>0&&!flag[i][j-1]){
                    search(board,i,j-1,flag,word,index+1);
                }
                if(i<board.length-1&&!flag[i+1][j]){
                    search(board,i+1,j,flag,word,index+1);
                }
                if(j<board[0].length-1&&!flag[i][j+1]){
                    search(board,i,j+1,flag,word,index+1);
                }
            }
            flag[i][j] = false;
        }
    }
}
