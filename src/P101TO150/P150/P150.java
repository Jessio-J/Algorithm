package P101TO150.P150;

import java.util.Stack;

public class P150 {
    public int evalRPN(String[] tokens) {
        int result = 0;
        Stack<Integer> ts = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                result = (ts.pop()+ts.pop());
                ts.push(result);
            } else if (tokens[i].equals("-")) {
                int a = ts.pop();
                int b = ts.pop();
                result = (b-a);
                ts.push(result);
            } else if (tokens[i].equals("*")) {
                int a = ts.pop();
                int b = ts.pop();
                result = (b*a);
                ts.push(result);
            } else if (tokens[i].equals("/")) {
                int a = ts.pop();
                int b = ts.pop();
                result = (b/a);
                ts.push(result);
            }else {
                ts.push(Integer.parseInt(tokens[i]));
            }
        }
        if(!ts.empty()){
            return ts.pop();
        }
        return result;
    }
}
