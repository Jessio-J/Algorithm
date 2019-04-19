package P1TO50.P32;

//给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
//
//        示例 1:
//
//        输入: "(()"
//        输出: 2
//        解释: 最长有效括号子串为 "()"
//        示例 2:
//
//        输入: ")()())"
//        输出: 4
//        解释: 最长有效括号子串为 "()()"
public class P32_LongestValidParentheses {
    public int longestValidParentheses(String s) {
        if(s==null||s.equals("")){
            return 0;
        }
        int maxLen = 0;
        int[] flag = new int[s.length()];
        for(int i  = 1;i<s.length();i++){
            if(s.charAt(i)==')'){
                //寻找该')'之前的最大匹配
                if(i - flag[i - 1] - 1 >= 0&&s.charAt(i - flag[i - 1] - 1)=='('){
                    flag[i] = flag[i - 1] + 2;
                }
                //将前面不间断匹配加起来
                if(i - flag[i] >= 0){
                    flag[i] += flag[i - flag[i]];
                }
                maxLen = flag[i]>maxLen?flag[i]:maxLen;
            }
        }
        return maxLen;
    }
//    private int maxFlag(int[] flag){
//        int maxFlag = 0;
//        for(int i = 0;i<flag.length;i++){
//            maxFlag = flag[i]>maxFlag?flag[i]:maxFlag;
//        }
//        return maxFlag;
//    }
}
