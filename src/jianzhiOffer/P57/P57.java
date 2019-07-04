package jianzhiOffer.P57;

import java.util.ArrayList;
import java.util.List;

public class P57 {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        int i = 0;
        int j = array.length-1;
        int minmul = Integer.MAX_VALUE;
        int minindex = 0;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        while(i<j){
            if(array[i]+array[j]==sum){
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.add(array[i]);
                tmp.add(array[j]);
                int mul = array[i]*array[j];
                list.add(tmp);
                if(mul<minmul){
                    minmul = mul;
                    minindex = list.size()-1;
                }
                while (i+1<j&&array[i+1]==array[i])i++;
                while (j-1>i&&array[j-1]==array[j])j--;
                i++;
            }else if(array[i]+array[j]>sum){
                j--;
            }else {
                i++;
            }
        }
        return list.size()==0?new ArrayList<>():list.get(minindex);
    }
}
