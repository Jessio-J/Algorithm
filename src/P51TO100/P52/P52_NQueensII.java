package P51TO100.P52;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//回溯递归方法解决
public class P52_NQueensII {
    int count = 0;
    public int totalNQueens(int n) {
        helper(new ArrayList<String>(), 0, new boolean[n], new boolean[2*n], new boolean[2*n], n);
        return count;
    }

    private void helper(List<String> board, int row, boolean[] cols, boolean[] d1, boolean[] d2, int n){
        if (row == n) {
            count++;
            return;
        }
        for (int col=0; col<n; col++){
            int id1 = col - row + n;
            int id2 = col + row;
            if (!cols[col] && !d1[id1] && !d2[id2]){
                char[] r = new char[n];
                Arrays.fill(r, '.');
                r[col] = 'Q';
                board.add(new String(r));
                cols[col] = true;
                d1[id1] = true;
                d2[id2] = true;
                helper(board, row+1, cols, d1, d2, n);
//                还原过程
                board.remove(board.size()-1);
                cols[col] = false;
                d1[id1] = false;
                d2[id2] = false;
            }
        }
    }
}
