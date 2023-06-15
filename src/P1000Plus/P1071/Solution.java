package P1000Plus.P1071;
/*
 * @lc app=leetcode.cn id=1071 lang=java
 *
 * [1071] 字符串的最大公因子
 */

// @lc code=start
public class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if(str1==null||str2==null){
            return null;
        }
        if(str1.length()==0||str2.length()==0){
            return "";
        }
        if(!(str1+str2).equals(str2+str1)){
            return "";
        }
        return str1.substring(0,gcd(str1.length(),str2.length()));
    }
    //欧几里得算法-辗转相除法
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
// @lc code=end
