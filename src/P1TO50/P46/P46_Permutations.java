package P1TO50.P46;

import java.util.ArrayList;
import java.util.List;

//给定一个没有重复数字的序列，返回其所有可能的全排列。
//
//        示例:
//
//        输入: [1,2,3]
//        输出:
//        [
//        [1,2,3],
//        [1,3,2],
//        [2,1,3],
//        [2,3,1],
//        [3,1,2],
//        [3,2,1]
//        ]
public class P46_Permutations {
    List<List<Integer>> rlist = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
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
            for(int num : list){
                List<Integer> nextList = new ArrayList<>();
                List<Integer> nextresult = new ArrayList<>();
                Integer n = num;
                nextList.addAll(list);
                nextList.remove(n);
                nextresult.addAll(result);
                nextresult.add(n);
                recursion(nextList,nextresult);
            }
        }

    }
}
