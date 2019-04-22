package P51TO100.P52;

import java.awt.*;

//深度优先方法解决
//位运算解决
public class P52_NQueensII2 {
    private int count = 0;
    public int totalNQueens(int n) {
        if(n==1) return 1;
        DFS(0, 0, 0, 0, n);
        return count;
    }

    public void  DFS(int row, int col, int pie, int na, int n) {
        if (row >= n) {
            count++;
            return;
        }
        int a = (~(col | pie | na));
        int b = ((1 << n) - 1);
        int bits = a & b;
        while (bits > 0) {
            int P = bits & (-bits);
            DFS(row + 1, col | P, (P | pie) << 1, (na | P) >> 1, n);
            bits = bits & (bits - 1);
        }
    }
}
