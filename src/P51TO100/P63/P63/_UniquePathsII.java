package P51TO100.P63.P63;

public class _UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid==null||obstacleGrid[0][0]==1){
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] box = new int[m][n];
        box[0][0] = 1;
        for(int i = 1;i<m;i++){
            if(box[i-1][0]!=0&&obstacleGrid[i][0]!=1)
            box[i][0] = 1;
        }
        for(int i = 1;i<n;i++){
            if(box[0][i-1]!=0&&obstacleGrid[0][i]!=1)
            box[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] != 1)
                    box[i][j] = box[i - 1][j] + box[i][j - 1];
            }
        }
        return box[m-1][n-1];

    }

}
