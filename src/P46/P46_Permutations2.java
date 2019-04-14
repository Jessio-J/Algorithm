package P46;

import java.util.ArrayList;
import java.util.List;

public class P46_Permutations2 {
    public static void swap(int[] nums, int i, int j) {
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
        }else if(p < q){
            for (int i = p; i <= q; i++) {
                swap(nums, p, i);
                perm(nums, p + 1, q);
                swap(nums, p, i);
            }

        }
    }

    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {

        perm(nums, 0, nums.length - 1);
        return list;
    }
}
