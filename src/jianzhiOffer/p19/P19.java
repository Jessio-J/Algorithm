package jianzhiOffer.p19;

public class P19 {
    public boolean match(char[] str, char[] pattern) {
        int sl = str.length, pl = pattern.length;
        boolean[][] m = new boolean[sl+1][pl+1];
        m[0][0] = true;
        for(int i = 0; i <= sl; i++) {
            for(int j = 1; j <= pl; j++) {
                if(pattern[j-1] == '*') {
                    m[i][j] = m[i][j-2] || (i > 0 && (str[i-1] == pattern[j-2] ||
                            pattern[j-2] == '.') && m[i-1][j]);
                }else {
                    m[i][j] = i > 0 && (str[i-1] == pattern[j-1] || pattern[j-1] == '.')
                            && m[i-1][j-1];
                }
            }
        }
        return m[sl][pl];
    }
}
