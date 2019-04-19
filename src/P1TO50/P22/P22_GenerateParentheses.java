package P1TO50.P22;

import java.util.ArrayList;
import java.util.List;
//给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
//
//        例如，给出 n = 3，生成结果为：
//
//        [
//        "((()))",
//        "(()())",
//        "(())()",
//        "()(())",
//        "()()()"
//        ]
//思路：迭代，错误解法，存在漏解情况
public class P22_GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> fl = new ArrayList<String>();
        if(n==1){
             fl.add("()");
        }else if(n>1){
            List<String> l = generateParenthesis(n-1);
            for(String s : l){
                fl.add("("+s+")");
                String ts = s+"()";
                String ts2 = "()"+s;
                int flag1 = 0;
                for(String fls :fl){
                    if(fls.equals(ts)){
                        flag1 = 1;
                    }
                }
                if(flag1==0){
                    fl.add(ts);
                }
                int flag2 = 0;
                for(String fls :fl){
                    if(fls.equals(ts2)){
                        flag2 = 1;
                    }
                }
                if(flag2==0){
                    fl.add(ts2);
                }
            }
        }
        return fl;
    }

}
