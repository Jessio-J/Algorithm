package jianzhiOffer.P9;

import java.util.LinkedList;
import java.util.Queue;

public class P9_2 {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();
    public void push(int node) {
        if(q2.size()!=0){
            q2.offer(node);
        }else {
            q1.offer(node);
        }
    }

    public int pop() {
        int node = 0;
        while (q1.size()>0) {
            node = q1.poll();
            if(q1.size()>0){
                q2.offer(node);
            }
        }
        while (q2.size()>0) {
            node = q2.poll();
            if(q1.size()>0){
                q2.offer(node);
            }
        }
        return node;
    }
}
