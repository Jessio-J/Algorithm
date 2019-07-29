package exam.pdd.D20190728;

import java.util.*;

public class class4 {

    static class Block {
        int id;
        int Li;
        int Wi;

        public Block(int id, int li, int wi) {
            this.id = id;
            Li = li;
            Wi = wi;
        }
    }

    static class Way{
        int curTotalWi;
        int maxWi;
        int curHi;
        List<Integer> bidList = new ArrayList<>();
        public Way(int curTotalWi, int maxWi, int curHi) {
            this.curTotalWi = curTotalWi;
            this.maxWi = maxWi;
            this.curHi = curHi;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n < 1) {
            return;
        }
        int[][] arr = new int[n][2];
        ArrayList<Block> blocks = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = sc.nextInt();
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i][1] = sc.nextInt();
        }
        for (int i = 0; i < arr.length; i++) {
            Block block = new Block(i + 1, arr[i][0], arr[i][1]);
            blocks.add(block);

        }
        Collections.sort(blocks, (o1, o2) -> {
            if (o1.Li < o2.Li) return -1;
            if (o1.Li > o2.Li) return 1;
            return 0;
        });
        Way[] ways = new Way[n];
        ways[0] = new Way(blocks.get(0).Wi,blocks.get(0).Wi,1);
        for (int i =1; i < n; i++) {
            if(blocks.get(i).Wi*7>=ways[i-1].curTotalWi){
                int maxWi = blocks.get(i).Wi>ways[i-1].maxWi?blocks.get(i).Wi:ways[i-1].maxWi;
                ways[i] = new Way(ways[i-1].curTotalWi+blocks.get(i).Wi,maxWi,ways[i-1].curHi+1);
                ways[i].bidList.add(blocks.get(i).id);
            }else if(blocks.get(i).Wi<ways[i-1].maxWi){
                int newMax = 0;
                for(Iterator<Integer> it = ways[i-1].bidList.iterator();it.hasNext();){
                    Integer integer = it.next();
                    if(integer==ways[i-1].maxWi){
                        it.remove();
                    }else if(integer>newMax){
                        newMax = integer;
                    }
                }
                ways[i-1].bidList.add(blocks.get(i).id);
                ways[i] = new Way(ways[i-1].curTotalWi+blocks.get(i).Wi-ways[i-1].maxWi,newMax,ways[i-1].curHi);
                ways[i].bidList = new ArrayList<>(ways[i-1].bidList);
            }else {
                ways[i] = ways[i-1];
            }
        }
        System.out.println(ways[n-1].curHi);

    }
}
