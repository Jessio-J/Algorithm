package P16;

import java.util.Arrays;

public class P16_3SumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {  // 跳过可能重复的答案

                int l = i + 1, r = nums.length - 1, perfectSum = target - nums[i];
                while (l < r) {
                    if (nums[l] + nums[r] == perfectSum) {
                        return target;
                    } else if (nums[l] + nums[r] < perfectSum) {
                        while (l < r && nums[l] == nums[l + 1]) l++;   // 跳过重复值
                        if(closest > Math.abs(nums[l] + nums[r] - perfectSum)){
                            closest = Math.abs(nums[l] + nums[r] - perfectSum);
                            sum = nums[l] + nums[r] + nums[i];
                        }
                        l++;
                    } else {
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        if(closest > Math.abs(nums[l] + nums[r] - perfectSum)){
                            closest = Math.abs(nums[l] + nums[r] - perfectSum);
                            sum = nums[l] + nums[r] + nums[i];
                        }
                        r--;
                    }
                }
            }
        }
        return sum;
    }
}
