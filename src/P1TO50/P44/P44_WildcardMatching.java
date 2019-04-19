package P1TO50.P44;
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
public class P44_WildcardMatching {
    public boolean isMatch(String s, String p) {
        int sl = s.length(), pl = p.length();
        boolean[][] m = new boolean[sl+1][pl+1];
        m[0][0] = true;
        for(int i = 0; i <= sl; i++) {
            for(int j = 1; j <= pl; j++) {
                if(p.charAt(j-1) == '*') {
                    m[i][j] = m[i][j-1] || (i > 0 && m[i-1][j]);
                }else {
                    m[i][j] = i > 0 && (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?')
                            && m[i-1][j-1];
                }
            }
        }
        return m[sl][pl];
    }
}
