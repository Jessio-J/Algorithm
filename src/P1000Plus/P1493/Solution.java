package P1000Plus.P1493;

/*
 * @lc app=leetcode.cn id=1493 lang=java
 *
 * [1493] 删掉一个元素以后全为 1 的最长子数组
 */

// @lc code=start
class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length, res = 0, cnt = 0;
        for (int r = 0, l = 0; r < n; r++) {
            //计算0的个数
            if (nums[r] == 0) cnt++;
            //0个数超过1个
            while (cnt > 1) {
                //左指针移到只有1个0的地方
                if (nums[l++] == 0) cnt--;
            }
            //计算右减左的长度
            res = Math.max(res, r - l);
        }
        return res;
    }
}
// @lc code=end