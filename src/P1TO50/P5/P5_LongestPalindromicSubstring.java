package P1TO50.P5;
//
//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
//
//        示例 1：
//
//        输入: "babad"
//        输出: "bab"
//        注意: "aba" 也是一个有效答案。
//        示例 2：
//
//        输入: "cbbd"
//        输出: "bb"

//动态规划算法


public class P5_LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        if(s==null||s.length()==0){
            return "";
        }
        if(s.length()==1){
            return s;
        }
        String maxSub = s.substring(0,1);
        //首先检验奇数长的串
        for(int i = 1;i<s.length()-1;i++){
            for(int j = i-1;j>=0 && (2*i -j)<s.length();j--){
                if(s.charAt(j) == s.charAt(2*i- j)){
                    if((2*(i-j)+1)>maxSub.length()){
                        maxSub = s.substring(j,2*i-j+1);
                    }
                }else {
                    break;
                }
            }
        }
        //再检验偶数长的串
        for(int i = 0;i<s.length()-1;i++){
            if(s.charAt(i)==s.charAt(i+1)){
                if(2>maxSub.length()){
                    maxSub = s.substring(i,i+2);
                }
                int j = i-1;
                while(j>=0 && (2*i -j+1)<s.length()){
                    if(s.charAt(j) == s.charAt(2*i- j+1)){
                        if((2*(i-j)+2)>maxSub.length()){
                            maxSub = s.substring(j,2*i-j+2);
                        }
                    }else {
                        break;
                    }
                    j--;
                }
            }
        }
        return maxSub;
    }
    public static void main(String[] args){
        System.out.println("" + new P5_LongestPalindromicSubstring().longestPalindrome("abbc"));
    }
}
