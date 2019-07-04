package jianzhiOffer.P48;
//最长不含重复字符的子字符串
public class P48 {
    public int longestSubWithoutDuplication(String s){
        int[] flag = new int[128];
        int maxLength = 0;
        for(int i = 0,j=0;i<s.length();i++){
            //需要重新定位不重复串
            j = Math.max(flag[s.charAt(i)],j);
            maxLength = Math.max(maxLength,i-j+1);
            flag[s.charAt(i)] = i+1;
        }
        return maxLength;
    }
}
