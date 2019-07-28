package exam.shopee.D20190727;
//用dp(i,j)表示以A[i]和B[j]为结尾的相同子串的最大长度,
// 应该不难递推出dp[i, j]和dp[i+1,j+1]之间的关系，因为两者其实只差A[i+1]和B[j+1]这一对字符。
// 若A那么[i+1]和B[j+1]不同，dp[i+1, j+1]自然应该是0，因为任何以它们为结尾的子串都不可能完全相同；
// 而如果A[i+1]和B[j+1]相同，那么就只要在以A[i]和B[j]结尾的最长相同子串之后分别添上这两个字符即可，
// 这样就可以让长度增加一位。
//合并上述两种情况，也就得到：状态转移方程如下：
//dp[i+1][j+1] = ( A[i+1] == B[j+1] ? (dp[i][j]+1) : 0 );
//
public class class1_2 {
    public int findLength(int[] A, int[] B) {
        int m = A.length, n = B.length;
        if (m == 0 || n == 0) return 0;
        // 0的位置初始化为0，省的判断越界问题了
        int[][] dp = new int[m + 1][n + 1];
        //记录公共子串
        int subtail = -1;
        int longest = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (A[i] != B[j]) {
                    dp[i + 1][j + 1] = 0;
                } else {
                    dp[i + 1][j + 1] = 1 + dp[i][j];
                    if(longest<dp[i + 1][j + 1]){
                        longest = dp[i + 1][j + 1];
                        subtail = i;
                    }
                }
            }
        }
        //记录子串尾部，以及公共最大长度，可以找到该子串
        return longest;

    }
}
