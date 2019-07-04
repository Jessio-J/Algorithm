package jianzhiOffer.P31;

import java.util.Stack;

//输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
public class P31 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        boolean p = false;
        if(pushA!=null&&popA!=null&&pushA.length>0){
            int i = 0;
            int j = 0;
            Stack<Integer> stack = new Stack<>();
            while(j<popA.length){
                while(stack.empty()||stack.peek()!=popA[j]){
                    if(i==pushA.length)
                        break;
                    stack.push(pushA[i]);
                    i++;
                }
                if(stack.peek()!=popA[j])
                    break;
                stack.pop();
                j++;
            }
            if(stack.empty()&&j==popA.length){
                p = true;
            }
        }
        return p;
    }
}
