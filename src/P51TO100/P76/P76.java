package P51TO100.P76;

import java.util.Arrays;
//给定一个字符串 S 和一个字符串 T，请在 S 中找出包含 T 所有字母的最小子串。
//
//        示例：
//
//        输入: S = "ADOBECODEBANC", T = "ABC"
//        输出: "BANC"
//        说明：
//
//        如果 S 中不存这样的子串，则返回空字符串 ""。
//        如果 S 中存在这样的子串，我们保证它是唯一的答案。
public class P76 {
    public String minWindow(String s, String t) {
        int[] letterHash = new int[123];
        String ret = "";
        int cnt = 0 , min_len = Integer.MAX_VALUE , left = 0;
        for(int i =0; i < t.length();i++)
            letterHash[t.charAt(i)]++;
        for(int i =0;i < s.length();i++){
            if(--letterHash[s.charAt(i)] >= 0)
                cnt++;
            while(cnt == t.length()){
                if(i - left + 1 < min_len){
                    min_len = i - left + 1;
                    ret = s.substring(left,left+min_len);
                }
                if(++letterHash[s.charAt(left)] > 0)
                    cnt--;
                left++;
            }
        }
        return ret;
    }
}
