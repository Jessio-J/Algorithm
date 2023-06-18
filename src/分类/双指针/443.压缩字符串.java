package 分类.双指针;
/*
 * @lc app=leetcode.cn id=443 lang=java
 *
 * [443] 压缩字符串
 */

// @lc code=start
class Solution {
    public int compress(char[] chars) {
        int pointer = 1;
        int count = 1;
        char last = chars[0];
        for(int i = 1;i<chars.length; i++){
            //如果和last相等，则count++
            if(chars[i]==last){
                count++; 
            }
            //如果和last不相等
            //1. 计算last个数，并且写到pointer处
            //2. 把新的chat记录到新pointer处
            //3.更新count为1
            if(chars[i]!=last){
                if(count!=1){
                    String countStr = String.valueOf(count);
                    for(int j = 0;j<countStr.length(); j++){
                        chars[pointer+j] = countStr.charAt(j);
                    }
                    pointer +=countStr.length();
                }
                chars[pointer]=chars[i];
                pointer++;
                count = 1;
            }
            last = chars[i];
        }
        //最后遍历完成，count>1则需要处理最后一个字符串的count
        if(count!=1){
            String countStr = String.valueOf(count);
            for(int j = 0;j<countStr.length(); j++){
                chars[pointer+j] = countStr.charAt(j);
            }
            pointer +=countStr.length();
        }
        return pointer;
    }
}
// @lc code=end