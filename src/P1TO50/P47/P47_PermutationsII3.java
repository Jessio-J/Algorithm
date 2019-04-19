package P1TO50.P47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//深度优先
public class P47_PermutationsII3 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums); //必须要排序，不然也不能去重 ,为了让重复的元素相邻
        dfs(res, nums, 0);
        return res;
    }

    public void dfs(List<List<Integer>> res, int[] nums, int cur) {
        int[] newNums = Arrays.copyOf(nums, nums.length);
        if (cur == newNums.length) {
            List<Integer> temp = new ArrayList<>();
            for (Integer item : newNums) temp.add(item);
            res.add(temp); //这里不需要再次判断重复
        } else{
            for (int i = cur; i < newNums.length; i++) {
                if (cur != i && newNums[i] == newNums[cur]) continue; //去重
                swap(newNums, cur, i);
                dfs(res, newNums, cur + 1);
//            swap(newNums,cur,i); //不能交换 不然也不能去重
            }
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}