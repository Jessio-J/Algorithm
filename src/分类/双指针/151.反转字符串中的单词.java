package 分类.双指针;
/*
 * @lc app=leetcode.cn id=151 lang=java
 *
 * [151] 反转字符串中的单词
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public String reverseWords(String s) {
        if (s == null) {
            return s;
        }
       String[] arr = s.split(" ");
        if (arr.length == 0) {
            return s;
        }
        int i = 0;
        int j = arr.length-1;
        while(i<j){
            if(arr[i].equals("")){
                i++;
                continue;
            }
            if(arr[j].equals("")){
                j--;
                continue;
            }
            String tmp = arr[i];
            arr[i++] = arr[j];

            arr[j--] = tmp;
           
        }
        StringBuilder sb = new StringBuilder();
        for (String string : arr) {
            if(!"".equals(string)){
                sb.append(string).append(" ");
            }
        }
        return sb.toString().trim();
    }
}
// @lc code=end

