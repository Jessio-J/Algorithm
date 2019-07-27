package jianzhiOffer.P58;

import java.util.Stack;

public class P58 {
    public String ReverseSentence(String str) {
        if(str.trim().length()==0){
            return str;
        }
        StringBuilder sb = new StringBuilder();
        String[] arr = str.split(" ");
        //可以不使用栈，直接数组反向输出即可
        Stack<String> st = new Stack<>();
        for(String s:arr){
            st.push(s);
        }
        while (!st.empty()){
            sb.append(st.pop()).append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}
