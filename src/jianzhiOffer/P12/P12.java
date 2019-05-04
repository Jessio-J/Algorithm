package jianzhiOffer.P12;
//回溯法求解字符串查找问题
public class P12 {
    boolean found  = false;

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        boolean[][] visited = new boolean[rows][cols];
        for(int i = 0;!found&&i<rows;i++){
            for(int j = 0;!found&&j<cols;j++){
                if(matrix[i*cols+j]==str[0]){
                    visited[i][j] = true;
                    recursion(matrix,rows,cols,i,j,str,1,visited);
                    visited[i][j] = false;
                }
            }
        }
        return found;
    }
    private void recursion(char[] matrix,int rows,int cols,int i,int j,char[] str,int lev,boolean[][] visited){
        if(found||lev==str.length){
            found = true;
            return;
        }
        if(i-1>=0&&!visited[i-1][j]&&matrix[(i-1)*cols+j]==str[lev]){
            visited[i-1][j] = true;
            recursion(matrix,rows,cols,i-1,j,str,lev+1,visited);
            visited[i-1][j] = false;
        }
        if(j-1>=0&&!visited[i][j-1]&&matrix[i*cols+j-1]==str[lev]){
            visited[i][j-1] = true;
            recursion(matrix,rows,cols,i,j-1,str,lev+1,visited);
            visited[i][j-1] = false;
        }
        if(i+1<rows&&!visited[i+1][j]&&matrix[(i+1)*cols+j]==str[lev]){
            visited[i+1][j] = true;
            recursion(matrix,rows,cols,i+1,j,str,lev+1,visited);
            visited[i+1][j] = false;
        }
        if(j+1<cols&&!visited[i][j+1]&&matrix[i*cols+j+1]==str[lev]){
            visited[i][j+1] = true;
            recursion(matrix,rows,cols,i,j+1,str,lev+1,visited);
            visited[i][j+1] = false;
        }
    }
}
