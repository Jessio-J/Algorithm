# 题目
请实现一个函数用来匹配包括'.'和' * '的正则表达式。模式中的字符'.'表示任意一个字符，而' * '表示它前面的字符可以出现任意次（包含0次）。 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab * ac * a"匹配，但是与"aa.a"和"ab*a"均不匹配
# 题目
给定一个字符串 (s) 和一个字符模式 (p)。实现支持 '.' 和 '*' 的正则表达式匹配。

'.' 匹配任意单个字符。
'*' 匹配零个或多个前面的元素。
匹配应该覆盖整个字符串 (s) ，而不是部分字符串。

说明:
s 可能为空，且只包含从 a-z 的小写字母。
p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
>示例 1:
输入:
s = "aa"
p = "a"
输出: false
解释: "a" 无法匹配 "aa" 整个字符串。

>示例 2:
输入:
s = "aa"
p = "a * "
输出: true
解释: '*' 代表可匹配零个或多个前面的元素, 即可以匹配 'a' 。因此, 重复 'a' 一次, 字符串可变为 "aa"。

>示例 3:
输入:
s = "ab"
p = ". * "
输出: true
解释: " . * " 表示可匹配零个或多个('*')任意字符('.')。

>示例 4:
输入:
s = "aab"
p = "c * a * b"
输出: true
解释: 'c' 可以不被重复, 'a' 可以被重复一次。因此可以匹配字符串 "aab"。

>示例 5:
输入:
s = "mississippi"
p = "mis * is * p * . "
输出: false

# 算法
```java
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
```
思路，本题采用动态规划算法进行解题。
1.构造m[sl+1][pl+1]容量的布尔数组，m[i][j]表示s（0 ~ i-1）和 p（0 ~ j-1）是否匹配
分为两种情况：
扫描p（j-1）即p的第j位为 ‘ * ’ 时
1.  ‘ * ’匹配了0次 m[i][j] = m[i][j-2]，如下图
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190413104434804.png)
2. ‘ * ’匹配了1次及以上，则必然有m[i][j] =  m[i-1][j]（若s[i-1]和p[j-1]匹配，去掉s中的这次匹配，原s[i-2]和p[j-1]仍然匹配），其中保证 s.charAt(i-1) == p.charAt(j-2) 或者 p.charAt(j-2) == '.'
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190413104507674.png)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190413104932290.png)
扫描p（j-1）即p的第j位不为‘ * ’时
1.  保证s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.'
 ![在这里插入图片描述](https://img-blog.csdnimg.cn/20190413105516219.png)
最后得出 m[sl][pl]即为s和p是否匹配