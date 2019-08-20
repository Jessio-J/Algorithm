package P1TO50.P5;

/**
 * 最长回文子串，动态规划解法
 * 1.初始化一个二维数组，其中p[i][j]代表字符串从i到j是否是回文串
 * 2.初始化长度为1和2的回文串 p[i][i]和p[i][i+1]
 * 3.从长度为3的串开始判断，两端字母相等，且内部长度的串是回文串，那么整个串是回文串
 */
public class P5_LongestPalindromicSubstring3 {
    public String longestPalindrome(String s) {
        int N = s.length();
        if (N == 0) return null;

        int max = 1;
        int start = 0;
        boolean[][] p = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            p[i][i] = true;
        }

        for (int i = 0; i < N - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                p[i][i + 1] = true;
                max = 2;
            }
        }

        for (int len = 3; len <= N; len++) {
            for (int j = 0; j + len <= N; j++) {
                if (s.charAt(j) == s.charAt(j + len - 1) && p[j + 1][j + len - 2]) {
                    p[j][j + len - 1] = true;
                    if (len > max) {
                        max = len;
                        start = j;
                    }
                }
            }
        }

        return s.substring(start, start + max);
    }

}
