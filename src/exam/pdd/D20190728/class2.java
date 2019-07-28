package exam.pdd.D20190728;

import java.util.*;

public class class2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] sarr = s.split(" ");
        HashMap<Character, Integer> headMap = new HashMap<>();
        HashMap<Character, Integer> tailMap = new HashMap<>();
        HashMap<Character, Integer> selfMap = new HashMap<>();

        for (int i = 0; i < sarr.length; i++) {
            char c1 = sarr[i].charAt(0);
            char c2 = sarr[i].charAt(sarr[i].length()-1);
            if(c1==c2){
                int count1 = selfMap.get(c1)==null?0:selfMap.get(c1);
                selfMap.put(c1,count1+1);
                continue;
            }
            int count2 = headMap.get(c1)==null?0:headMap.get(c1);
            headMap.put(c1,count2+1);
            int count3 = tailMap.get(c2)==null?0:tailMap.get(c2);
            tailMap.put(c2,count3+1);
//            headMap.put(c1,headMap.getOrDefault(c1,0)+1);
//            tailMap.put(c2,headMap.getOrDefault(c2,0)+1);
        }


            for (Character c : tailMap.keySet()) {
                if(tailMap.get(c)!=headMap.get(c)){
                    System.out.println("false");
                    return;
                }
            }
            if(headMap.size()<=0){
                if(selfMap.size()>1){
                    System.out.println("false");
                    return;
                }else {
                    System.out.println("true");
                    return;
                }
            }else {
                for(Character key :selfMap.keySet()){
                    boolean boo = false;
                    if(headMap.get(key)!=null&&headMap.get(key)>0)boo=true;
                    if(tailMap.get(key)!=null&&tailMap.get(key)>0)boo=true;
                    if(!boo){
                        System.out.println("false");
                        return;
                    }
                }
                System.out.println("true");
                return;
            }
    }

}
