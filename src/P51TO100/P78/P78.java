package P51TO100.P78;

import java.util.ArrayList;
import java.util.List;

//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
//
//        说明：解集不能包含重复的子集。
//
//        示例:
//
//        输入: nums = [1,2,3]
//        输出:
//        [
//        [3],
//        [1],
//        [2],
//        [1,2,3],
//        [1,3],
//        [2,3],
//        [1,2],
//        []
//        ]
public class P78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> rList = new ArrayList<>();
        List<Integer> nullList = new ArrayList<>();
        rList.add(nullList);
        if (nums.length == 0) {
            return rList;
        }
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> tmprList = new ArrayList<>();
            tmprList.addAll(rList);
            for (List<Integer> tmp : tmprList) {
                List<Integer> tmpList = new ArrayList<>();
                tmpList.addAll(tmp);
                tmpList.add(nums[i]);
                rList.add(tmpList);
            }
        }
        return rList;
    }
}
