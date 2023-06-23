package 分类.前缀和;
/*
 * @lc app=leetcode.cn id=1732 lang=java
 *
 * [1732] 找到最高海拔
 */

// @lc code=start
class Solution {
    public int largestAltitude(int[] gain) {
        int ans = 0, sum = 0;
        for (int x : gain) {
            sum += x;
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
// @lc code=end
