package P1TO50.P49;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
//
//        示例:
//
//        输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
//        输出:
//        [
//        ["ate","eat","tea"],
//        ["nat","tan"],
//        ["bat"]
//        ]
//        说明：
//
//        所有输入均为小写字母。
//        不考虑答案输出的顺序。
public class P49_GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<Map<Integer,Integer>> ml = new ArrayList<>();
        List<List<String>> rl = new ArrayList<>();
        for(int i = 0;i<strs.length;i++){
            Map<Integer,Integer> resMap = new HashMap<>();
            for(int j = 0;j<strs[i].length();j++){
                int num = strs[i].charAt(j)-'a';
                resMap.put(num,resMap.getOrDefault(num,0)+1);
            }
            boolean flag = false;
            int k;
            for(k = 0;k<ml.size();k++){
                Map<Integer,Integer> map = ml.get(k);
                if(map.equals(resMap)){
                    flag = true;
                    break;
                }
            }
            if(flag ==false){
                List<String> templ = new ArrayList<>();
                templ.add(strs[i]);
                ml.add(resMap);
                rl.add(templ);
            }else {
                List<String> templ = rl.get(k);
                templ.add(strs[i]);
            }
        }
        return rl;
    }
}
