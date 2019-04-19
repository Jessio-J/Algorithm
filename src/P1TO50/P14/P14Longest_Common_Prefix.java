package P1TO50.P14;
//编写一个函数来查找字符串数组中的最长公共前缀。
//
//        如果不存在公共前缀，返回空字符串 ""。
//
//        示例 1:
//
//        输入: ["flower","flow","flight"]
//        输出: "fl"
//        示例 2:
//
//        输入: ["dog","racecar","car"]
//        输出: ""
//        解释: 输入不存在公共前缀。
//        说明:
//
//        所有输入只包含小写字母 a-z 。
public class P14Longest_Common_Prefix {
    public String longestCommonPrefix(String[] strs) {
        int sl = Integer.MAX_VALUE;
        int index = 0;
        String r = "";
        if(strs==null||strs.length==0){
            return "";
        }
        for(int i = 0;i<strs.length;i++){
            if(strs[i].equals("")){
                return "";
            }
            int curl = sl;
            sl = curl>strs[i].length()?strs[i].length():sl;
            index = curl>strs[i].length()?i:index;
        }
        loop:
        for(int j = 0;j<strs[index].length();j++){
            for(int k= 0;k<strs.length;k++){
                if(strs[k].charAt(j)==strs[index].charAt(j)){
                    if(k==strs.length-1){
                        r += strs[index].charAt(j);
                    }else {
                        continue;
                    }
                }else {
                    break loop;
                }
            }
        }
        return r;
    }
}
