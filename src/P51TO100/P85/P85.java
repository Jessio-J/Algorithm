package P51TO100.P85;

public class P85 {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0||matrix[0].length==0){
            return 0;
        }
        int[][] flag = new int[matrix.length][matrix[0].length];
        flag[0][0] = matrix[0][0]=='0'?0:1;
        for(int i = 1;i<matrix.length;i++){
            if(matrix[i][0] == '0'){
                flag[i][0] = flag[i-1][0];
            }else if(matrix[i][0] == '1'){
                if(matrix[i-1][0]=='1'){
                    flag[i][0] = flag[i-1][0]+1;
                }else if(matrix[i-1][0]=='0') {
                    flag[i][0] = Math.max(1,flag[i-1][0]);
                }
            }
        }
        for(int j = 1;j<matrix[0].length;j++){
            if(matrix[0][j] == '0'){
                flag[0][j] = flag[0][j-1];
            }else if(matrix[0][j] == '1'){
                if(matrix[0][j-1]=='1'){
                    flag[0][j] = flag[0][j-1]+1;
                }else if(matrix[0][j-1]=='0') {
                    flag[0][j] = Math.max(1,flag[0][j-1]);
                }
            }
        }
        for(int i = 1;i<matrix.length;i++){
            for(int j = 1;j<matrix[0].length;j++){
                if(matrix[i][j]=='1'){
                    int max = findMax(matrix,i,j);
                    flag[i][j] = Math.max(Math.max(flag[i-1][j],flag[i][j-1]),max);
                }else if(matrix[i][j]=='0') {
                    flag[i][j] = Math.max(flag[i-1][j],flag[i][j-1]);
                }
            }
        }
        return flag[matrix.length-1][matrix[0].length-1];
    }
    private int findMax(char[][] matrix,int i,int j){
        int a = i;
        int b = j;

        for1:
        for(;a>=0;a--){
            for(b=j;b>=0;b--){
                if(matrix[a][b]=='0'){
                    break for1;
                }
            }
        }
        int c = j;
        int d = i;
        for2:
        for(;c>b;c--){
            for(d=i;d>=0;d--){
                if(matrix[d][c]=='0'){
                    break for2;
                }
            }
        }
        if(a<0||c<0){
            return (i+1)*(j+1);
        }else {
            return (i-d)*(j-b);
        }
    }
}
