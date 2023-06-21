package 分类.双指针;
/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */
//若向内 移动短板 ，水槽的短板 min(h[i],h[j])可能变大，因此下个水槽的面积 可能增大 。
//若向内 移动长板 ，水槽的短板 min(h[i],h[j])不变或变小，因此下个水槽的面积 一定变小 
// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1, res = 0;
        while (i < j) {
            res = height[i] < height[j] ? 
            Math.max(res, (j - i) * height[i++]) :
            Math.max(res, (j - i) * height[j--]);
        }
        return res;
    }
}
// @lc code=end
