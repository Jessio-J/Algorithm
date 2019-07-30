package exam.liulishuo.D20190730;

import java.util.*;

public class class1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String s = scanner.next();
            System.out.println(createHuf(s));
        }

    }
    public static int createHuf(String s){
        char[] chars = s.toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {

            if(map.containsKey(chars[i])){
                map.put(chars[i],map.get(chars[i])+1);
            }else {
                map.put(chars[i],1);
            }
        }
        PriorityQueue<HufNode>  queue = new PriorityQueue<>(map.size(), Comparator.comparingInt(o -> o.w));
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            queue.offer(new HufNode(entry.getValue(),entry.getKey()));
        }
        while (queue.size()>1){
            HufNode lnode = queue.poll();
            HufNode rnode = queue.poll();
            HufNode fatherNode = new HufNode(lnode.w+rnode.w);
            fatherNode.l = lnode;
            fatherNode.r = rnode;
            queue.offer(fatherNode);
        }
        HufNode root = queue.poll();
        return getLength(root,0);
    }
    public static int getLength(HufNode node,int depth){
        if(node==null){
            return 0;
        }else {
            return (node.ch==null?0:node.w)*depth+getLength(node.l,depth+1)+getLength(node.r,depth+1);
        }
    }
    static class HufNode{
        int w;
        HufNode l;
        HufNode r;
        Character ch;

        public HufNode(int w) {
            this.w = w;
        }

        public HufNode(int w, Character ch) {
            this.w = w;
            this.ch = ch;
        }
    }
}
