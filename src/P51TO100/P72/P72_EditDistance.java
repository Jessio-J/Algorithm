package P51TO100.P72;

//给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
//
//        你可以对一个单词进行如下三种操作：
//
//        插入一个字符
//        删除一个字符
//        替换一个字符
//        示例 1:
//
//        输入: word1 = "horse", word2 = "ros"
//        输出: 3
//        解释:
//        horse -> rorse (将 'h' 替换为 'r')
//        rorse -> rose (删除 'r')
//        rose -> ros (删除 'e')
//        示例 2:
//
//        输入: word1 = "intention", word2 = "execution"
//        输出: 5
//        解释:
//        intention -> inention (删除 't')
//        inention -> enention (将 'i' 替换为 'e')
//        enention -> exention (将 'n' 替换为 'x')
//        exention -> exection (将 'n' 替换为 'c')
//        exection -> execution (插入 'u')
public class P72_EditDistance {
    public int minDistance(String word1, String word2) {
        if (word1.equals("") || word2.equals("")) {
            return word1.length() > 0 ? word1.length() : word2.length();
        }
        boolean flag1 = false;
        boolean flag2 = false;
        int[][] arr = new int[word1.length()][word2.length()];
        if (word1.charAt(0) == word2.charAt(0)) {
            flag1 = true;
            flag2 = true;
            arr[0][0] = 0;
        } else {
            arr[0][0] = 1;
        }
        for (int i = 1; i < word1.length(); i++) {
            if (word2.charAt(0) == word1.charAt(i) && !flag1) {
                arr[i][0] = arr[i - 1][0];
                flag1 = true;
            } else
                arr[i][0] = arr[i - 1][0] + 1;
        }
        for (int j = 1; j < word2.length(); j++) {
            if (word1.charAt(0) == word2.charAt(j) && !flag2) {
                arr[0][j] = arr[0][j - 1];
                flag2 = true;
            } else
                arr[0][j] = arr[0][j - 1] + 1;
        }
        for (int i = 1; i < word1.length(); i++) {
            for (int j = 1; j < word2.length(); j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    arr[i][j] = arr[i - 1][j - 1];
                } else {
                    int min = Math.min(Math.min(arr[i - 1][j], arr[i][j - 1]), arr[i - 1][j - 1]);
                    arr[i][j] = min + 1;
                }
            }
        }
        return arr[word1.length() - 1][word2.length() - 1];
    }
}
