package P37;

import java.util.HashMap;

//编写一个程序，通过已填充的空格来解决数独问题。
//
//        一个数独的解法需遵循如下规则：
//
//        数字 1-9 在每一行只能出现一次。
//        数字 1-9 在每一列只能出现一次。
//        数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
//        空白格用 '.' 表示。
public class P37_SudokuSolver {
    HashMap<Integer, Integer>[] rows = new HashMap[9];
    HashMap<Integer, Integer>[] columns = new HashMap[9];
    HashMap<Integer, Integer>[] boxes = new HashMap[9];
    char[][] solve = new char[9][9];
    boolean flag = false;

    public void solveSudoku(char[][] board) {
        initMap(board);
        dfs(board, 0, 0);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    board[i][j] = solve[i][j];
                }
            }
        }
    }
    //初始化标记
    private void initMap(char[][] board) {
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<Integer, Integer>();
            columns[i] = new HashMap<Integer, Integer>();
            boxes[i] = new HashMap<Integer, Integer>();
        }

        // validate a board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int n = (int) num;
                    int box_index = (i / 3) * 3 + j / 3;

                    // keep the current cell value
                    rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
                    columns[j].put(n, columns[j].getOrDefault(n, 0) + 1);
                    boxes[box_index].put(n, boxes[box_index].getOrDefault(n, 0) + 1);

                    // check if this value has been already seen before
                    if (rows[i].get(n) > 1 || columns[j].get(n) > 1 || boxes[box_index].get(n) > 1)
                        return;
                }
            }
        }
    }
    //深度有限遍历
    private void dfs(char[][] board, int i, int j) {
        int box_index = (i / 3) * 3 + j / 3;
        //碰到'.'则开始遍历
        if (board[i][j] == '.') {
//            boolean no_match = true;
            for (int k = 1; k <= 9 && !flag; k++) {
                if (!rows[i].containsKey(k + '0') && !columns[j].containsKey(k + '0') && !boxes[box_index].containsKey(k + '0')) {
//                    no_match = false;
                    solve[i][j] = (char) (k + '0');
                    rows[i].put(k + '0', 1);
                    columns[j].put(k + '0', 1);
                    boxes[box_index].put(k + '0', 1);
                    if (i == 8 && j == 8) {
                        flag = true;
                        return;
                    } else if (j == 8) {
                        dfs(board, i + 1, 0);
                    } else {
                        dfs(board, i, j + 1);
                    }
                }
            }
            //注意此处对不符合要求的解需要移出map
            //1.遍历到本次i和j都找不到合理的解，移出上一个已经放入map中的解
            //2.遍历到本次i和j合理解，但时之后一定会出现无解的情况，移出本次的解
            if (!flag) {
                int a = i;
                while (a >= 0) {
                    int b;
                    if (a == i) {
                        b = j;
                    } else {
                        b = 8;
                    }
                    while (b >= 0) {
                        if (solve[a][b] >= '1' && solve[a][b] <= '9') {
                            int num = solve[a][b];
                            int ab_box = (a / 3) * 3 + b / 3;
                            rows[a].remove(num);
                            columns[b].remove(num);
                            boxes[ab_box].remove(num);
                            solve[a][b] = '0';
                            return;
                        }
                        b--;
                    }
                    a--;
                }
            }
        }else {
            //碰到数字则跳过
            if (i == 8 && j == 8) {
                flag = true;
                return;
            } else if (j == 8) {
                dfs(board, i + 1, 0);
            } else {
                dfs(board, i, j + 1);
            }
        }
    }
}
