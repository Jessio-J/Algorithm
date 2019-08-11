package exam.bytedance.D20190811;

import java.util.*;

public class class3_2 {
    static class node{
        int val;
        int key;

        public node(int val, int key) {
            this.val = val;
            this.key = key;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cur1[] = new int[n];
        int cur2[] = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            cur1[i] = sc.nextInt();
        }
        PriorityQueue<node> map = new PriorityQueue<>(new Comparator<node>() {
            @Override
            public int compare(node o1, node o2) {
                return o1.val-o2.val;
            }
        });
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0;i<n;i++){
            node no = new node(cur1[i],i);
            map.offer(no);
        }
        while (!map.isEmpty()){
            int value = map.peek().val;
            ArrayList<Integer> list = new ArrayList<>();
            while (!map.isEmpty()&&map.peek().val==value){
                node no = map.poll();
                int cur = no.key;
                list.add(cur);
                if(cur==0){
                    if(set.contains(1))
                        cur2[0] = cur2[1]+100;
                    else
                        cur2[0] = 100;
                    sum +=cur2[0];
                }else if(cur==n-1){
                    if(set.contains(n-2))
                        cur2[n-1] = cur2[n-2]+100;
                    else
                        cur2[n-1] = 100;
                    sum+=cur2[n-1];
                }else {
                    if(set.contains(cur-1)&&set.contains(cur+1)){
                        cur2[cur] = Math.max(cur2[cur-1],cur2[cur+1])+100;

                    }else if(set.contains(cur-1))
                        cur2[cur] = cur2[cur-1]+100;
                    else if(set.contains(cur+1))
                        cur2[cur] = cur2[cur+1]+100;
                    else
                        cur2[cur] =100;
                    sum+=cur2[cur];
                }
            }
            for(Integer i :list){
                set.add(i);
            }
        }
        System.out.println(sum);
    }
}
