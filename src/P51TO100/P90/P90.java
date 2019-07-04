package P51TO100.P90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> rList = new ArrayList<>();
        List<Integer> nullList = new ArrayList<>();
        rList.add(nullList);
        if (nums.length == 0) {
            return rList;
        }
        Arrays.sort(nums);
        int formerSize = 0;
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> tmprList = new ArrayList<>();
            tmprList.addAll(rList);
            int tempSize = 0;
            for (List<Integer> tmp : tmprList) {
                if(i>0&&nums[i]==nums[i-1]&&tempSize<formerSize){
                    tempSize++;
                    continue;
                }
                List<Integer> tmpList = new ArrayList<>();
                tmpList.addAll(tmp);
                tmpList.add(nums[i]);
                rList.add(tmpList);
            }
            formerSize = tmprList.size();
        }
        return rList;
    }
}
