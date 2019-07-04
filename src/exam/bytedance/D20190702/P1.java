package exam.bytedance.D20190702;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        Map<String,Integer> map1 = new HashMap<>();
        int score1 = 0;
        int score2 = 0;
        int[] s1 = new int[3];
        int[] s2 = new int[3];
        for(int i = 0;i<26;i++){
            s1[i] = in.nextInt();
        }
        for(int i = 0;i<26;i++){
            s2[i] = in.nextInt();
        }

        for(int i = 0;i<26;i++){
            if(map1.containsKey(String.valueOf(s1[i]))){
                int index = map1.get(String.valueOf(s1[i]));
                score1+= getbet(map1,index,2*i);
                remove(map1,index,2*i);
            }else {
                map1.put(String.valueOf(s1[i]),2*i);
            }
            if(map1.containsKey(String.valueOf(s2[i]))){
                int index = map1.get(String.valueOf(s2[i]));
                score1+= getbet(map1,index,2*i+1);
                remove(map1,index,2*i+1);
            }else {
                map1.put(String.valueOf(s2[i]),2*i+1);
            }

        }
        if(score1<score2){
            System.out.println("Byte");
        }else if(score1>score2){
            System.out.println("Dance");
        }else {
            System.out.println("Draw");
        }

    }
    public static void remove(Map<String,Integer> map,int i,int j){
        Map<String,Integer> tmp = new HashMap<>();
        tmp.putAll(map);
        for(String key : tmp.keySet()){
            if(tmp.get(key)>=i&&tmp.get(key)<=j){
                map.remove(key);
            }
        }
    }
    public static int getbet(Map<String,Integer> map,int i,int j){
        int count=0;
        for(String key : map.keySet()){
            if(map.get(key)>=i&&map.get(key)<=j){
                count++;
            }
        }
        return count;
    }
}
