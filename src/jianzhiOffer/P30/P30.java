package jianzhiOffer.P30;
import java.util.Stack;
public class P30 {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> min = new Stack<>();
    public void push(int node) {
        stack.push(node);
        if(min.empty()||min.peek()>node){
            min.push(node);
        }else {
            min.push(min.peek());
        }
    }

    public void pop() {
        if(min.empty()||stack.empty()){
            return;
        }
        min.pop();
        stack.pop();
    }

    public int top() {
        if(min.empty()||stack.empty()){
            return 0;
        }
        return stack.peek();
    }

    public int min() {
        if(min.empty()||stack.empty()){
            return 0;
        }
        return min.peek();
    }
}
