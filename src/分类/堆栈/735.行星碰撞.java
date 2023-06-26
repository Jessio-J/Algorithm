package 分类.堆栈;
/*
 * @lc app=leetcode.cn id=735 lang=java
 *
 * [735] 行星碰撞
 */

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

// @lc code=start
class Solution {
    public int[] asteroidCollision(int[] ats) {
        Deque<Integer> d = new ArrayDeque<>();
        for (int t : ats) {

            boolean ok = true;

            while (
            // 代表需不需要最终把t加到栈中
            ok &&
            // 栈不为空才做此操作
                    !d.isEmpty() &&
                    // 栈顶元素要向右
                    d.peekLast() > 0 &&
                    // 当前元素要向左
                    t < 0) {
                int a = d.peekLast(), b = -t;
                if (a <= b)
                    d.pollLast();
                if (a >= b)
                    ok = false;
            }
            if (ok) {
                d.addLast(t);
            }

        }
        int sz = d.size();
        int[] ans = new int[sz];
        while (!d.isEmpty())
            ans[--sz] = d.pollLast();
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { -2, -2, 1, -2 };
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.asteroidCollision(nums)));

    }
}
// @lc code=end
