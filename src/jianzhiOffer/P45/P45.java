package jianzhiOffer.P45;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class P45 {
    public String PrintMinNumber(int [] numbers) {
        int n;
        String s="";
        List<Integer> list=new ArrayList<Integer>();
        n=numbers.length;

        for(int i=0;i<n;i++){
            list.add(numbers[i]);//将数组放入arrayList中
        }
        //实现了Comparator接口的compare方法，将集合元素按照compare方法的规则进行排序
        Collections.sort(list,new Comparator<Integer>(){

            @Override
            public int compare(Integer str1, Integer str2) {
                // TODO Auto-generated method stub
                String s1=str1+""+str2;
                String s2=str2+""+str1;

                return s1.compareTo(s2);
            }
        });

        for(int j:list){
            s+=j;
        }
        return s;
    }
}
