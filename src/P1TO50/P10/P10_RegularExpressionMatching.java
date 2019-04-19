package P1TO50.P10;

//给定一个字符串 (s) 和一个字符模式 (p)。实现支持 '.' 和 '*' 的正则表达式匹配。
//
//        '.' 匹配任意单个字符。
//        '*' 匹配零个或多个前面的元素。
//        匹配应该覆盖整个字符串 (s) ，而不是部分字符串。
//
//        说明:
//
//        s 可能为空，且只包含从 a-z 的小写字母。
//        p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
//        示例 1:
//
//        输入:
//        s = "aa"
//        p = "a"
//        输出: false
//        解释: "a" 无法匹配 "aa" 整个字符串。
//        示例 2:
//
//        输入:
//        s = "aa"
//        p = "a*"
//        输出: true
//        解释: '*' 代表可匹配零个或多个前面的元素, 即可以匹配 'a' 。因此, 重复 'a' 一次, 字符串可变为 "aa"。
//        示例 3:
//
//        输入:
//        s = "ab"
//        p = ".*"
//        输出: true
//        解释: ".*" 表示可匹配零个或多个('*')任意字符('.')。
//        示例 4:
//
//        输入:
//        s = "aab"
//        p = "c*a*b"
//        输出: true
//        解释: 'c' 可以不被重复, 'a' 可以被重复一次。因此可以匹配字符串 "aab"。
//        示例 5:
//
//        输入:
//        s = "mississippi"
//        p = "mis*is*p*."
//        输出: false

public class P10_RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        int sl = s.length(), pl = p.length();
        boolean[][] m = new boolean[sl+1][pl+1];
        m[0][0] = true;
        for(int i = 0; i <= sl; i++) {
            for(int j = 1; j <= pl; j++) {
                if(p.charAt(j-1) == '*') {
                    m[i][j] = m[i][j-2] || (i > 0 && (s.charAt(i-1) == p.charAt(j-2) ||
                            p.charAt(j-2) == '.') && m[i-1][j]);
                }else {
                    m[i][j] = i > 0 && (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.')
                            && m[i-1][j-1];
                }
            }
        }
        return m[sl][pl];
    }
}
