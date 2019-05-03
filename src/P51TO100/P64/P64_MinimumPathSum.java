package P51TO100.P64;
//给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
//
//        说明：每次只能向下或者向右移动一步。
//
//        示例:
//
//        输入:
//        [
//        [1,3,1],
//        [1,5,1],
//        [4,2,1]
//        ]
//        输出: 7
//        解释: 因为路径 1→3→1→1→1 的总和最小。
public class P64_MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if(grid==null){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] box = new int[m][n];
        box[0][0] = grid[0][0];
        for(int i = 1;i<m;i++){
            box[i][0] = box[i-1][0]+grid[i][0];
        }
        for(int i = 1;i<n;i++){
            box[0][i] = box[0][i-1]+grid[0][i];
        }
        for(int i = 1;i<m;i++){
            for(int j = 1;j<n;j++){
                box[i][j] = (box[i-1][j]>box[i][j-1]?box[i][j-1]:box[i-1][j])+grid[i][j];
            }
        }
        return box[m-1][n-1];
    }
}
