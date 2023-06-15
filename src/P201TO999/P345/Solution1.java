package P201TO999.P345;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
/*
 * @lc app=leetcode.cn id=345 lang=java
 *
 * [345] 反转字符串中的元音字母
 */

// @lc code=start
public class Solution1 {
    public String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char alpha = s.charAt(i);
            if (vowels.contains(alpha)) {
                stack.push(alpha);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            char alpha = s.charAt(i);
            if (vowels.contains(alpha)) {
                sb.append(stack.pop());
            } else {
                sb.append(alpha);
            }
        }
        return sb.toString();
    }
}
// @lc code=end