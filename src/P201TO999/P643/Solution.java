package P201TO999.P643;

/*
 * @lc app=leetcode.cn id=643 lang=java
 *
 * [643] 子数组最大平均数 I
 */

// @lc code=start
public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int init = 0;
        for (int i = 0; i < k; i++) {
            init += nums[i];
        }
        int max = init;
        for (int i = k; i < nums.length; i++) {
            init = init + nums[i] - nums[i - k];
            if (max < init) {
                max = init;
            }
        }
        return 1.0 * max / k;
    }
}
// @lc code=end
