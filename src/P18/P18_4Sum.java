package P18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P18_4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ls = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {  // 跳过可能重复的答案
                for(int j = i+1;j< nums.length - 2;j++){
                    if (j == 1 ||(j > 1 && nums[j] != nums[j - 1] )||(j > 1 && nums[j] == nums[j - 1] && j-1 == i)) {  // 跳过可能重复的答案
                        int l = j + 1, r = nums.length - 1, sum = target - nums[j] - nums[i];
                        while (l < r) {
                            if (nums[l] + nums[r] == sum) {
                                ls.add(Arrays.asList(nums[i],nums[j], nums[l], nums[r]));
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

            }
        }
        return ls;
    }
}
