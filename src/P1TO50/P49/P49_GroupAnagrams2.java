package P1TO50.P49;

import java.util.*;

public class P49_GroupAnagrams2 {
    public List<List<String>> groupAnagrams(String[] strs) {
//        map的key对应着排序后的单词，value为所有经过排序能编程key的单词list
        Map<String, List<String>> map = new HashMap<>();
        for(String word : strs) {
//            把单词转换成字符数组，再进行排序
            char c[] = word.toCharArray();
            Arrays.sort(c);
            String w = new String(c);
//            对Map的操作
            List<String> l = map.getOrDefault(w, new ArrayList<>());
            l.add(word);
            map.put(w, l);
        }
        return new ArrayList<>(map.values());
    }
}
