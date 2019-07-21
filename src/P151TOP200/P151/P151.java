package P151TOP200.P151;

import java.util.Stack;

public class P151 {
    public String reverseWords(String s) {
        String[] sarr = s.trim().split(" ");
        Stack<String> ss = new Stack<>();
        for (String si : sarr) {
            if (!si.equals(""))
                ss.push(si);
        }
        StringBuilder sb = new StringBuilder();
        while (!ss.empty()) {
            sb.append(ss.pop()).append(" ");
        }
        return sb.toString().trim();
    }
}
