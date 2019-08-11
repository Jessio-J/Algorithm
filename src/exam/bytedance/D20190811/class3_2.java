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
        int years[] = new int[n];
        int fee[] = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            years[i] = sc.nextInt();
        }
        PriorityQueue<node> nodes = new PriorityQueue<>(new Comparator<node>() {
            @Override
            public int compare(node o1, node o2) {
                return o1.val-o2.val;
            }
        });
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0;i<n;i++){
            node no = new node(years[i],i);
            nodes.offer(no);
        }
        while (!nodes.isEmpty()){
            int value = nodes.peek().val;
            ArrayList<Integer> list = new ArrayList<>();
            while (!nodes.isEmpty()&&nodes.peek().val==value){
                node no = nodes.poll();
                int curIndex = no.key;
                list.add(curIndex);
                if(curIndex==0){
                    if(set.contains(1))
                        fee[0] = fee[1]+100;
                    else
                        fee[0] = 100;
                    sum +=fee[0];
                }else if(curIndex==n-1){
                    if(set.contains(n-2))
                        fee[n-1] = fee[n-2]+100;
                    else
                        fee[n-1] = 100;
                    sum+=fee[n-1];
                }else {
                    if(set.contains(curIndex-1)&&set.contains(curIndex+1)){
                        fee[curIndex] = Math.max(fee[curIndex-1],fee[curIndex+1])+100;

                    }else if(set.contains(curIndex-1))
                        fee[curIndex] = fee[curIndex-1]+100;
                    else if(set.contains(curIndex+1))
                        fee[curIndex] = fee[curIndex+1]+100;
                    else
                        fee[curIndex] =100;
                    sum+=fee[curIndex];
                }
            }
            for(Integer i :list){
                set.add(i);
            }
        }
        System.out.println(sum);
    }
}
