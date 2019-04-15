package P47;

import java.util.ArrayList;
import java.util.List;

//给定一个可包含重复数字的序列，返回所有不重复的全排列。
//
//        示例:
//
//        输入: [1,1,2]
//        输出:
//        [
//        [1,1,2],
//        [1,2,1],
//        [2,1,1]
//        ]
public class P47_PermutationsII {
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 全排列函数
     *
     * @param nums
     * @param p    起始位置
     * @param q    结束位置（include）
     */
    public void perm(int[] nums, int p, int q) {

        if (p == q) {
            List<Integer> values = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                values.add(nums[i]);
            }
            list.add(values);
        } else if (p < q) {
            for (int i = p; i <= q; i++) {
                if(nums[i] != nums[p]||i==p){
                    swap(nums, p, i);
                    perm(nums, p + 1, q);
                    swap(nums, p, i);
                }
            }

        }
    }

    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {

        perm(nums, 0, nums.length - 1);
        return list;
    }
}
