package jianzhiOffer.P29;

import java.util.ArrayList;

public class P29 {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> r = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return r;
        }
        //m行
        int m = matrix.length;
        //n列
        int n = matrix[0].length;
        if(n==1){
            for(int i = 0;i<m;i++){
                r.add(matrix[i][0]);
            }
            return r;
        }
        for (int i = 0; i < 1 + m / 2; i++) {
            //本层应该打印横边数字个数
            int j = n - 2 * i;
            //本层应该打印竖边数字个数
            int k = m - 2 * i - 2;
            //上边框
            for (int a = 0; a < j; a++) {
                r.add(matrix[i][i + a]);
            }
            //右边框
            if (j > 0)
                for (int a = 0; a < k; a++) {
                    r.add(matrix[i + 1 + a][n - i - 1]);
                }
            //下边框
            if (k >= 0)
                for (int a = 0; a < j; a++) {
                    r.add(matrix[m - i - 1][n - i - 1 - a]);
                }

            //左边框
            if (j > 1)
                for (int a = 0; a < k; a++) {
                    r.add(matrix[m - i - 2 - a][i]);
                }
            if (j <= 0 || k <= 0) {
                break;
            }
        }
        return r;
    }
}
