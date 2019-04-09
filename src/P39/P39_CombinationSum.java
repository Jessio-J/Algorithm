package P39;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
//        candidates 中的数字可以无限制重复被选取。
//
//        说明：
//
//        所有数字（包括 target）都是正整数。
//        解集不能包含重复的组合。
//        示例 1:
//
//        输入: candidates = [2,3,6,7], target = 7,
//        所求解集为:
//        [
//        [7],
//        [2,2,3]
//        ]
//        示例 2:
//
//        输入: candidates = [2,3,5], target = 8,
//        所求解集为:
//        [
//        [2,2,2,2],
//        [2,3,3],
//        [3,5]
//        ]
public class P39_CombinationSum {
    List<List<Integer>> rlist = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates==null||candidates.length==0||candidates[0]>target){
            return null;
        }
        recursion(candidates,0,0,target,new ArrayList<Integer>());
        return rlist;

    }

    private void recursion(int[] candi, int index, int lastSum, int target, List<Integer> list) {
        if (lastSum + candi[index] == target) {
            list.add(candi[index]);
            rlist.add(list);
        } else if (lastSum + candi[index] > target) {
            if (list.size() > 0&&index+1<candi.length) {
                int lastNum = list.get(list.size() - 1);
                list.remove(list.size() - 1);
                recursion(candi, index + 1, lastSum - lastNum, target, list);
            }
        }
        for (int i = index; i < candi.length; i++) {
            if(lastSum+candi[i]<target){
                list.add(candi[i]);
                recursion(candi, i, lastSum + candi[i], target, list);
            }
        }


    }
}
