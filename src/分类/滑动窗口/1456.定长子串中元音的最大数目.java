package 分类.滑动窗口;
/*
 * @lc app=leetcode.cn id=1456 lang=java
 *
 * [1456] 定长子串中元音的最大数目
 */

// @lc code=start

import java.util.Arrays;
import java.util.List;

class Solution {
    public int maxVowels(String s, int k) {
        List<Character> vowel = Arrays.asList('a', 'e', 'i', 'o', 'u');
        int max = 0;
        int current=0;
        for (int i = 0; i < k; i++) {
            if (vowel.contains(s.charAt(i))) {
                current++;
            }
        }
        max = current;
        for(int i = k; i < s.length(); i++){
            int r = vowel.contains(s.charAt(i))?1:0;
            int l = vowel.contains(s.charAt(i-k))?1:0;
            current = current+r-l;
            if(current>max){
                max = current;
            }
        }
        return max;
    }
}
// @lc code=end
