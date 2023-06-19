package P201TO999.P283;
/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 */

// @lc code=start
public class Solution {
    public void moveZeroes(int[] nums) {
        int p = 0;
        //i指针用于遍历所有值
        //p指针用于记录当前的非0的坐标
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[p++] = nums[i];
            }
        }
        for (int i = p; i < nums.length; i++) {
            nums[i] = 0;
        }

    }
}
// @lc code=end