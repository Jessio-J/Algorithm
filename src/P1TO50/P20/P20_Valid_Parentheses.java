package P1TO50.P20;

import java.util.Stack;

//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//
//        有效字符串需满足：
//
//        左括号必须用相同类型的右括号闭合。
//        左括号必须以正确的顺序闭合。
//        注意空字符串可被认为是有效字符串。
//
//        示例 1:
//
//        输入: "()"
//        输出: true
//        示例 2:
//
//        输入: "()[]{}"
//        输出: true
//        示例 3:
//
//        输入: "(]"
//        输出: false
//        示例 4:
//
//        输入: "([)]"
//        输出: false
//        示例 5:
//
//        输入: "{[]}"
//        输出: true
public class P20_Valid_Parentheses {
    public boolean isValid(String s) {
        Stack<Character> ss = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('||s.charAt(i)=='['||s.charAt(i)=='{'){
                ss.push(s.charAt(i));
            }else if(s.charAt(i)==')'){
                if(ss.empty()){
                    return false;
                }
                char c = ss.pop();
                if(c!='('){
                    return false;
                }
            }else if(s.charAt(i)==']'){
                if(ss.empty()){
                    return false;
                }
                char c = ss.pop();
                if(c!='['){
                    return false;
                }
            }else if(s.charAt(i)=='}'){
                if(ss.empty()){
                    return false;
                }
                char c = ss.pop();
                if(c!='{'){
                    return false;
                }
            }
        }
        if(ss.empty()){
            return true;
        }else {
            return false;
        }
    }
}
