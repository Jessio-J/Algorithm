package P201TO999.P392;
/*
 * @lc app=leetcode.cn id=392 lang=java
 *
 * [392] 判断子序列
 */

// @lc code=start
public class Solution {
    //解法1：指针遍历，一个个字母看是不是在s是不是在t里面
    public boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == n;
    }
    //动态规划
    //简单理解就是如果 t中位置i字符是j，那么f[i][j] = i,否则f[i][j] = f[i+1][j]
    // public boolean isSubsequence(String s, String t) {
    //     int n = s.length(), m = t.length();

    //     int[][] f = new int[m + 1][26];
    //     for (int i = 0; i < 26; i++) {
    //         f[m][i] = m;
    //     }

    //     for (int i = m - 1; i >= 0; i--) {
    //         for (int j = 0; j < 26; j++) {
    //             if (t.charAt(i) == j + 'a')
    //                 f[i][j] = i;
    //             else
    //                 f[i][j] = f[i + 1][j];
    //         }
    //     }
    //     int add = 0;
    //     for (int i = 0; i < n; i++) {
    //         if (f[add][s.charAt(i) - 'a'] == m) {
    //             return false;
    //         }
    //         add = f[add][s.charAt(i) - 'a'] + 1;
    //     }
    //     return true;
    // }
}
// @lc code=end