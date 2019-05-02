package P51TO100.P62;
//动态规划求解
public class P62_UniquePaths3 {
    public int uniquePaths(int m, int n) {
        int[][] box = new int[m][n];
        for(int i = 0;i<m;i++){
            box[i][0] = 1;
        }
        for(int i = 0;i<n;i++){
            box[0][i] = 1;
        }
        for(int i = 1;i<m;i++){
            for(int j = 1;j<n;j++){
                box[i][j] = box[i-1][j]+box[i][j-1];
            }
        }
        return box[m-1][n-1];
    }
}
