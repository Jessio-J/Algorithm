package jianzhiOffer.P57;

import java.util.ArrayList;

public class P57_2 {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> rList = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        int curNum = 2;
        int tmpSum = 3;
        while (list.size()>1){
            if(tmpSum==sum){
                ArrayList<Integer> tmpList = new ArrayList<>();
                tmpList.addAll(list);
                rList.add(tmpList);
                curNum++;
                tmpSum+=curNum;
                list.add(curNum);
            }else if(tmpSum<sum){
                curNum++;
                tmpSum+=curNum;
                list.add(curNum);
            }else {
                tmpSum -= list.get(0);
                list.remove(0);
            }
        }
        return rList;
    }
}
