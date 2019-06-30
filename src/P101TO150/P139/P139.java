package P101TO150.P139;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
// 回溯解题超出时间限制
// 此解法超出时间限制
public class P139 {
    private boolean flag = false;
    public boolean wordBreak(String s, List<String> wordDict) {
        Map<String, String> dict = new HashMap<>();
        for(String word:wordDict){
            if(!dict.containsKey(word)){
                dict.put(word,"");
            }
        }
        find(s,0,dict);
        return flag;
    }
    private void find(String s,int index,Map<String, String> dict){
        if(!flag){
            if(index == s.length()){
                flag = true;
                return;
            }else {
                for(int i =s.length();i>index;i--){
                    String sub = s.substring(index,i);
                    if(dict.containsKey(sub)){
                        find(s,i,dict);
                    }
                }
            }
        }
    }
}
