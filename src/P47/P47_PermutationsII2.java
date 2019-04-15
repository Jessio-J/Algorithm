package P47;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P47_PermutationsII2 {
    List<List<Integer>> rlist = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        if(nums==null||nums.length==0){
            return rlist;
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i<nums.length;i++){
            list.add(nums[i]);
        }
        recursion(list,new ArrayList<>());
        return rlist;
    }
    private void recursion(List<Integer> list,List<Integer> result){
        if(list.size()==0){
            rlist.add(result);
            return;
        }else {
            Map<Integer,Integer> isExist = new HashMap<>();
            for(int num : list){
                if(!isExist.containsKey(num)){
                    List<Integer> nextList = new ArrayList<>();
                    List<Integer> nextresult = new ArrayList<>();
                    Integer n = num;
                    nextList.addAll(list);
                    nextList.remove(n);
                    nextresult.addAll(result);
                    nextresult.add(n);
                    recursion(nextList,nextresult);
                    isExist.put(num,1);
                }

            }
        }

    }
}
