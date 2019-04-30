package P51TO100.P59;
//给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
//
//        示例:
//
//        输入: 3
//        输出:
//        [
//        [ 1, 2, 3 ],
//        [ 8, 9, 4 ],
//        [ 7, 6, 5 ]
//        ]
public class P59_SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] r = new int[n][n];
        int index = 0;
        for (int i = 0; i < 1 + n / 2; i++) {
            //本层应该打印行的数字个数
            int j = n - 2 * i;
            int k = n - 2 * i - 2;
            //上边框
            for (int a = 0; a < j; a++) {
                r[i][i + a]=++index;
            }
            //右边框
            if (j > 0)
                for (int a = 0; a < k; a++) {
                    r[i + 1 + a][n - i - 1]=++index;
                }
            //下边框
            if (k >= 0)
                for (int a = 0; a < j; a++) {
                    r[n - i - 1][n - i - 1 - a]=++index;
                }

            //左边框
            if (j > 1)
                for (int a = 0; a < k; a++) {
                    r[n - i - 2 - a][i]=++index;
                }
            if (j <= 0 || k <= 0) {
                break;
            }
        }
        return r;
    }
}
