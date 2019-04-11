package P40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
//        candidates 中的每个数字在每个组合中只能使用一次。
//
//        说明：
//
//        所有数字（包括目标数）都是正整数。
//        解集不能包含重复的组合。
//        示例 1:
//
//        输入: candidates = [10,1,2,7,6,1,5], target = 8,
//        所求解集为:
//        [
//        [1, 7],
//        [1, 2, 5],
//        [2, 6],
//        [1, 1, 6]
//        ]
//        示例 2:
//
//        输入: candidates = [2,5,2,1,2], target = 5,
//        所求解集为:
//        [
//        [1,2,2],
//        [5]
//        ]
public class P40_CombinationSumII {
    List<List<Integer>> rlist = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        if (candidates == null || candidates.length == 0 || candidates[0] > target) {
            return rlist;
        }
        recursion(candidates, 0, 0, target, new ArrayList<Integer>());
        return rlist;

    }

    private void recursion(int[] candi, int index, int lastSum, int target, List<Integer> list) {

        for (int i = index; i < candi.length; i++) {
            if (lastSum + candi[i] <= target) {
                List<Integer> listCur = new ArrayList<>(list);
                listCur.add(candi[i]);
                recursion(candi, i+1, lastSum + candi[i], target, listCur);
                //去除可能重复的解
                while(i+1<candi.length&&candi[i]==candi[i+1]){
                    i++;
                }
            } else if (lastSum + candi[i] > target) {
                break;
            }
        }
        if (lastSum == target) {
            rlist.add(list);
        }
    }
}
