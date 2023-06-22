package P1000Plus.P1004;

/*
 * @lc app=leetcode.cn id=1004 lang=java
 *
 * [1004] 最大连续1的个数 III
 */

// @lc code=start
class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length, res = 0, cnt = 0;
        for (int r = 0, l = 0; r < n; r++) {
            // 计算0的个数
            if (nums[r] == 0)
                cnt++;
            // 0个数超过1个
            while (cnt > k) {
                // 左指针移到只有k个0的地方
                if (nums[l++] == 0)
                    cnt--;
            }
            // 计算右减左的长度
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
// @lc code=end
