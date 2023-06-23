package P201TO999.P724;
/*
 * @lc app=leetcode.cn id=724 lang=java
 *
 * [724] 寻找数组的中心下标
 */

// @lc code=start
public class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int curSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if(curSum*2 == sum-nums[i]){
                return i;
            }
            curSum += nums[i];
        }
        return -1;
    }
}
// @lc code=end


