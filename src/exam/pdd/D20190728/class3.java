package exam.pdd.D20190728;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class class3 {
    static class Task{
        int id;
        int time;
        int waits = 0;
        LinkedList<Integer> refs = new LinkedList<>();
        public Task(int id, int time) {
            this.id = id;
            this.time = time;
        }

    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        PriorityQueue<Task> can = new PriorityQueue<>(new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                if(o1.time<o2.time)return -1;
                if(o1.time>o2.time)return 1;
                if(o1.id<o2.id)return -1;
                if(o1.id>o2.id)return 1;
                return 0;
            }
        });
        int m,n;
        n = s.nextInt();
        m = s.nextInt();
        Task[] tasks = new Task[n+1];
        for (int i = 1; i <= n; i++) {
            int time = s.nextInt();
            tasks[i] = new Task(i,time);
        }
        for (int i = 0; i < m; i++) {
            int ai = s.nextInt();
            int bi = s.nextInt();
            tasks[bi].waits++;
            tasks[ai].refs.add(bi);
        }
        for (int i = 1; i <= n; i++) {

            if(tasks[i].waits==0)can.add(tasks[i]);
        }
        Task next = can.poll();
        StringBuilder builder = new StringBuilder();
        builder.append(next.id);
        while (next!=null){
            for (Integer t : next.refs) {
                Task temp = tasks[t];
                temp.waits--;
                if(temp.waits==0){
                    can.add(temp);
                }
            }
            next = can.poll();
            if(next!=null){
                builder.append(" "+next.id);

            }
        }
        System.out.println(builder.toString());

    }
}
