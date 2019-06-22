package P101TO150.P127;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);

        if (!dict.contains(endWord)) return 0;
        //开始端
        Set<String> s1 = new HashSet<>();
        //结束端
        Set<String> s2 = new HashSet<>();
        s1.add(beginWord); s2.add(endWord);
        return helper(dict, s1, s2, 1);
    }
    private int helper(Set<String> d, Set<String> s1, Set<String> s2, int l) {
        if (s1.isEmpty()) return 0;
        if (s1.size() > s2.size()) return helper(d, s2, s1, l);
        //从集合中删掉开始端和结束端的所有单词
        d.removeAll(s1);
        d.removeAll(s2);
        Set<String> set = new HashSet<String>();
        //对于开始端的所有单词
        for (String s : s1) {
            //对于某个单词的每个字母
            for (int i = 0; i < s.length(); i++) {
                char[] c = s.toCharArray();
                for (char j = 'a'; j <= 'z'; j++) {
                    c[i] = j;
                    //将该字母依次从a替换到z
                    //1.结束端有，结果加1
                    //2.字典中有，加入到开始端
                    String str = new String(c);
                    if (s2.contains(str)) return l + 1;
                    if (d.contains(str)) set.add(str);
                }
            }
        }
        return helper(d, s2, set, l + 1);
    }
}
