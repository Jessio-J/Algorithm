package P101TO150.P118;

import java.util.ArrayList;
import java.util.List;

public class P118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rList = new ArrayList<>();
        for(int i = 1;i<=numRows;i++){
            addRows(i,rList);
        }
        return rList;
    }
    private void addRows(int numRows,List<List<Integer>> rList){
        if(numRows==1){
            List<Integer> tmpList = new ArrayList<>();
            tmpList.add(1);
            rList.add(tmpList);
        }else if(numRows>1){
            List<Integer> tmpList = new ArrayList<>();
            tmpList.addAll(rList.get(numRows-2));
            List<Integer> rTempList = new ArrayList<>();
            rTempList.add(1);
            for(int i = 0;i<tmpList.size()-1;i++){
                int sum = tmpList.get(i)+tmpList.get(i+1);
                rTempList.add(sum);
            }
            rTempList.add(1);
            rList.add(rTempList);
        }
    }
}
