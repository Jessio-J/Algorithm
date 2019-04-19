package P1TO50.P22;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P22_GenerateParentheses2 {
    public List<String> generateParenthesis(int n) {
        List<String> fl = new ArrayList<String>();
        Map<String,String> smap = new HashMap<>();

        if(n==1) {
            fl.add("()");
        }else if(n>1){
            for(int i=1;i<n;i++){
                List<String> l = generateParenthesis(i);
                List<String> r = generateParenthesis(n-i);
                for(String sl : l){
                    for (String sr : r){
                        if(sl.equals("()")){
                            smap.put("("+sr+")","1");
                        }
                        smap.put(sl+sr,"1");
                    }
                }

            }
        }
        if(!smap.isEmpty()){
            for(String key :smap.keySet()){
                fl.add(key);
            }
        }
        return fl;
    }
}
