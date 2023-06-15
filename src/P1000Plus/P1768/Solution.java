package P1000Plus.P1768;
/*
 * @lc app=leetcode.cn id=1768 lang=java
 *
 * [1768] 交替合并字符串
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String mergeAlternately(String word1, String word2) {
        if (word1 == null) {
            return word2;
        }
        if (word2 == null) {
            return word1;
        }
        StringBuilder sb = new StringBuilder(); 
        int len = Math.max(word1.length(), word2.length());
        for(int i = 0;i<len;i++){
            if(i<word1.length()){
                sb.append(word1.charAt(i));
            }
            if(i<word2.length()){
                sb.append(word2.charAt(i));
            }
        }
        return sb.toString();


    }
}
// @lc code=end
