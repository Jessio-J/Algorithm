package 分类.堆栈;
/*
 * @lc app=leetcode.cn id=2390 lang=java
 *
 * [2390] 从字符串中移除星号
 */

// @lc code=start

import java.util.Stack;

class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '*') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.insert(0, stack.pop());
        }
        return sb.toString();

    }
}
// @lc code=end
