package P151TOP200.P154;

import java.util.Stack;

public class P154 {
    class MinStack {
        Stack<Integer> stack;
        Stack<Integer> minStack;

        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int x) {
            if(minStack.empty()||(!minStack.empty()&&x<minStack.peek())){
                minStack.push(x);
            }else {
                minStack.push(minStack.peek());
            }
            stack.push(x);
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}
