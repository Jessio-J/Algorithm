package P15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//先对数组排序，再将num1+num2+num3=0转换成num2+num3=0-num1来做。这里求两数之和用到了左右指针法，其中左指针指向num2，右指针指向num3.
// 因为数组是有序的，所以要使num2+num3和一定，1.连续相等的情况，只移动其中一边的指针，2.其余情况需要移动左右两边指针。
public class P15_3Sum2 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ls = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {  // 跳过可能重复的答案

                int l = i + 1, r = nums.length - 1, sum = 0 - nums[i];
                while (l < r) {
                    if (nums[l] + nums[r] == sum) {
                        ls.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        l++;
                        r--;
                    } else if (nums[l] + nums[r] < sum) {
                        while (l < r && nums[l] == nums[l + 1]) l++;   // 跳过重复值
                        l++;
                    } else {
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        r--;
                    }
                }
            }
        }
        return ls;
    }
}
